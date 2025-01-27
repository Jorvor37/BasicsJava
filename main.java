package Ex3_6680170;

import java.io.*;
import java.util.*;

class Player {
    public static final int CURRENT_YEAR = 2025;
    private String name;
    protected int birthyear;

    public Player(String nm, int by) {
        name = nm;
        birthyear = by;
    }

    public String getName() {
        return name;
    }

    public void printPersonalData() {
        // Override in child class
    }

    public void printStat() {
        // Override in child class
    }
}

class FootballPlayer extends Player {
    private int totalGames;
    private int totalMinutes;
    private int lastSeasonGoals;

    public FootballPlayer(String nm, int by, int tg, int tm, int lg) {
        super(nm, by);
        totalGames = tg;
        totalMinutes = tm;
        lastSeasonGoals = lg;
    }

    @Override
    public void printPersonalData() {
        System.out.printf("Football Player: %s, Birth Year: %d, Age: %d%n", getName(), birthyear, NewMain.cal_age(birthyear));
    }

    @Override
    public void printStat() {
        System.out.printf("Total Games: %d, Total Minutes: %d, Last Season Goals: %d%n", totalGames, totalMinutes, lastSeasonGoals);
    }
}

class BasketballPlayer extends Player {
    private int totalGames;
    private int totalMinutes;
    private int totalPoints;

    public BasketballPlayer(String nm, int by, int tg, int tm, int tp) {
        super(nm, by);
        totalGames = tg;
        totalMinutes = tm;
        totalPoints = tp;
    }

    @Override
    public void printPersonalData() {
        System.out.printf("Basketball Player: %s, Birth Year: %d, Age: %d%n", getName(), birthyear, NewMain.cal_age(birthyear));
    }

    @Override
    public void printStat() {
        System.out.printf("Total Games: %d, Total Minutes: %d, Total Points: %d%n", totalGames, totalMinutes, totalPoints);
    }
}

public class NewMain {
    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        System.out.println("Current directory = " + localDir + "\n");

        String path = "src/main/java/Ex3_6680170/";
        String inFilename = path + "players.txt";

        Player[] members = new Player[12];
        int num = 0;

        try {
            File inFile = new File(inFilename);
            Scanner fileScan = new Scanner(inFile);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] cols = line.split(",");
                String type = cols[0].trim();
                String name = cols[1].trim();
                int year = Integer.parseInt(cols[2].trim());

                if (type.equalsIgnoreCase("B")) {
                    int tg1 = Integer.parseInt(cols[3].trim());
                    int tm1 = Integer.parseInt(cols[4].trim());
                    int tp = Integer.parseInt(cols[5].trim());
                    members[num++] = new BasketballPlayer(name, year, tg1, tm1, tp);
                } else if (type.equalsIgnoreCase("F")) {
                    int tg2 = Integer.parseInt(cols[3].trim());
                    int tm2 = Integer.parseInt(cols[4].trim());
                    int lg = Integer.parseInt(cols[5].trim());
                    members[num++] = new FootballPlayer(name, year, tg2, tm2, lg);
                }
            }

            fileScan.close();
        } catch (Exception e) {
            System.err.println("An error occurred. End program.");
            System.err.println(e);
            System.exit(-1);
        }

        // Print players' data
        for (int i = 0; i < num; i++) {
            members[i].printPersonalData();
            members[i].printStat();
            System.out.println();
        }
    }

    public static int cal_age(int year) {
        return Player.CURRENT_YEAR - year;
    }
}
