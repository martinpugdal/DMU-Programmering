package exercise_3;

import java.util.ArrayList;

public class Team {

    private final String name;
    private final ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        getPlayers().add(player);
    }

    public void printPlayers() {
        for (Player p : getPlayers()) {
            System.out.println(p);
        }
    }

    public double calcAverageAge() {
        int sum = 0;
        for (Player p : getPlayers()) {
            sum += p.getAge();
        }
        return (double) sum / getPlayers().size();
    }

    public int calcTotalScore() {
        int sum = 0;
        for (Player p : getPlayers()) {
            sum += p.getScore();
        }
        return sum;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int sum = 0;
        for (Player p : getPlayers()) {
            if (p.getAge() >= ageLimit) {
                sum += p.getScore();
            }
        }
        return sum;
    }

    public int maxScore() {
        int max = Integer.MIN_VALUE;
        for (Player p : getPlayers()) {
            if (p.getScore() > max) {
                max = p.getScore();
            }
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> bestPlayers = new ArrayList<>();
        int max = maxScore();
        for (Player p : getPlayers()) {
            if (p.getScore() == max) {
                bestPlayers.add(p.getName());
            }
        }
        return bestPlayers;
    }

    public String toString() {
        return String.format("Team(%s)", getName());
    }
}
