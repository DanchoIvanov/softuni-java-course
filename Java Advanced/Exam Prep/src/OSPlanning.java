import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(tasks).forEach(tasksStack::push);

        Deque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(threads).forEach(threadsQueue::offer);

        while (!threadsQueue.isEmpty()){
            int currentThread = threadsQueue.poll();
            int currentTask = tasksStack.pop();

            if (currentTask == taskToBeKilled){
                System.out.printf("Thread with value %d killed task %d%n",currentThread, taskToBeKilled);
                threadsQueue.addFirst(currentThread);
                System.out.println(threadsQueue.toString().replaceAll("[\\[\\],]", ""));
                return;
            }
            if (currentThread < currentTask){
                tasksStack.push(currentTask);
            }
        }
    }
}
