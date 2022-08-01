package entitiees;


// UniversityFootballClub class
public class UniversityFootballClub extends FootballClub {

    // to store club's university name
    private String universityName;

    // Parametrized constructor
    public UniversityFootballClub(String universityName, String clubName, String location, int foundedYear) {
        super(clubName, location, foundedYear);
        this.setUniversityName(universityName);
    }

    // Getter method for University name
    public String getUniversityName() {
        return universityName;
    }

    // Setter method for university name
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}
