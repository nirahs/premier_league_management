package services;

import entitiees.*;
import util.ApplicationUtil;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

// Overriding methods and other methods
public class PremierLeagueManager implements LeagueManager{

    // private static final ArrayList<FootballClub> clubsList = new ArrayList<>();
    protected static final File clubsFile = new File("app/models/clubStatistics.txt");
    protected static final File matchesFile = new File("app/models/matches.txt");

    private static final int WIN_POINTS = 3;
    private static final int DRAW_POINTS = 1;
    private static final int DEFEAT_POINTS = 0;

    @Override
    public void addClub(FootballClub club) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());
        boolean notExist = true;
        if (clubs.size()<20) {

            for (FootballClub footballClub: clubs){
                if (footballClub.equals(club)) {
                    notExist = false;
                    break;
                }
            }

            if (notExist){
                clubs.add(club);
                saveClubs(clubs);

                System.out.println("Club successfully added to the system");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Name          : " + club.getClubName());
                System.out.println("Location      : " + club.getLocationName());
                System.out.println("Founded year  : " + club.getFoundedYear());
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Stored clubs  : " + clubs.size());
                System.out.println("Space         : " + (20- clubs.size()));
            }else{
                System.out.println("Invalid, Already a club exist with similar details");
            }
        }else {
            System.out.println("Invalid, Maximum number of club limit already passed!");
        }
    }


    @Override
    public void deleteExistingClub(FootballClub club, boolean deleteFromTheList) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());
        for (FootballClub footballClub : clubs) {
            if (footballClub.equals(club)){
                if (deleteFromTheList) {
                    clubs.remove(footballClub);
                    saveClubs(clubs);
                    System.out.println(footballClub.getClubName() + " club removed from the system");
                }else{
                    System.out.println(footballClub.getClubName()+ " club not removed from the system");
                }
                return;
            }
        }System.out.println("Invalid, Check the club index!");
    }


    @Override
    public void displayStatistics(FootballClub club) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());
        for (FootballClub footballClub : clubs){
            if (footballClub.equals(club)){
                System.out.println(footballClub.toString());
                return;
            }
        }System.out.println("Invalid, Check the club index!");

    }


    @Override
    public void displayPremierLeagueTable() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());
        String values = "| %-21s | %-5d | %-5d | %-6d | %-5d | %-5d | %-6d | %-5d |%n";

        System.out.format("+-----------------------+-------+-------+--------+-------+-------+--------+-------+%n");
        System.out.format("|       Club Name       |  Win  | Draws | Defeat |  GR   |  GS   | Points | Match |%n");
        System.out.format("+-----------------------+-------+-------+--------+-------+-------+--------+-------+%n");

        for (FootballClub club : bubbleSortByClubPointsAndHighestGoal(clubs)){
            System.out.printf(values,club.getClubName(),club.getNumberOfWin(),club.getNumberOfDraw(),club.getNumberOfDefeat(),club.getNumberOfGoalReceived(),club.getNumberOfGoalScored(),club.getNumberOfPoint(),club.getNumberOfPlayedMatch());
        }

        System.out.format("+-----------------------+-------+-------+--------+-------+-------+--------+-------+%n");
    }


    public static ArrayList<FootballClub> bubbleSortByClubPointsAndHighestGoal(ArrayList<FootballClub> footballClubArrayList){
        int listSize = footballClubArrayList.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if (footballClubArrayList.get(j).compareTo(footballClubArrayList.get(j + 1)) < 0) {
                    FootballClub temp = footballClubArrayList.get(j);
                    footballClubArrayList.set(j, footballClubArrayList.get(j + 1));
                    footballClubArrayList.set(j + 1, temp);
                }
            }
        }return footballClubArrayList;
    }


    @Override
    public void updateClubs(Match match) throws IOException, ClassNotFoundException {
        ArrayList<Match> matches = new ArrayList<>(loadMatchesAsArray());

        if (match.isMatchDraw()) {
            updateClub(match.getClub1(), 1, 0, 0, DRAW_POINTS, match.getClub2Score(), match.getClub1Score());
            updateClub(match.getClub2(), 1, 0, 0, DRAW_POINTS, match.getClub1Score(), match.getClub2Score());
        } else if (!match.isMatchDraw()) {
            updateClub(match.getMatchWinner(), 0, 1, 0, WIN_POINTS, match.getLooserClubScore(), match.getWinnerClubScore());
            updateClub(match.getMatchLooser(), 0, 0, 1, DEFEAT_POINTS, match.getWinnerClubScore(), match.getLooserClubScore());
        } else {
            System.out.println("Unexpected error while updating club details!");
        }

        matches.add(match);
        saveMatches(matches);
    }

    @Override
    public void updateClubWithRandomMatchDetails() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());

        FootballClub randomClub1 = null;
        FootballClub randomClub2 = null;

        do {
            try{
                randomClub1 = clubs.get(((int)((Math.random() * (clubs.size())))));
                randomClub2 = clubs.get((int)((Math.random() * (clubs.size()))));
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Invalid, Please add two clubsList to the system to create random match!");
                break;
            }
        }while(randomClub1.equals(randomClub2));

        int randomClub1Score = (int) (Math.random() * 15);
        int randomClub2Score = (int) (Math.random() * 15);

        LocalDate date = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 2))));;
        Match match = new Match(randomClub1, randomClub2, randomClub1Score, randomClub2Score, date);
        updateClubs(match);
    }

    public void updateClub(FootballClub club, int draw, int win, int defeat, int numOfPoints, int goalReceived, int goalScored) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(loadClubsAsArray());

        for (FootballClub footballClub:clubs) {
            if(footballClub.equals(club)){
                footballClub.setNumberOfPlayedMatch(club.getNumberOfPlayedMatch() + 1);
                footballClub.setNumberOfDraw(club.getNumberOfDraw() + draw);
                footballClub.setNumberOfWin(club.getNumberOfWin() + win);
                footballClub.setNumberOfDefeat(club.getNumberOfDefeat() + defeat);
                footballClub.setNumberOfPoint(club.getNumberOfPoint() + numOfPoints);
                footballClub.setNumberOfGoalReceived(club.getNumberOfGoalReceived() + goalReceived);
                footballClub.setNumberOfGoalScored(club.getNumberOfGoalScored() + goalScored);
            }
        }

        saveClubs(clubs);
    }

    // When we are overriding unchecked exception and we can only add checked exception
    // We can sub class of the mentioned exception in interface
    // We can't use new or broader exception (broader exception means throwing FileNotFound Exception in overridden method and using IO exception in overriding method )
    @Override
    public void saveClubs(ArrayList<FootballClub> clubs) throws IOException {
        FileOutputStream fos = new FileOutputStream(clubsFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (FootballClub footballClub:clubs) {
            oos.writeObject(footballClub);
        }

        oos.flush();
        fos.close();
        oos.close();
    }


    @Override
    public ArrayList<FootballClub> loadClubsAsArray() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(PremierLeagueManager.clubsFile);

        ArrayList<FootballClub> clubs = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (;;) {
                try{
                    FootballClub club = (FootballClub) ois.readObject();
                    clubs.add(club);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        }catch (EOFException ignore){}
        fis.close();
        return clubs;
    }

    @Override
    public void saveMatches(ArrayList<Match> matches) throws IOException {
        FileOutputStream fos = new FileOutputStream(PremierLeagueManager.matchesFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Match match:matches) {
            oos.writeObject(match);
        }

        oos.flush();
        fos.close();
        oos.close();
    }


    @Override
    public ArrayList<Match> loadMatchesAsArray() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(PremierLeagueManager.matchesFile);

        ArrayList<Match> matches = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (;;) {
                try{
                    Match match = (Match) ois.readObject();
                    matches.add(match);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        }catch (EOFException ignore){}
        fis.close();
        return matches;
    }


}
