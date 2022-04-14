import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(getVowelsCount(input));
    }

    public static int getVowelsCount(String string){
        int vowelsCount = 0;
        for (int i = 0; i < string.length(); i++) {
            switch (string.toLowerCase().charAt(i)){
                case 'a':
                case 'o':
                case 'e':
                case 'i':
                case 'u':
                    vowelsCount++;
            }
        }
        return  vowelsCount;
    }
}
