package generic_count_method_string;


import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    private List<T> list;

    public Box() {
       this.list = new ArrayList<>();
    }

    public void add(T element){
        list.add(element);
    }

    public void swap (int fistIndex, int secondIndex){
        T element = list.get(fistIndex);
        list.add(fistIndex, list.get(secondIndex));
        list.remove(fistIndex + 1);
        list.add(secondIndex, element);
        list.remove(secondIndex +1);

    }

    public int getCountOfGreaterElements (T elementToCompare){
        int count = 0;
        for (T elements : list){
            if (elements.compareTo(elementToCompare) > 0){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list){
           sb.append(String.format("%s: %s%n",element.getClass().getName(),element));
        }
        return sb.toString();
    }
}
