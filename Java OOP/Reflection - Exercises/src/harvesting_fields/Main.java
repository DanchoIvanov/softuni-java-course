package harvesting_fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> clazz = RichSoilLand.class;
		String command = scanner.nextLine();

		while (!command.equals("HARVEST")){

			try {
				Arrays.stream(clazz.getDeclaredFields())
						.filter(getPredicate(command))
						.forEach(f -> System.out.printf("%s %s %s%n",Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
			} catch (IllegalAccessException e){
				System.out.println(e.getMessage());
			}

			command = scanner.nextLine();
		}
	}

	private static Predicate<? super Field> getPredicate(String command) throws IllegalAccessException {
		switch (command){
			case "private":
				return f -> Modifier.isPrivate(f.getModifiers());
			case "protected":
				return f -> Modifier.isProtected(f.getModifiers());
			case "public":
				return f -> Modifier.isPublic(f.getModifiers());
			case "all":
				return f -> true;
			default:
				throw new IllegalAccessException("Invalid command");
		}

	}
}
