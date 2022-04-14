import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondListReverse = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = new ArrayList<>();
        for (int i = secondListReverse.size()-1; i >=0 ; i--) {
            secondList.add(secondListReverse.get(i));
        }
        List<Integer> longerList;
        List<Integer> shorterList;
        if (firstList.size() >= secondList.size()){
            longerList = firstList;
            shorterList = secondList;
        } else {
            longerList = secondList;
            shorterList = firstList;
        }
        int filterNum1 = Math.min(longerList.get(longerList.size() - 2), longerList.get(longerList.size() - 1));
        int filterNum2 = Math.max(longerList.get(longerList.size() - 2), longerList.get(longerList.size() - 1));

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < shorterList.size(); i++) {
            if (firstList.get(i) > filterNum1 && firstList.get(i) < filterNum2) {
                output.add(firstList.get(i));
            }
            if (secondList.get(i) > filterNum1 && secondList.get(i) < filterNum2) {
                output.add(secondList.get(i));
            }
        }
        if (!output.isEmpty()) {
            Collections.sort(output);
            for (int element : output) {
                System.out.printf("%d ", element);
            }
        }
    }
}
