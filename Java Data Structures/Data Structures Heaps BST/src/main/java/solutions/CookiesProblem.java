package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class CookiesProblem {
    public Integer solve(int k, int[] cookiesSweetness) {
        Queue<Integer> cookies = new PriorityQueue<>();

        for (int sweetness : cookiesSweetness) {
            cookies.add(sweetness);
        }

        int operationCount = 0;

        if (cookies.isEmpty()) {return -1;}

        Integer currentSweetness = cookies.peek();
        while (currentSweetness < k && cookies.size() > 1) {
            Integer firstCookie = cookies.poll();
            Integer secondCookie = cookies.poll();

            Integer newCookie = firstCookie + 2 * secondCookie;
            cookies.add(newCookie);

            currentSweetness = cookies.peek();

            operationCount++;
        }
        return currentSweetness > k ? operationCount : -1;
    }
}
