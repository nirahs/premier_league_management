package services;

import java.io.*;
import java.util.ArrayList;
import entitiees.*;
import util.ApplicationUtil;

public class LeagueService {

    static LeagueManager manager = new PremierLeagueManager();

    public ArrayList<FootballClub> getClubsListSortedByPoints() throws IOException, ClassNotFoundException {
        return  ApplicationUtil.bubbleSortByClubPointsAndGoalScored(manager.loadClubsAsArray());
    }

    public ArrayList<FootballClub> getClubsListSortedByWins() throws IOException, ClassNotFoundException {
        return  ApplicationUtil.bubbleSortByClubWins(manager.loadClubsAsArray());
    }

    public ArrayList<FootballClub> getClubsListSortedByGoalScored() throws IOException, ClassNotFoundException {
        return  ApplicationUtil.bubbleSortByClubGoalScored(manager.loadClubsAsArray());
    }

    public ArrayList<Match> createRandomMatches() throws IOException, ClassNotFoundException {
        manager.updateClubWithRandomMatchDetails();
        return manager.loadMatchesAsArray();
    }

    public ArrayList<Match> getMatchesList() throws IOException, ClassNotFoundException {
        return manager.loadMatchesAsArray();
    }

    public ArrayList<Match> getMatchesListSortedByDate() throws IOException, ClassNotFoundException {
        return ApplicationUtil.bubbleSortByMatchDate(manager.loadMatchesAsArray());
    }

    public ArrayList<Match> getSpecificMatches(String fullDate) throws IOException, ClassNotFoundException {
        ArrayList<Match> matchesForSpecificDate = new ArrayList<>();
        for (Match match: manager.loadMatchesAsArray()) {
            if (match.getMatchDate().toString().equals(fullDate)){
                matchesForSpecificDate.add(match);
            }
        }
        return matchesForSpecificDate;
    }


}