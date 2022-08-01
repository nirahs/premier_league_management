package entitiees;

import java.io.Serializable;

// SportsClub is abstract class, So SportsClub cannot be instantiated but SportsClub can be sub classed
public abstract class SportsClub implements Serializable {

    // Instance variable for sports club class

    // clubName variable to store club name
    private String clubName;
    // location variable to store club's area name
    private String locationName;
    // foundedYear variable to store club's founded year
    private int foundedYear;

    // Parameterized constructor for sports club
    public SportsClub(String clubName, String location, int foundedYear){
        super();
        // Validation before creating object using setter method
        this.setClubName(clubName);
        this.setLocationName(location);
        this.setFoundedYear(foundedYear);
    }

    // Getter method for club name variable
    public String getClubName(){
        return clubName;
    }

    // Getter method for location name variable
    public String getLocationName(){
        return locationName;
    }

    // Getter method for founded year variable
    public int getFoundedYear() {
        return foundedYear;
    }

    // Setter method for club name variable
    public void setClubName(String clubName){
        this.clubName = clubName;
    }

    // Setter method for location name variable
    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    // Setter method for founded year variable
    public void setFoundedYear(int foundedYear) {
        if (foundedYear>=1750 && foundedYear<=2021){
            this.foundedYear = foundedYear;
        }else{
            throw new IllegalArgumentException("Invalid founded year, Please try again!");
        }
    }

    // toString method for SportsClub class
    @Override
    public String toString(){
        return    "Club Name     : " + getClubName()
                + "\nFounded Year  : " + getFoundedYear()
                + "\nLocation Name : " + getLocationName();
    }

    @Override
    public boolean equals(Object o) {
        SportsClub sportsClub = (SportsClub) o;
        return this.foundedYear == sportsClub.foundedYear && this.clubName.equals(sportsClub.clubName) && this.locationName.equals(sportsClub.locationName);
    }

}
