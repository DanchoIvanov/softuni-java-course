import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, kids);
        int cycleCount = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (!isPrime(cycleCount)) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
            cycleCount++;
        }
        System.out.println( "Last is " + queue.poll());
    }

    public static  boolean isPrime(int x){
        boolean isPrime = true;

        if (x <= 1){
            return false;
        }

        for(int m = 2; m <= Math.sqrt(x); m++){

            int temp = x%m;
            if(temp == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;

    }
}