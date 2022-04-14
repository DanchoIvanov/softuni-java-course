import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int startPokePower = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int successfulPokesCount = 0;
        while (pokePower >= distance){
            pokePower-=distance;
            successfulPokesCount++;
            if (pokePower == startPokePower*1.0/2 && exhaustionFactor>0){
                pokePower/=exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(successfulPokesCount);
    }
}
