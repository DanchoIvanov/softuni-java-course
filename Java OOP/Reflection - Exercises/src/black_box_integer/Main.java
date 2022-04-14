package black_box_integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> defaultConstructor =  clazz.getDeclaredConstructor();
        defaultConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = defaultConstructor.newInstance();

        String input = scanner.nextLine();

        while (!input.equals("END")){

            String methodName = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);
            
            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.getInt(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
