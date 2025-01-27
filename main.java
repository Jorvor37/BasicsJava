package Ex3_6680170;

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

class FootballPlayer extends Player
{
    public FootballPlayer(String nm, int by) {
        super(nm, by);
    }
    public void printPersonalData() { /* override this in child class */ }
    public void printStat() { /* override this in child class */ }
}
class BasketballPlayer extends Player
{
    public BasketballPlayer(String nm, int by,int totalgames,int totalminutes,int totalpoints) {
        super(nm, by);
        int tg1 = totalgames;
        int tm1 = totalminutes;
        int tg  = totalpoints;
    } 
    
    public void printPersonalData() 
    {
        System.out.printf("%s %d %d" ,getName(),birthyear,NewMain.cal_age(birthyear));
    }
    
    public void printStat() {}
}
        
public class NewMain
{
          
  public static void main(String[] args)  
  {
        String localDir = System.getProperty("user.dir");
        System.out.println("Current directory = " + localDir + "\n");
        
        String path        = "src/main/java/Ex3_6680170/";
	String inFilename  = path + "players.txt";
        
        Player[] members = new Player[12]; 
        int num = 0;
        
	try 
        {
            File inFile      = new File(inFilename);
            Scanner fileScan = new Scanner(inFile); 
       
            while ((String Line = (scan.nextLine()))!= null )
            {							
                //String line = fileScan.nextLine();
                String [] cols = line.split(",");
                String type = cols[0].trim(); // receive data as string
                String name = cols[1].trim();
                int year = Integer.parseInt( cols[2].trim() );
                
                
                if(type.equalsIgnoreCase("B"))  //receive data both upper and lower case
                {
                    int tg1 = Integer.parseInt( cols[3].trim() ); //totalgames = tg
                    int tm1 = Integer.parseInt( cols[4].trim() ); //totalmins = tm
                    int tp = Integer.parseInt( cols[5].trim() );//totalpoints = tp
                    members[num++] = new BasketballPlayer(name,year,tg1,tm1,tp);
                }
                else
                {   
                    int tg2 = Integer.parseInt( cols[3].trim() ); //totalgames = tg
                    int tm2 = Integer.parseInt( cols[4].trim() );
                    int lg  = Integer.parseInt( cols[5].trim() ); //lg = lastseason goals
                    
                }
                // Use \r\n when writing to file 
                
            }
          
            fileScan.close();

	}
	catch(Exception e) {
            System.err.println("An error occurs. End program.");
            System.err.println(e);	  
            System.exit(-1);
	}
    }
  
   public static int cal_age(int year)
  {

      return Player.CURRENT_YEAR - year;
  }
   
}