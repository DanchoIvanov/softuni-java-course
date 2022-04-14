import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChatLogger{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <String> chatLog = new ArrayList<String>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String command = input.split("\\s+")[0];
            switch (command){
                case "Chat":
                    String message = input.split("\\s+")[1];
                    chatLog.add(message);
                    break;
                case "Delete":
                    String messageToDelete = input.split("\\s+")[1];
                    chatLog.remove(messageToDelete);
                    break;
                case "Edit":
                    String messageToEdit = input.split("\\s+")[1];
                    String editedVersion = input.split("\\s+")[2];
                    if (chatLog.contains(messageToEdit)) {
                        int index = chatLog.indexOf(messageToEdit);
                        chatLog.set(index, editedVersion);
                    }
                    break;
                case "Pin":
                    String messageToPin = input.split("\\s+")[1];
                    if (chatLog.contains(messageToPin)) {
                        chatLog.remove(messageToPin);
                        chatLog.add(messageToPin);
                    }
                    break;
                case "Spam":
                    List<String> spamMessages = Arrays
                            .stream(input.split("\\s+"))
                            .collect(Collectors.toList());
                    for (int i = 1; i < spamMessages.size() ; i++) {
                        chatLog.add(spamMessages.get(i));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (String message : chatLog) {
            System.out.println(message);
        }
    }
}
