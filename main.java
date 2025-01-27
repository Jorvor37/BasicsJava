import java.io.*;
import java.util.*;

class Player {
public static final int CURRENT_YEAR = 2025;
private String name;
protected int birthyear, age;
public Player(String nm, int by) { name = nm; birthyear = by; }
public String getName() { return name; }
public void printPersonalData() { /* override this in child class */ }
public void printStat() { /* override this in child class */ }
}

/* Football Player */
class footballPlayer extends Player {
    private int[] games = new int[3];
    private int[] goals = new int[3];
    private double avgGoals;

    public footballPlayer(String name, int birthyear, String season21_22, String season22_23, String season23_24){
        super(name, birthyear);
        parseStats(season21_22, 0);
        parseStats(season22_23, 1);
        parseStats(season23_24, 2);
    }

    private void parseStats(String seasonData, int index){ /* extract game and goal stats from string */
        String[] parts = seasonData.split(":");
        games[index] = Integer.parseInt(parts[0].trim());
        goals[index] = Integer.parseInt(parts[1].trim());
    }
}

/* Baseketball Player */
class baseketballPlayer extends Player {
    private int totalGames;
    private int totalMins;
    private int totalPts;
    private double avgMins;
    private double avgPts;

    public baseketballPlayer(String name, int birthyear, int games, int mins, int points){
        super(name, birthyear);

    }
}

/* Main program */
public class Main {
    public static void main(String[] args){
        Player[] allPlayers = new Player[12]; /* 12 players */
        try (Scanner scan = new Scanner(new File(" NAME OF FILE NA TEATREE <3 (.txt)"))){
            int i=0;
            while(scan.hasNextLine()){ /* read .txt file line by line build-in function of java.io.FileNotFoundException na */
                String line = scan.nextLine(); /* Assign text */
                String[] cols = line.split(",");
                String type = cols[0],trim();
                String name = cols[1],trim();
                int birthyear = Integer.parseInt(cols[2].trim());
            }
        }
    }
}