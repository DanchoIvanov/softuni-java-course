package traffic_light;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TrafficLight> trafficLights = Arrays.stream(scanner.nextLine().split("\\s+")).map(TrafficLight::valueOf).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            trafficLights = trafficLights.stream().map(TrafficLight::change).collect(Collectors.toList());
            trafficLights.forEach(t -> System.out.print(t+ " "));
            System.out.println();
        }
    }
}
