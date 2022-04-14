package football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name){
        if (name.trim().equals("")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        Player playerToRemove = getPlayer(name);
        this.players.remove(playerToRemove);
    }

    private Player getPlayer(String name){
        for (Player player : this.players){
            if (player.getName().equals(name)){
                return player;
            }
        }
        throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name, this.getName()));
    }

    public double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }
}
