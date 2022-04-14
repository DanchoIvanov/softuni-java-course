import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));
        String input = scanner.nextLine();

        while(!input.equals("3:1")){
            String command = input.split(" ")[0];
            switch (command){
                case "merge":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);
                    if (startIndex < 0){
                        startIndex = 0;
                    }
                    if (endIndex > list.size()-1){
                        endIndex = list.size()-1;
                    }
                    boolean isStartIndexValid = isValidIndex(startIndex, list.size());
                    boolean isEndIndexValid = isValidIndex(endIndex, list.size());

                    if(isStartIndexValid && isEndIndexValid) {
                        for (int i = startIndex+1; i <= endIndex; i++) {
                            list.set(startIndex, list.get(startIndex) + list.get(i));
                        }
                        for (int i = startIndex + 1; i <= endIndex; i++) {
                            list.remove(startIndex + 1);
                        }
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int partition = Integer.parseInt(input.split(" ")[2]);
                    String stringToDivide = list.get(index);
                    int divisionLength = stringToDivide.length() / partition;
                    list.remove(index);
                    int begin = 0;
                    for (int i = 0; i < partition - 1; i++) {
                        list.add(index, stringToDivide.substring(begin, begin + divisionLength));
                        begin += divisionLength;
                        index++;
                    }
                    list.add(index, stringToDivide.substring(begin));

            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", list));
    }
    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
