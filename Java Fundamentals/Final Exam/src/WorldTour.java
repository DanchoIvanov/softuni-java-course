import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder travelPlan = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while(!input.equals("Travel")){
            String command = input.split(":")[0];
            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String stop = input.split(":")[2];
                    if (indexIsValid(index, travelPlan)){
                        travelPlan.insert(index, stop);
                    }
                    System.out.println(travelPlan);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split(":")[1]);
                    int endIndex = Integer.parseInt(input.split(":")[2]);
                    if (indexIsValid(startIndex, travelPlan) && indexIsValid(endIndex, travelPlan)){
                        travelPlan.delete(startIndex, endIndex+1);
                    }
                    System.out.println(travelPlan);
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    travelPlan =  new StringBuilder (travelPlan.toString().replaceAll(oldString, newString));
                    System.out.println(travelPlan);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + travelPlan);
    }

    private static boolean indexIsValid(int index, StringBuilder travelPLan) {
        if (index >= 0 &&  index < travelPLan.length()){
            return true;
        } else {
            return false;
        }
    }
}
