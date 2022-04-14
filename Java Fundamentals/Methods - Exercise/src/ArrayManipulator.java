import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String command = input.split(" ")[0];
            switch (command){
                case "exchange":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if (index >=0 && index < arr.length){
                        int[] arr1;
                        arr1 = exchangeArr(index,arr);
                        arr = arr1;
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String numType = input.split(" ")[1];
                    switch (numType){
                        case "even":
                            if (getMaxEven(arr) == null){
                                System.out.println("No matches");
                            } else {
                                System.out.println(getMaxEven(arr));
                            }
                            break;
                        case "odd":
                            if (getMaxOdd(arr) == null){
                                System.out.println("No matches");
                            } else {
                                System.out.println(getMaxOdd(arr));
                            }
                            break;
                    }
                    break;
                case "min":
                    numType = input.split(" ")[1];
                    switch (numType){
                        case "even":
                            if (getMinEven(arr) == null){
                                System.out.println("No matches");
                            } else {
                                System.out.println(getMinEven(arr));
                            }
                            break;
                        case "odd":
                            if (getMinOdd(arr) == null){
                                System.out.println("No matches");
                            } else {
                                System.out.println(getMinOdd(arr));
                            }
                            break;
                    }
                    break;
                case "first":
                    index = Integer.parseInt(input.split(" ")[1]);
                    numType = input.split(" ")[2];
                    switch (numType){
                        case "even":
                            if (index >=0 && index <= arr.length){
                                printFirstEvenElements(index,arr);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                        case "odd":
                            if (index >=0 && index <= arr.length){
                                printFirstOddElements(index,arr);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                    }
                    break;
                case "last":
                    index = Integer.parseInt(input.split(" ")[1]);
                    numType = input.split(" ")[2];
                    switch (numType){
                        case "even":
                            if (index >=0 && index <= arr.length){
                                printLastEvenElements(index,arr);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                        case "odd":
                            if (index >=0 && index <= arr.length){
                                printLastOddElements(index,arr);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] exchangeArr (int index, int[] arr){
        int[] a = Arrays.copyOfRange(arr, 0, index+1);
        int[] b = Arrays.copyOfRange(arr, index+1, arr.length);
        int[] tempArr = new int[arr.length];
        System.arraycopy(b, 0, tempArr, 0, b.length);
        System.arraycopy(a, 0, tempArr, b.length, a.length);

        return tempArr;
    }

    public static Integer getMinEven (int[] arr){
        Integer value = null;
        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) % 2 == 0 && (value == null || value>= arr[i])) {
                value = arr[i];
                index = i;
            }
        }
        return  index;
    }

    public static Integer getMinOdd (int[] arr){
        Integer value = null;
        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) % 2 == 1 && (value == null || value>= arr[i])) {
                value = arr[i];
                index = i;
            }
        }
        return  index;
    }

    public static Integer getMaxEven (int[] arr){
        Integer value = null;
        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) % 2 == 0 && (value == null || value<= arr[i])) {
                value = arr[i];
                index = i;
            }
        }
        return  index;
    }

    public static Integer getMaxOdd (int[] arr){
        Integer value = null;
        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) % 2 == 1 && (value == null || value<= arr[i])) {
                value = arr[i];
                index = i;
            }
        }
        return  index;
    }

    public static void printFirstEvenElements(int index, int[] arr){
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i])%2 == 0){
                list.add(arr[i]);
            }
            if (list.size() == index){
                System.out.println(list);
                return;
            }
        }
        System.out.println(list);
    }

    public static void printFirstOddElements(int index, int[] arr){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) %2 == 1){
                list.add(arr[i]);
            }
            if (list.size() == index){
                System.out.println(list);
                return;
            }
        }
        System.out.println(list);
    }

    public static void printLastEvenElements(int index, int[] arr){
        List<Integer> list=new ArrayList<>();
        for (int i = arr.length-1; i >=0; i--) {
            if (Math.abs(arr[i]) %2 == 0){
                list.add(arr[i]);
            }
            if (list.size() == index){
                System.out.println(reverse(list));
                return;
            }
        }
        System.out.println(reverse(list));
    }

    public static void printLastOddElements(int index, int[] arr){
        List<Integer> list=new ArrayList<>();
        for (int i = arr.length-1; i >=0; i--) {
            if (Math.abs(arr[i])%2 == 1){
                list.add(arr[i]);
            }
            if (list.size() == index){
                System.out.println(reverse(list));
                return;
            }
        }
        System.out.println(reverse(list));
    }
    public static List <Integer> reverse (List <Integer> list){
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list.size()-1; i >= 0 ; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
}
