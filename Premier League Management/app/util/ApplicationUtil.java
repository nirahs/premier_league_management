package util;

import java.io.*;
import java.util.ArrayList;
import play.libs.Json;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entitiees.Match;
import entitiees.FootballClub;
import services.PremierLeagueManager;

public class ApplicationUtil {

    private static final File matchesFile = new File("app/services/matches.txt");
    private static final PremierLeagueManager plm = new PremierLeagueManager();

    public static ObjectNode createResponse(Object response, boolean ok) {
        ObjectNode result = Json.newObject();
        result.put("state", ok);
        if (response instanceof String) {
            result.put("body", (String) response);
        } else {
            result.putPOJO("body", response);
        }
        return result;
    }

    public static ArrayList<FootballClub> bubbleSortByClubPointsAndGoalScored(ArrayList<FootballClub> footballClubArrayList){
        int listSize = footballClubArrayList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if ((footballClubArrayList.get(j)).compareTo(footballClubArrayList.get(j + 1)) < 0) {
                    FootballClub temp = footballClubArrayList.get(j);
                    footballClubArrayList.set(j, footballClubArrayList.get(j + 1));
                    footballClubArrayList.set(j + 1, temp);
                }
            }
        }return footballClubArrayList;
    }

    public static ArrayList<FootballClub> bubbleSortByClubWins(ArrayList<FootballClub> footballClubArrayList){
        int listSize = footballClubArrayList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if (footballClubArrayList.get(j).getNumberOfWin()-(footballClubArrayList.get(j + 1)).getNumberOfPoint() < 0) {
                    FootballClub temp = footballClubArrayList.get(j);
                    footballClubArrayList.set(j, footballClubArrayList.get(j + 1));
                    footballClubArrayList.set(j + 1, temp);
                }
            }
        }return footballClubArrayList;
    }

    public static ArrayList<FootballClub> bubbleSortByClubGoalScored(ArrayList<FootballClub> footballClubArrayList){
        int listSize = footballClubArrayList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if (footballClubArrayList.get(j).getNumberOfGoalScored()-(footballClubArrayList.get(j + 1)).getNumberOfGoalScored() < 0) {
                    FootballClub temp = footballClubArrayList.get(j);
                    footballClubArrayList.set(j, footballClubArrayList.get(j + 1));
                    footballClubArrayList.set(j + 1, temp);
                }
            }
        }return footballClubArrayList;
    }

    public static ArrayList<Match> bubbleSortByMatchDate(ArrayList<Match> matchArrayList){
        int listSize = matchArrayList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if ((matchArrayList.get(j)).compareTo(matchArrayList.get(j + 1)) < 0) {
                    Match temp = matchArrayList.get(j);
                    matchArrayList.set(j, matchArrayList.get(j + 1));
                    matchArrayList.set(j + 1, temp);
                }
            }
        }return matchArrayList;
    }


}
