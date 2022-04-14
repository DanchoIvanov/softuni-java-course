import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double georgeLucasMoney = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = Math.ceil(students * 1.1) * lightsaberPrice + students * robePrice + (students - students/6)* beltPrice;

        double difference = Math.abs(totalPrice - georgeLucasMoney);

        if (totalPrice > georgeLucasMoney){
            System.out.printf("George Lucas will need %.2flv more.",difference);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }
    }
}
