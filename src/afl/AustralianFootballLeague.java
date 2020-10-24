package afl;

import java.util.Scanner;

/**
 *
 * @author tghising
 */
public class AustralianFootballLeague {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // declaration of variable and initialization of initial values
        int smallestMargin = 0; // smallest margin identifier and initial value set to 0
        int biggestMargin = 0; // biggest margin identifier and initial value set to 0
        final int TOTAL_NUMBER_OF_GAMES = 5; // Total number of games identifier and not modified later in program
        int totalMargin = 0; // total margin identifier and initial value set to 0

        System.out.println("\n######################################## WELCOME TO FOOTBALL LEAGUE ########################################");

        // reading and display summary of each game's scored goals and behinds by Home team and Away team
        for (int i = 1; i <= TOTAL_NUMBER_OF_GAMES; i++) {
            System.out.println("\nMatch " + i + " of " + TOTAL_NUMBER_OF_GAMES);

            // create a scanner object to read console input
            Scanner input = new Scanner(System.in);
            // read and process final scores for each game
            System.out.println("Enter a result of match (Format: Name Goals Behinds)");
            System.out.print("Home Team>");
            // Team1  name, scored goal and behind identifier of each game
            String team1 = input.next();
            int goal1 = input.nextInt();
            int behind1 = input.nextInt();
            System.out.print("Away Team>");
            // Team2  name, scored goal and behind identifier of each game
            String team2 = input.next();
            int goal2 = input.nextInt();
            int behind2 = input.nextInt();

            // create a Game object for map value via constructor and determination of points, margin and winner of game
            Game game = new Game(team1, goal1, behind1, team2, goal2, behind2);

            //display match summary of each match
            System.out.println("\n***************  Summary of Match " + i + " of " + TOTAL_NUMBER_OF_GAMES+"   ***************");
            System.out.println("Home Team>"+game.getTeam1() + " scored(Goals:" + game.getGoal1() + ", Behinds:" + game.getBehind1()+")");
            System.out.println("Away Team>"+game.getTeam2() + " scored(Goals:" + game.getGoal2() + ", Behinds:" + game.getBehind2()+")");
            if (game.getMargin() == 0 || game.getWinner() == "Drawn"){
                System.out.println("Match " + i + " " + game.getWinner() + " : Match " + i + " rating " + game.getRating());
            } else {
                System.out.println(game.getWinner() + " won by " + game.getMargin() + " points : Match " + i + " rating " + game.getRating());
            }

            // determine the current biggest margin with previous biggest margin values
            if (game.getMargin() > biggestMargin) {
                biggestMargin = game.getMargin();
            }

            // determine the current smallest margin with previous smallest margin values
            if (game.getMargin() < smallestMargin) {
                smallestMargin = game.getMargin();
            }

            // accumulate values for average margin determination
            totalMargin = totalMargin + game.getMargin();
        }
        // display football league summary results
        System.out.println("\n###################################### FOOTBALL LEAGUE SUMMARY ######################################");
        System.out.println("Biggest margin was " + biggestMargin);
        System.out.println("Smallest margin was " + smallestMargin);
        // calculation of average margin of Football league
        double averageMargin = (double) totalMargin / TOTAL_NUMBER_OF_GAMES;
        System.out.println("Average margin was " + averageMargin);
        System.out.println("\n######################################## ENDED FOOTBALL LEAGUE ########################################");
    }
}
