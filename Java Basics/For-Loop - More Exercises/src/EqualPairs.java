import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pairs = Integer.parseInt(scanner.nextLine());
        int []pairsSum = new int[pairs];
        int consecutivePairsMaxDiff = 0;
        int consecutivePairsDiff = 0;

        for (int i = 0; i <pairs*2; i++) {
            int currentValue = Integer.parseInt(scanner.nextLine());
            pairsSum[i/2] = pairsSum[i/2] + currentValue;
        }
        for (int i = 0; i < pairsSum.length-1; i++) {
            consecutivePairsDiff = Math.abs(pairsSum[i] - pairsSum[i+1]);
            if (consecutivePairsDiff > consecutivePairsMaxDiff){
                consecutivePairsMaxDiff = consecutivePairsDiff;
            }
        }

        if (consecutivePairsMaxDiff == 0){
            System.out.printf("Yes, value=%d",pairsSum[0]);
        }
        else{
            System.out.printf("No, maxdiff=%d",consecutivePairsMaxDiff);
        }
    }
}
