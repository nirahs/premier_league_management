package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.FootballClub;
import entities.Match;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.LeagueService;

import java.io.IOException;
import java.util.ArrayList;
/*
    Sorting
	    points
	    number of wins
	    number of goal scored

    Searching using date

    Creating random matches
*/


public class LeagueController extends Controller {

    static LeagueService leagueService = new LeagueService();

    public Result index(Http.Request request){
        return ok("You made a "+request+"!");
    }

    public Result clubListSortedByPointsAndGoalScored() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = leagueService.getClubsListSortedByPoints();
        ObjectMapper mapper = new ObjectMapper();
        // JsonNode json = Json.toJson(clubs);
        JsonNode jsonClubObjects = mapper.convertValue(clubs,JsonNode.class);
        return ok((jsonClubObjects));
    }

    public Result clubListSortedByNoOfWins() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = leagueService.getClubsListSortedByWins();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonClubObjects = mapper.convertValue(clubs,JsonNode.class);
        return ok(jsonClubObjects);
    }

    public Result clubListSortedByNoOfGoalScored() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = leagueService.getClubsListSortedByGoalScored();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonClubObjects = mapper.convertValue(clubs,JsonNode.class);
        return ok(jsonClubObjects);
    }

    public Result createRandomMatch() throws IOException, ClassNotFoundException {
        ArrayList<Match> matches = leagueService.createRandomMatches();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMatchObjects = mapper.convertValue(matches,JsonNode.class);
        return ok(jsonMatchObjects);
    }

    public Result matchList() throws IOException, ClassNotFoundException {
        ArrayList<Match> matches = leagueService.getMatchesList();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMatchObjects = mapper.convertValue(matches,JsonNode.class);
        return ok(jsonMatchObjects);
    }

    public Result matchListSortedByDate() throws IOException, ClassNotFoundException {
        ArrayList<Match> matches = leagueService.getMatchesListSortedByDate();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMatchObjects = mapper.convertValue(matches,JsonNode.class);
        return ok(jsonMatchObjects);
    }

    public Result matchesInSpecificDate(String fullDate) throws IOException, ClassNotFoundException {
        ArrayList<Match> matches = leagueService.getSpecificMatches(fullDate);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonMatchObjects = mapper.convertValue(matches,JsonNode.class);
        return ok(jsonMatchObjects);
    }
}
