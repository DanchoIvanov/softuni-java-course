package getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;
        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") || m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    if (m.getName().startsWith("set")){
                        System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName());
                    } else {
                        System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName());
                    }
        });

    }
}
