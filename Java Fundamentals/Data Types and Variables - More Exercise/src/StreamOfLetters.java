import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        boolean nFound = false;
        boolean oFound = false;
        boolean cFound = false;
        while(!input.equals("End")){
            String symbol = String.valueOf(input.charAt(0));
            if ((symbol.charAt(0) >= 65 && symbol.charAt(0) <= 90) || symbol.charAt(0) >= 97 && symbol.charAt(0) <= 122){
                if(symbol.equals("n") & !nFound){
                    nFound = true;
                    symbol = "";
                } else if (symbol.equals("o") & !oFound){
                    oFound = true;
                    symbol = "";
                }  else if (symbol.equals("c") & !cFound){
                    cFound = true;
                    symbol = "";
                }
                if (nFound && oFound && cFound){
                    System.out.printf("%s ", output);
                    nFound = false;
                    oFound = false;
                    cFound = false;
                    output = new StringBuilder();
                    input = scanner.nextLine();
                    continue;
                }
                output.append(symbol);
            }
            input = scanner.nextLine();
        }
    }
}
