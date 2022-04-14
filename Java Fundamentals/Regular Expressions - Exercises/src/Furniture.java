import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">{2}(?<furniture>[A-Za-z]+)<{2}(?<price>\\d+.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double sum = 0;
        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                furniture.add(matcher.group("furniture"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum += price*quantity;

            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String piece : furniture){
            System.out.println(piece);
        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
