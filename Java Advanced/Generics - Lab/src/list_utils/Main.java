package list_utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1 ,2, 18, -1, 6);
        System.out.println(ListUtils.getMax(list));
    }
}
