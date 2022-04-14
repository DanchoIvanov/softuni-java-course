package football_team_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static List<Team> teams = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");

        while (!input[0].equals("END")){
            String command = input[0];
            String teamName = input[1];
            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.add(team);
                        break;
                    case "Add":
                        String playerName = input[2];
                        int endurance = Integer.parseInt(input[3]);
                        int sprint = Integer.parseInt(input[4]);
                        int dribble = Integer.parseInt(input[5]);
                        int passing = Integer.parseInt(input[6]);
                        int shooting = Integer.parseInt(input[7]);
                        team = getTeam(teamName);
                        team.addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        break;
                    case "Remove":
                        playerName = input[2];
                        team = getTeam(teamName);
                        team.removePlayer(playerName);
                        break;
                    case "Rating":
                        team = getTeam(teamName);
                        System.out.printf("%s - %.0f%n",team.getName(), team.getRating());
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine().split(";");
        }
    }

    private static Team getTeam(String teamName){
        for (Team team : teams) {
            if (team.getName().equals(teamName)){
                return team;
            }
        }
        throw new IllegalArgumentException(String.format("Team %s does not exist.",teamName));
    }
}
