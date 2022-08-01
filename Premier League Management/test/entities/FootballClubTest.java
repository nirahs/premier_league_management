package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    @Test
    public void getClubName() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        assertEquals("Chelsea", f1.getClubName());
    }

    @Test
    public void getLocationName() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        assertEquals("Chelsea", f1.getLocationName());
    }

    @Test
    public void getFoundedYear() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        assertEquals(1905, f1.getFoundedYear());
    }

    @Test
    public void setClubName() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        f1.setClubName("Burnley");
        assertEquals("Burnley", f1.getClubName());
    }

    @Test
    public void setLocationName() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        f1.setLocationName("Burnley");
        assertEquals("Burnley", f1.getLocationName());
    }

    @Test
    public void setFoundedYear() {
        FootballClub f1 = new FootballClub("Chelsea", "Chelsea", 1905);
        f1.setFoundedYear(1882);
        assertEquals(1882, f1.getFoundedYear());
    }

    @Test
    public void testEquals() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        assertEquals(f1, f2);
    }

    @Test
    public void getNumberOfWin() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfWin(2);
        assertEquals(2, f1.getNumberOfWin());
    }

    @Test
    public void setNumberOfWin() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfWin(3);
        assertEquals(3, f1.getNumberOfWin());
    }

    @Test
    public void getNumberOfDraw() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfDraw(3);
        assertEquals(3, f1.getNumberOfDraw());
    }

    @Test
    public void setNumberOfDraw() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfDraw(3);
        assertEquals(3, f1.getNumberOfDraw());
    }

    @Test
    public void getNumberOfDefeat() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfDefeat(3);
        assertEquals(3, f1.getNumberOfDefeat());
    }

    @Test
    public void setNumberOfDefeat() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfDefeat(3);
        assertEquals(3, f1.getNumberOfDefeat());
    }

    @Test
    public void getNumberOfGoalReceived() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfGoalReceived(3);
        assertEquals(3, f1.getNumberOfGoalReceived());
    }

    @Test
    public void setNumberOfGoalReceived() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfGoalReceived(3);
        assertEquals(3, f1.getNumberOfGoalReceived());
    }

    @Test
    public void getNumberOfGoalScored() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfGoalScored(3);
        assertEquals(3, f1.getNumberOfGoalScored());
    }

    @Test
    public void setNumberOfGoalScored() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfGoalScored(3);
        assertEquals(3, f1.getNumberOfGoalScored());
    }

    @Test
    public void getNumberOfPoint() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfPoint(3);
        assertEquals(3, f1.getNumberOfPoint());
    }

    @Test
    public void setNumberOfPoint() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfPoint(3);
        assertEquals(3, f1.getNumberOfPoint());
    }

    @Test
    public void getNumberOfPlayedMatch() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfPlayedMatch(3);
        assertEquals(3, f1.getNumberOfPlayedMatch());
    }

    @Test
    public void setNumberOfPlayedMatch() {
        FootballClub f1 = new FootballClub("Burnley", "Burnley", 1882);
        f1.setNumberOfPlayedMatch(3);
        assertEquals(3, f1.getNumberOfPlayedMatch());
    }

}