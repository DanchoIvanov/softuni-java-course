import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double priceApartment = 0;
        double priceStudio = 0;
        double discount = 1;

        if (month.equals("May") || month.equals("October")){
            priceStudio = 50;
            priceApartment = 65;
            if (days >7 & days <=14){
                discount = 0.95;
            }
            else if (days > 14){
                discount = 0.7;
            }
        }
        else if (month.equals("June") || month.equals("September")){
            priceStudio = 75.2;
            priceApartment = 68.7;
            if (days > 14){
                discount = 0.8;
            }
        }
        else if (month.equals("July") || month.equals("August")) {
            priceStudio = 76;
            priceApartment = 77;
        }
        double discountApartment = 1;
        if (days > 14){
            discountApartment =0.9;
        }

        double totalPriceStudio = priceStudio*days*discount;
        double totalPriceApartment = priceApartment*days*discountApartment;

        System.out.printf("Apartment: %.2f lv.%n",totalPriceApartment);
        System.out.printf("Studio: %.2f lv.",totalPriceStudio);
    }
}
