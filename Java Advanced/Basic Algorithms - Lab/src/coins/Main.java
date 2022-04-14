package coins;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));
        
        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int currentIndex = coins.length-1;
        Map <Integer, Integer> usedCoins = new TreeMap<>(Comparator.comparing(Integer::intValue).reversed());
        while (currentIndex >= 0 && targetSum > 0){
            if (targetSum >= coins[currentIndex]){
                targetSum -= coins[currentIndex];
                usedCoins.putIfAbsent(coins[currentIndex], 0);
                usedCoins.put(coins[currentIndex], usedCoins.get(coins[currentIndex]) + 1);
            } else {
                currentIndex --;
            }
        }
        return usedCoins;
    }
}