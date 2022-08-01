package entitiees;

import java.io.*;
import java.time.LocalDate;

public class Match implements Serializable, Comparable<Match>{
    private FootballClub club1;
    private FootballClub club2;
    private int club1Score;
    private int club2Score;
    private final LocalDate matchDate;

    public Match(FootballClub club1, FootballClub club2, int club1Score, int club2Score, LocalDate matchDate){
        this.setClub1(club1);
        this.setClub2(club2);
        this.setClub1Score(club1Score);
        this.setClub2Score(club2Score);
        this.matchDate = matchDate;
    }

    public FootballClub getClub1() {
        return club1;
    }

    public void setClub1(FootballClub club1) {
        this.club1 = club1;
    }

    public FootballClub getClub2() {
        return club2;
    }

    public void setClub2(FootballClub club2){
        this.club2 = club2;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public void setClub1Score(int club1Score) {
        if (club1Score >=0 && club1Score <= 20){
            this.club1Score = club1Score;
        }else{
            throw new IllegalArgumentException("Invalid, Score can't be more than 15!");
        }
    }

    public int getClub2Score() {
        return club2Score;
    }

    public void setClub2Score(int club2Score) {
        if (club2Score >=0 && club2Score <= 20){
            this.club2Score = club2Score;
        }else{
            throw new IllegalArgumentException("Invalid, Score can't be more than 15!");
        }
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public FootballClub getMatchWinner(){
        return getClub1Score()>getClub2Score() ? getClub1():getClub2();
    }

    public FootballClub getMatchLooser(){
        return getClub1Score()>getClub2Score() ? getClub2():getClub1();
    }

    public boolean isMatchDraw(){
        return getClub1Score() == getClub2Score();
    }

    public int getWinnerClubScore(){
        return Math.max(getClub1Score(), getClub2Score());
    }

    public int getLooserClubScore(){
        return Math.min(getClub1Score(), getClub2Score());
    }

    @Override
    public String toString() {
        return  "Club1       : " + club1.toString() +
                "\nClub2       : " + club2.toString() +
                "\nClub1Score  : " + club1Score +
                "\nClub2Score  : " + club2Score +
                "\nMatchDate   : " + matchDate;
    }

    @Override
    public int compareTo(Match o) {
        return this.matchDate.compareTo(o.matchDate);
    }
}
