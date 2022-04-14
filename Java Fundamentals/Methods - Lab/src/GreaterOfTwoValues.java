import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        switch (type){
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(a,b));
                break;
            case "char":
                char char1 = scanner.nextLine().charAt(0);
                char char2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(char1,char2));
                break;
            case "string":
                String string1 = scanner.nextLine();
                String string2 = scanner.nextLine();
                System.out.println(getMax(string1,string2));
                break;
        }
    };

    public static int getMax (int a, int b){
        if (a > b){
            return a;
        }
        return b;
    }

    public static char getMax (char a, char b){
        if (a > b){
            return a;
        }
        return b;
    }

    public static String getMax (String  a, String b){
        if (a.compareTo(b) >= 0){
            return a;
        }
        return b;
    }
}
