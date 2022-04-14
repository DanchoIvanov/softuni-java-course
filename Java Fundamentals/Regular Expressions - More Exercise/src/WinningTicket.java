import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split(",+\\s+");
        String winningSequenceRegex = "([\\^@$#])\\1{5,9}";
        Pattern winningSequencePattern = Pattern.compile(winningSequenceRegex);
        for (String ticket : tickets){
            ticket = ticket.trim();
            if (ticket.length() == 20){
                String ticketLeft = ticket.substring(0,10);
                String ticketRight = ticket.substring(10,20);
                String winningSequence = "";
                String winningSequenceRight = "";
                String winningSequenceChar = "";
                int sequence = 0;
                Matcher winningSequenceMatcher = winningSequencePattern.matcher(ticketLeft);
                if (winningSequenceMatcher.find()){
                    winningSequence = winningSequenceMatcher.group();
                    winningSequenceChar = winningSequenceMatcher.group(1);
                    String winningSequenceRightRegex = "\\" + winningSequenceChar + "{6,10}";
                    Pattern winningSequenceRightPattern = Pattern.compile(winningSequenceRightRegex);
                    Matcher winningSequenceRightMatcher = winningSequenceRightPattern.matcher(ticketRight);
                    if (winningSequenceRightMatcher.find()){
                        winningSequenceRight = winningSequenceRightMatcher.group();
                        sequence = Math.min(winningSequence.length(), winningSequenceRight.length());
                        if (sequence == 10){
                            System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",ticket,sequence,winningSequenceChar);
                        } else {
                            System.out.printf("ticket \"%s\" - %d%s%n",ticket,sequence,winningSequenceChar);
                        }
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n",ticket);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n",ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
