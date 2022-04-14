import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = 0;
        List <Integer> biggerList = null;

        if (numbers1.size() <= numbers2.size()){
            n = numbers1.size();
            biggerList = numbers2;
        } else {
            n = numbers2.size();
            biggerList = numbers1;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ",numbers1.get(i));
            System.out.printf("%d ",numbers2.get(i));
        }

        for (int i = n; i < biggerList.size(); i++) {
            System.out.printf("%d ",biggerList.get(i));
        }
    }
}
