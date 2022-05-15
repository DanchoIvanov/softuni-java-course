package core;

import models.Message;

import java.util.*;

public class DiscordImpl implements Discord {
    Map<String, Message> messagesByIDOrdered = new LinkedHashMap<>();
    Map<String, Set<Message>> messagesByChanelOrdered = new HashMap<>();
    Map<Integer, Set<Message>> messagesByTimeStampOrdered = new TreeMap<>();

    @Override
    public void sendMessage(Message message) {
        //●	void sendMessage(Message message) – adds a message to Discord.
        messagesByIDOrdered.putIfAbsent(message.getId(), message);

        messagesByChanelOrdered.putIfAbsent(message.getChannel(), new LinkedHashSet<>());
        messagesByChanelOrdered.get(message.getChannel()).add(message);

        messagesByTimeStampOrdered.putIfAbsent(message.getTimestamp(), new LinkedHashSet<>());
        messagesByTimeStampOrdered.get(message.getTimestamp()).add(message);
    }

    @Override
    public boolean contains(Message message) {
        //●	bool contains(Message message) – returns whether the message is contained inside Discord.
        return messagesByIDOrdered.containsKey(message.getId());
    }

    @Override
    public int size() {
        //●	int size() – returns the total count of all messages.
        return messagesByIDOrdered.size();
    }

    @Override
    public Message getMessage(String messageId) {
        //●	Message getMessage(String messageId) – retrieves the message with the given id.
        //If there is no such message - throw IllegalArgumentException()
        Message result = this.messagesByIDOrdered.get(messageId);

        if (result == null) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    @Override
    public void deleteMessage(String messageId) {
        //●	void deleteMessage(String messageId) – removes the message with the given id.
        //If there is no such message - throw IllegalArgumentException()

        Message toRemove = messagesByIDOrdered.remove(messageId);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        messagesByChanelOrdered.get(toRemove.getChannel()).remove(toRemove);
        messagesByTimeStampOrdered.get(toRemove.getTimestamp()).remove(toRemove);
    }

    @Override
    public void reactToMessage(String messageId, String reaction) {
        //●	void reactToMessage(String messageId, String reaction) – adds the given reaction to the message with the given id
        //If there is no such message - throw IllegalArgumentException()

        Message toReact = this.getMessage(messageId);
        toReact.getReactions().add(reaction);
    }

    @Override
    public Iterable<Message> getChannelMessages(String channel) {
        //●	Iterable<Message> getChannelMessages(String channel) – returns all messages, which are in the given channel.
        //If there are no messages in the given channel - throw IllegalArgumentException()
        Set<Message> result = messagesByChanelOrdered.get(channel);

        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    @Override
    public Iterable<Message> getMessagesByReactions(List<String> reactions) {
        //●	Iterable<Message> getMessagesByReactions(List<String> reactions) – returns all messages,
        // which contain ALL  of the given reactions,
        // ordered by count of reactions in descending order and by timestamp in ascending order.

        Comparator<Message> orderByReactionCountDescTimeStampAsc = (t, o) -> {
            int cmp = Integer.compare(o.getReactions().size(), t.getReactions().size());
            if (cmp == 0) {
                cmp = Integer.compare(t.getTimestamp(), o.getTimestamp());
            }
            return cmp;
        };

        List<Message> result = new ArrayList<>();

        for (Message message : messagesByIDOrdered.values()) {
            List<String> messageReactions = message.getReactions();
            if (messageReactions.containsAll(reactions)) {
                result.add(message);
            }
        }

        result.sort(orderByReactionCountDescTimeStampAsc);

        return result;
    }

    @Override
    public Iterable<Message> getMessageInTimeRange(Integer lowerBound, Integer upperBound) {
        //●	Iterable<Message> getMessagesInTimeRange(int lowerBound, int upperBound) –
        // returns all of the messages with timestamp in the range specified with lower bound and upper bound.
        // Both bounds are inclusive.
        // The results should be ordered by count of total messages contained in each message’s channel, in descending order.
        // If there aren’t any messages in the specified range – return an empty collection.

        List<Message> result = new ArrayList<>();
        for (Integer timeStamp : messagesByTimeStampOrdered.keySet()) {
            if (timeStamp > upperBound) {
                break;
            }
            if (timeStamp >= lowerBound) {
                result.addAll(messagesByTimeStampOrdered.get(timeStamp));
            }
        }

        Comparator<Message> orderByCountOfMessagesInChanelDesc = (t, o) -> Integer.compare(
                messagesByChanelOrdered.get(o.getChannel()).size(),
                        messagesByChanelOrdered.get(t.getChannel()).size());

        result.sort(orderByCountOfMessagesInChanelDesc);

        return result;
    }

    @Override
    public Iterable<Message> getTop3MostReactedMessages() {
        //●	Iterable<Message> getTop3MostReactedMessages() – returns the top 3 messages in terms of count of reactions
        // in descending order. If there aren’t any messages – return an empty collection.

        List<Message> result = new ArrayList<>(messagesByIDOrdered.values());

        Comparator<Message> orderByReactionsCountDesc = (t, o) -> Integer.compare(
                o.getReactions().size(), t.getReactions().size());

        result.sort(orderByReactionsCountDesc);

        if (result.size() > 3) {
            result = result.subList(0, 3);
        }

        return result;
    }

    @Override
    public Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent() {
        //●	Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent()
        // – returns all of the messages ordered by count of reactions in descending order,
        // then by timestamp in ascending order and then by length of content in ascending order.
        // If there aren’t any messages – return an empty collection.

        List<Message> result = new ArrayList<>(messagesByIDOrdered.values());

        Comparator<Message> orderByReactionsCountDescTimeStampAscLengthOfContentAsc = (t, o) -> {
            int cmp = Integer.compare(o.getReactions().size(), t.getReactions().size());
            if (cmp == 0) {
                cmp = Integer.compare(t.getTimestamp(), o.getTimestamp());
            }
            if (cmp == 0) {
                cmp = Integer.compare(t.getContent().length(), o.getContent().length());
            }

            return cmp;
        };

        result.sort(orderByReactionsCountDescTimeStampAscLengthOfContentAsc);

        return result;
    }
}
