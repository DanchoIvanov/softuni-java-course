import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double racer1Time = 0;
        double racer2Time = 0;

        for (int i = 0; i < raceTrack.size()/2; i++) {
            if (raceTrack.get(i).equals(0)){
                racer1Time = racer1Time * 0.8;
            } else {
                racer1Time += raceTrack.get(i);
            }
        }

        for (int i = raceTrack.size()-1; i > raceTrack.size()/2; i--) {
            if (raceTrack.get(i).equals(0)){
                racer2Time = racer2Time * 0.8;
            } else {
                racer2Time += raceTrack.get(i);
            }
        }
        boolean leftIsWinner = racer1Time < racer2Time;
        String winner;
        double time;
        if (leftIsWinner){
            winner = "left";
            time = racer1Time;
        } else {
            winner = "right";
            time = racer2Time;
        }
        System.out.printf("The winner is %s with total time: %.1f",winner,time);
    }
}
