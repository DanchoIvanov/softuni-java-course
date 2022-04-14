import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")){
            String command = input.split(":")[0];
            String lessonTitle =  input.split(":")[1];
            boolean lessonExists = lessons.contains(lessonTitle);
            switch (command){
                case "Add":
                    if (!lessonExists) {
                        lessons.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(input.split(":")[2]);
                    if (!lessonExists){
                        lessons.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (lessonExists){
                        lessons.remove(lessonTitle);
                    }
                    break;
                case "Swap":
                    String lessonTittleToSwapWith = input.split(":")[2];
                    boolean lessonToSwapExist = lessons.contains(lessonTittleToSwapWith);
                    if (lessonExists && lessonToSwapExist){
                        lessonSwap(lessonTitle, lessonTittleToSwapWith, lessons);
                    }
                    break;
                case "Exercise":
                    addExercise(lessonTitle,lessons);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println(i+1 + "." + lessons.get(i));
        }
    }
    static void addExercise (String lessonTitle, List<String> lessons){
        boolean lessonExists = lessons.contains(lessonTitle);
        if (lessonExists){
            boolean exerciseExist = lessons.contains(lessonTitle + "-Exercise");
            if (exerciseExist){
                lessons.remove(lessonTitle + "-Exercise");
            }
            int exerciseIndex = lessons.indexOf(lessonTitle) +1;
            lessons.add(exerciseIndex, lessonTitle + "-Exercise");
        } else {
            lessons.add(lessonTitle);
            lessons.add(lessonTitle + "-Exercise");
        }
    }

    static void lessonSwap (String lessonTitle, String lessonTittleToSwapWith, List<String> lessons){
        int firstIndex = lessons.indexOf(lessonTitle);
        int secondIndex = lessons.indexOf(lessonTittleToSwapWith);
        lessons.set(firstIndex, lessonTittleToSwapWith);
        lessons.set(secondIndex, lessonTitle);
        boolean exerciseExist = lessons.contains(lessonTittleToSwapWith + "-Exercise");
        if (exerciseExist){
            lessons.remove(lessonTittleToSwapWith + "-Exercise");
            int exerciseIndex = lessons.indexOf(lessonTittleToSwapWith) +1;
            lessons.add(exerciseIndex, lessonTittleToSwapWith + "-Exercise");
        }

    }
}
