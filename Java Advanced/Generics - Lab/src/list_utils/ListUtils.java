package list_utils;

import java.util.List;

public class ListUtils <T extends Comparable<T>> {

    public static <T extends Comparable<T>> T getMin (List<T> list){
        checkSize(list);
        T min = list.get(0);
        for (T element : list){
            if (element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax (List<T> list){
        checkSize(list);
        T max = list.get(0);
        for (T element : list){
            if (element.compareTo(max) > 0){
                max = element;
            }
        }
        return max;
    }

    private static <T extends Comparable<T>> void checkSize(List<T> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException("The provided list is empty.");
        }
    }
}
