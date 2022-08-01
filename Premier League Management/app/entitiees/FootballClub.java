package entitiees;

// FootballClub class
// FootballClub extends SportsClub class. So, SportsClub is a parent class and FootballClub is a child class
public class FootballClub extends SportsClub implements Comparable<FootballClub>{

    // Instance variables for FootballClub class

    // numberOfWins instance variable is to store club's number of win matches.txt
    private int numberOfWin;
    // numberOfDefeats is a instance variable to store club's number of draw matches.txt
    private int numberOfDraw;
    // numberOfDraws is a instance variable to store club's number of defeat matches.txt
    private int numberOfDefeat;
    // numberOfDefeats is a instance variable to store club's number of goal received in matches.txt
    private int numberOfGoalReceived;
    // numberOfGoalsReceived is a instance variable to store club's number of goal score in matches.txt
    private int numberOfGoalScored;
    // numberOfPoints is a instance variable to store club's number of points scored in matches.txt
    private int numberOfPoint;
    // numberOfPlayedMatches is a instance variable to store club's number of played matches.txt
    private int numberOfPlayedMatch;

    
    // Club number variable to find specific club from the array list
    // It's easy to use rather than using name or location or founded year to find specific club from the array list
    // private int clubNo;
    // private static int numberOfClub = 20191000;

    // Parameterized constructors for FootballClub class
    public FootballClub(String clubName, String location, int foundedYear) {
        super(clubName, location, foundedYear);
        this.numberOfWin = 0;
        this.numberOfDraw = 0;
        this.numberOfDefeat = 0;
        this.numberOfGoalReceived = 0;
        this.numberOfGoalScored = 0;
        this.numberOfPoint = 0;
        this.numberOfPlayedMatch = 0;
    }

    // Getter method for number of wins
    public int getNumberOfWin() {
        return numberOfWin;
    }

    // Setter method for number of wins
    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    // Getter method for number of draws
    public int getNumberOfDraw() {
        return numberOfDraw;
    }

    // Setter method number of draws
    public void setNumberOfDraw(int numberOfDraw) {
        this.numberOfDraw = numberOfDraw;
    }

    // Getter method for number of defeats
    public int getNumberOfDefeat() {
        return numberOfDefeat;
    }

    // Setter method number of defeats
    public void setNumberOfDefeat(int numberOfDefeat){
        this.numberOfDefeat = numberOfDefeat;
    }

    // Getter method for number of goals received
    public int getNumberOfGoalReceived() {
        return numberOfGoalReceived;
    }

    // Setter method for number of goals received
    public void setNumberOfGoalReceived(int numberOfGoalReceived) {
        this.numberOfGoalReceived = numberOfGoalReceived;
    }

    // Getter method for number of goals scored
    public int getNumberOfGoalScored() {
        return numberOfGoalScored;
    }

    // Setter method for number of goals scored
    public void setNumberOfGoalScored(int numberOfGoalScored) {
        this.numberOfGoalScored = numberOfGoalScored;
    }

    // Getter method for number of points
    public int getNumberOfPoint() {
        return numberOfPoint;
    }

    // Setter method for number of points
    public void setNumberOfPoint(int numberOfPoint) {
        this.numberOfPoint = numberOfPoint;
    }

    // Getter method for number of played matches.txt
    public int getNumberOfPlayedMatch() {
        return numberOfPlayedMatch;
    }

    // Setter method for number of played matches.txt
    public void setNumberOfPlayedMatch(int numberOfPlayedMatch) {
        this.numberOfPlayedMatch = numberOfPlayedMatch;
    }

    // toString method for football club class
    @Override
    public String toString() {
        return   super.toString()
                + "\nWins          : " + getNumberOfWin()
                + "\nDraws         : " + getNumberOfDraw()
                + "\nDefeats       : " + getNumberOfDefeat()
                + "\nGoalsReceived : " + getNumberOfGoalReceived()
                + "\nGoalsScored   : " + getNumberOfGoalScored()
                + "\nPoints        : " + getNumberOfPoint()
                + "\nPlayedMatches : " + getNumberOfPlayedMatch();
    }
    /*
     * Useful when sorting FootballClub array list
     * Lexicographic Ordering
     * We can't use compareTo method to compare for primitive data type
     * Instead we can subtract the integer because compareTo method change the string to hashcode and subtract to compare
     */
    @Override
    public int compareTo(FootballClub o) {
        if (this.numberOfPoint!=o.numberOfPoint){
            return ((this.getNumberOfPoint())-(o.getNumberOfPoint()));
        }else{
            return ((this.getNumberOfGoalScored()-this.getNumberOfGoalReceived())-(o.getNumberOfGoalScored()-o.getNumberOfGoalReceived()));
        }
    }

}
