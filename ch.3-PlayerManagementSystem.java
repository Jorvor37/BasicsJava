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

    public void calculateStats(){
        int totalGames = games[0] + games[1] + games[2];
        int totalGoals = goals[0] + goals[1] + goals[2];
        avgGoals = totalGames == 0 ? 0 : (double) totalGoals/totalGames;
    }

    public void printPersonalData(){
        System.out.printf("%-15s %4d %3d%n", getName(), birthyear, age);
    }

    public printStat(){
        calculateStats();
        System.out.printf("%-15s %5d %5d %7.2f %5d%n", getName(), games[0] + games[1] + games[2], goals[0] + goals[1] + goals[2], avgGoals, goals[2]);
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
        this.totalGames = games;
        this.totalMins = mins;
        this.totalPts = points;
    }

    public void calculateStats(){
        avgMins = totalGames == 0 ? 0 : (double) totalMins / totalGames;
        avgPts = totalGames == 0 ? 0 : (double) totalPts / totalGames;
    }

    public void printPersonalData(){
        System.out.printf("%-15s %4d %3d%n", getName(), birthyear, age);
    }

    public void printStat(){
        calculateStats();
        System.out.printf("%-15s %5d %5d %7.2f %5d%n", getName(), totalGames, totalMins, avgMins,totalPts, avgPts)
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

                if(type.equalIgnoreCase("F")){ /* football */
                    allPlayers[i] = new footballPlayer(name, birthyear,cols[3],cols[4],cols[5]);
                }
                else if (type.equalIgnoreCase("B")){ /* basketball */
                    int games = Integer.parseInt(cols[3].trim());
                    int mins = Integer.parseInt(cols[4].trim());
                    int points = Integer.parseInt(cols[5].trim());
                    allPlayers[i] = new baseketballPlayer (name, birthyear,games, mins, points);
                }
                i++;
            }
            catch (FileNotFoundException e){ /* Debugging */
                System.err.println("Input file not found :)");
            }

            /* Print1 */
            System.out.println("Personal Data in Reverse Order:");
            for (int i=allPlayers.length - 1; i>=0;i--)
            {
                if(allPlayers[i] != null)
                {
                    allPlayers[i].age = Player.CURRENT_YEAR - allPlayers[i].birthyear;
                    allPlayers[i].printPersonalData();
                }
            }

            System.out.println("\nFootball Player Stats:");
            for (Player player : allPlayers)
            {
                if(player instanceof footballPlayer)
                {
                    player.printStat();
                }
            }

            System.out.println("\nBasketball Player Stats:");
            for (Player player : allPlayers)
            {
                if(player instanceof baseketballPlayer)
                {
                    player.printStat();
                }
            }
        }
    }
}