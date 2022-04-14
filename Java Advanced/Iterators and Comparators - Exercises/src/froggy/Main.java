package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lake lake = new Lake();
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        lake.add(numbers);
        List<Integer> output = new ArrayList<>();
        lake.forEach(output::add);
        System.out.println(output.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
