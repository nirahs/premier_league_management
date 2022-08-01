package entities;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MatchTest {

    @Test
    public void getClub1() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(f1, match.getClub1());
    }

    @Test
    public void setClub1() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        match.setClub2(f3);
        assertEquals(f3, match.getClub2());
    }

    @Test
    public void getClub2() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(f2, match.getClub2());
    }

    @Test
    public void setClub2() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        match.setClub2(f3);
        assertEquals(f3, match.getClub2());

    }

    @Test
    public void getClub1Score() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(12, match.getClub1Score());

    }

    @Test
    public void setClub1Score() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        match.setClub1Score(14);
        assertEquals(14, match.getClub1Score());

    }

    @Test
    public void getClub2Score() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        match.setClub2Score(12);
        assertEquals(12, match.getClub2Score());

    }

    @Test
    public void setClub2Score() {

        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        match.setClub2Score(12);
        assertEquals(12, match.getClub2Score());

    }

    @Test
    public void getMatchDate() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(d, match.getMatchDate());
    }

    @Test
    public void getMatchWinner() {

        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(f2, match.getMatchWinner());

    }

    @Test
    public void getMatchLooser() {

        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(f1, match.getMatchLooser());

    }

    @Test
    public void isMatchDraw() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertFalse(match.isMatchDraw());

    }

    @Test
    public void getWinnerClubScore() {
        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(13, match.getWinnerClubScore());

    }

    @Test
    public void getLooserClubScore() {

        FootballClub f1 = new FootballClub("Aston Villa", "Aston Villa", 1886);
        FootballClub f2 = new FootballClub("Burnley", "Burnley", 1882);
        FootballClub f3 = new FootballClub("Burn", "Burn", 1982);
        LocalDate d = LocalDate.of(12, 11, 2021);
        Match match = new Match(f1, f2, 12, 13, d);
        assertEquals(12, match.getLooserClubScore());

    }
}