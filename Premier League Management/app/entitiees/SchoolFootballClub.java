package entitiees;

public class SchoolFootballClub extends FootballClub {
    // schoolName variable to store club's school name
    private String schoolName ;

    // Parameterized constructor
    public SchoolFootballClub(String schoolName, String clubName, String location, int foundedYear) {
        super(clubName, location,foundedYear);
        this.setSchoolName(schoolName);
    }

    // Getter method for school name attribute
    public String getSchoolName() {
        return schoolName;
    }

    // Setter method for school name attribute
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
