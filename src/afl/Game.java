package afl;

/**
 *
 * @author tghising
 */
public class Game {

    // Game rating 1 to 4 which will not change during execution of program
    final int RATING_1 = 1;
    final int RATING_2 = 2;
    final int RATING_3 = 3;
    final int RATING_4 = 4;

    // points per Goals score in the game
    final int POINTS_PER_GOAL = 6;
    // points per Behinds score in the game
    final int POINTS_PER_BEHIND = 1;

    // Game rating criteria thresholds
    final int POINTS_THRESHOLD = 100;
    final int RATING_CRITERIA_2_THRESHOLD = 24;
    final int RATING_CRITERIA_3_LOWER_THRESHOLD = 3;
    final int RATING_CRITERIA_3_HIGHER_THRESHOLD = 24;
    final int RATING_CRITERIA_4_LOWER_THRESHOLD = 0;
    final int RATING_CRITERIA_4_HIGHER_THRESHOLD = 6;

    //member varaiable declarations and declared as private
    private String team1; // variable declaration for taking team1 name
    private int goal1; // variable declaration for taking team1 goals
    private int behind1; // variable declaration for taking team1 behinds
    private int points1; // variable declaration for calculation of team1 points

    private String team2; // variable declaration for taking team2 name
    private int goal2; // variable declaration for taking team2 goals
    private int behind2; // variable declaration for taking team2 behinds
    private int points2; // variable declaration for calculation of  team2 points

    private int margin; // margin identifier of a game
    private String winner; // winner identifier of a game
    private int rating; // rating identifier of a game

    // game constructor initialization and calculation of points for team1, team2 and setting margin, winner, and rating of each game
    public Game(String t1,int g1,int b1,String t2,int g2,int b2) {
        this.team1 = t1; 
        this.goal1 = g1;
        this.behind1 = b1;
        this.team2 = t2;
        this.goal2 = g2;
        this.behind2 = b2;
        setPoints1(); // call setters method for calculation of team1 points
        setPoints2(); // call setters method for calculation of team2 points
        setMargin(); // call setters margin method for calculation of game margin
        setWinner(); // call setters winner method for calculation of game winner
        setRating(); // call setters margin method for calculation of game rating
    }

    /*
    Setters method
    */

    // method for calculation of team1 points
    private void setPoints1() {
        this.points1 = this.goal1 * POINTS_PER_GOAL + this.behind1 * POINTS_PER_BEHIND;
    }
    // method for calculation of team2 points
    private void setPoints2() {
        this.points2 = this.goal2 * POINTS_PER_GOAL + this.behind2 * POINTS_PER_BEHIND;
    }
    // method for calculation of game margin
    private void setMargin() {
        this.margin = Math.abs(this.points1 - this.points2);
    }
    // method for calculation of game winner
    private void setWinner() {
        if (this.points1 > this.points2) {
            this.winner = this.team1;
        } else if (this.points1 < this.points2) {
            this.winner = this.team2;
        } else {
            this.winner ="Drawn";
        }
    }
    // method for calculation of game rating
    private void setRating() {
        // determine the RATING_4 of the game
        if (this.margin >= RATING_CRITERIA_4_LOWER_THRESHOLD && this.margin <= RATING_CRITERIA_4_HIGHER_THRESHOLD){
            this.rating = RATING_4;
        } else if (this.margin >= RATING_CRITERIA_3_LOWER_THRESHOLD && this.margin <= RATING_CRITERIA_3_HIGHER_THRESHOLD){ // determine the RATING_3 of the game
            this.rating = RATING_3; 
        } else if (this.margin > RATING_CRITERIA_2_THRESHOLD && (this.points1 > POINTS_THRESHOLD && this.points2 > POINTS_THRESHOLD)){ // determine the RATING_2 of the game
            this.rating = RATING_2;
        } else { // determine the RATING_1 of the game
            this.rating = RATING_1; 
        }
    }

    /*
    Getters : all getter method are public and can access using object of Game
    * */
    // getter method for return Team1 name
    public String getTeam1() {
        return team1;
    }
    // getter method for return Team2 name
    public String getTeam2() {
        return team2;
    }
    // getter method for return Team2 goals
    public int getGoal2() {
        return goal2;
    }
    // getter method for return Team1 goals
    public int getGoal1() {
        return goal1;
    }
    // getter method for return Team1 behinds
    public int getBehind1() {
        return behind1;
    }
    // getter method for return Team2 behinds 
    public int getBehind2() {
        return behind2;
    }
    // getter method for return game/match margin
    public int getMargin() {
        return margin;
    }
    // getter method for return wiiner of the game
    public String getWinner() {
        return winner;
    }
    // getter method for return rating of the game
    public int getRating() {
        return rating;
    }
}
