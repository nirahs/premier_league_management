package services;

import entitiees.FootballClub;
import java.io.IOException;
import java.util.ArrayList;

public class ConsoleService {

    static LeagueManager manager = new PremierLeagueManager();

    public void displayClubNameWithIndex() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(manager.loadClubsAsArray());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Type the index number to choose the specific club");
        for (int i = 0; i < clubs.size(); i++){
            System.out.println("\t(" + (i+1) + ") " + clubs.get(i).getClubName());
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public FootballClub getClubForIndex(int clubIndex) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(manager.loadClubsAsArray());
        return clubs.get(clubIndex-1);
    }

    public int getNoOfClubs() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> clubs = new ArrayList<>(manager.loadClubsAsArray());
        return clubs.size();
    }

}
