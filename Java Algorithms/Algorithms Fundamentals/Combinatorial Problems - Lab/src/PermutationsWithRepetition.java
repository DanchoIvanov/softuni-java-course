import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {

    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        permuteWithRepetition(0);
    }

    private static void permuteWithRepetition(int index) {
        if (index >= elements.length){
            print();
            return;
        }

        permuteWithRepetition(index + 1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);
        for (int i = index + 1; i < elements.length ; i++) {
            if (!swapped.contains(elements[i])){
                swap(index, i);
                permuteWithRepetition(index + 1);
                swap(index, i);
                swapped.add(elements[i]);
            }
        }
    }

    private static void swap(int index, int i) {
        String elementToSwap = elements[index];
        elements[index] = elements[i];
        elements[i] = elementToSwap;
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }
}
