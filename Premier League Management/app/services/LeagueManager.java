package services;

import entitiees.*;
import java.io.IOException;
import java.util.ArrayList;

// Overridden methods
public interface LeagueManager {

    // Create club method is to create Football club or School Football Club or University Football club
    void addClub(FootballClub club) throws IOException, ClassNotFoundException;

    // Delete the selected club from the arraylist
    void deleteExistingClub(FootballClub club, boolean deleteFromList) throws IOException, ClassNotFoundException;

    // Print details related to a specific club using footballClubNo
    void displayStatistics(FootballClub club) throws IOException, ClassNotFoundException;

    // Print club statistics in table format
    // Details will be printed in points, goal scored and goal received order
    void displayPremierLeagueTable() throws IOException, ClassNotFoundException;

    // Update club details based on match
    void updateClubs(Match match) throws IOException, ClassNotFoundException;

    // Update two random clubs with random scores
    void updateClubWithRandomMatchDetails() throws IOException, ClassNotFoundException;

    // Save football club objects into text file
    void saveClubs(ArrayList<FootballClub> clubs) throws IOException;

    // Read the clubs from the text file and return the clubs as arraylist
    ArrayList<FootballClub> loadClubsAsArray() throws IOException,ClassNotFoundException;

    // Save matches will save match details by updating both clubs
    void saveMatches(ArrayList<Match> matches) throws IOException;

    // Read the matches from the text file and return the clubs as arraylist
    ArrayList<Match> loadMatchesAsArray() throws IOException,ClassNotFoundException;

}
