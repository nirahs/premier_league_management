package applications;

import util.Validation;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import services.LeagueManager;
import services.PremierLeagueManager;
import services.ConsoleService;
import entities.FootballClub;
import entities.Match;

public class ConsoleApplication{
    // Programming to the super type not to the subtype to avoid tight coupling
    static LeagueManager manager = new PremierLeagueManager();
    // To display team details
    static ConsoleService consoleService = new ConsoleService();

    public static void main(String [] args) throws IOException, ClassNotFoundException {

//====================================== Welcome message and Displaying options ========================================

        // Welcome message will be displayed when program starts
        System.out.println("\n\t\t\t\t -- Welcome to Premier League --");
        System.out.println("\t\t\t\t  -- Command Line Interface --\n");

        // Looping until user enters specific number to exit out of the loop (Number : 7)
        boolean run = true;
        while(run) { // Loop until run variable become false
            int selectedOption;
            int subSelectedOption;

            // Instructions to call the specific functions
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Level : Activating functionalities\n");
            System.out.println("Type the number to activate specific functionality");
            System.out.println("\t(1) Add new football club");
            System.out.println("\t(2) Delete existing club");
            System.out.println("\t(3) Display statistics for specific club");
            System.out.println("\t(4) Display premier league table");
            System.out.println("\t(5) Update club");
            System.out.println("\t(6) GUI");
            System.out.println("\t(7) Exit");
            System.out.println("----------------------------------------------------------------------------------------");

            /*
             * limitedIntegerValidation is a hardcoded method which will get two String parameters (question, invalid message) and two integers (minimum and maximum values).
             * And ask for the user input and checking whether it's correct or not (Only the inputs which are between min and max will be returned)).
             * If it's correct return the user entered input to the variable.
             * If not method will ask for the input again and again until user enters correct info.
             * Inside the method there is a do while loop to loop until user enters expected input.
             */
            selectedOption = Validation.limitedIntegerValidation("What function do you want to activate? (1-7)","Invalid, Unavailable option!",1,7);

            switch (selectedOption){
                case 1:

                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Add club");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);
                    if (subSelectedOption==1){

                        /*
                         * addClub() method is used to add the created club into array list
                         * This method will get FootballClub objects as parameter
                         * getInputAndCreateClub() method will ask for user input and create a club and return it
                         */
                        manager.addClub(getInputAndCreateClub());
                    }
                    break;

                case 2:

                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Delete club");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);
                    if (subSelectedOption==1){
                        /*
                         * deleteExistingClub() method is used to delete the existing club from the list
                         * This method will get integer (index number of the club index) as parameter to delete the specific club
                         */

                        if (consoleService.getNoOfClubs()>0){
                            manager.deleteExistingClub(getIndexAndReturnClub("What's the club index number?","Invalid, Unavailable option!",1,consoleService.getNoOfClubs()), getFinalConfirmation());
                        }else{
                            System.out.println("Invalid, Not any clubs have been saved to the system to remove!");
                        }
                    }
                    break;

                case 3:
                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Display statistics for specific club");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);
                    if (subSelectedOption==1){
                        /*
                         * displayStatistics() method is used to display the statistics of existing club from the list
                         * This method will get integer (index number of the club) as parameter to display that specific club statistics
                         */
                        if (consoleService.getNoOfClubs()>0){
                            manager.displayStatistics(getIndexAndReturnClub("What's the club index number?","Invalid, Unavailable option!",1,consoleService.getNoOfClubs()));
                        }else{
                            System.out.println("Invalid, Not any clubs have been saved to the system to display!");
                        }

                    }
                    break;

                case 4:
                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Display statistics in table view");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);
                    if (subSelectedOption==1){
                        // displayPremierLeagueTable() method is used to print premier league club's statistics in table view in console.
                        if (consoleService.getNoOfClubs()>0){
                            manager.displayPremierLeagueTable();
                        }else{
                            System.out.println("Invalid, Not any clubs have been saved to the system to display!");
                        }
                    }
                    break;

                case 5:
                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Update club");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);
                    if (subSelectedOption==1){
                        /*
                         * updateClub() method is used to update club details
                         * This method will get Match object as parameter
                         * Then updateClub() method will update the clubs statistics which were participated in the match
                         * getInputAndReturnMatch() method will get input from user and create club and return it
                         */
                        if (consoleService.getNoOfClubs()>0){
                            manager.updateClubs(getInputAndReturnMatch());
                        }else{
                            System.out.println("Invalid, Not any clubs have been saved to the system to update!");
                        }
                    }
                    break;

                case 6:
                    // User can go back to the main menu by inserting 2. So, if a user accidentally inserted an different integer user don't need to rerun
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Type the number to activate specific functionality");
                    System.out.println("\t(1) Display gui");
                    System.out.println("\t(2) Back");
                    System.out.println("----------------------------------------------------------------------------------------");

                    subSelectedOption = Validation.limitedIntegerValidation("What do you want to do? (Continue/Back)","Invalid, Unavailable option!",1,2);

                    if (subSelectedOption==1){
                        Runtime.getRuntime().exec("sbt run");
                        // TODO Check and remove
                        // System.out.println("Please follow the bellow steps to run gui");
                        // System.out.println("\t(1) Open cmd and type change the directory using \"cd ui\"");
                        // System.out.println("\t(2) Now type \"npm install\" and click enter");
                        // System.out.println("\t(3) Open another cmd or terminal and type \"sbt run\"");
                        // System.out.println("\t(4) Then click enter");
                        // System.out.println("\t(5) Now open another new cmd or terminal");
                        // System.out.println("\t(6) In the new terminal or cmd type \"ng serve --open\"");
                        // System.out.println("\t(7) Then click enter");
                        // System.out.println("\t(8) Now wait for a minute gui will open in your brownser");
                        // System.out.println();
                        // System.out.println("* In the above steps when opening the cmd or terminal always set the directory to project folder");
                    }
                    break;

                case 7:
                    run = false;
                    System.out.println("Thank you for using this program!");
                    break;

                default:
                    // If some bug let user to input other integer that are not in limit (min,max), program will throw and error and stop
                    throw new IllegalArgumentException("Unexpected error in calling the functionalities!");
            }
        }
    }


//================================================= Getting Input ======================================================

    // getInputAndCreateClub() method is used to get inputs from user and create a FootballClub object with user inputs and returning the FootballClub object
    public static FootballClub getInputAndCreateClub(){

        // Usually clubName and clubLocation will have a-z values and space characters
        // So if a user inserts any integers or other characters for clubName and clubLocation stringValidation() method will ask for the input again until user enters valid input for clubName and clubCharacters
        String clubName = Validation.stringValidation("What's the club name?","Invalid, Club name should contain only alphabets!");
        String clubLocation = Validation.stringValidation("What's the club location?","Invalid, Club name should contain only alphabets!");

        // Only integer inputs that are between 1850 and 2020 will get accept
        // If user inserts any other integers that are not between 1850 and 2020, then limitedIntegerValidation() method will ask the user to reenter until user enters valid input
        // Because user can't enter invalid year values
        int foundedYear = Validation.limitedIntegerValidation("What's the club founded year?","Invalid, Year can't be less than 1750 or greater than 2021!",1750, LocalDate.now().getYear());

        return new FootballClub(clubName,clubLocation,foundedYear);
    }

    // getInputAndReturnMatch() method is used to get inputs from user and create Match object with user inputs and returning the match object
    public static Match getInputAndReturnMatch() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);

        FootballClub club1;
        FootballClub club2;

        do {
            club1 = getIndexAndReturnClub("What's the club-1 index number?","Invalid, Unavailable index number!",1,consoleService.getNoOfClubs());
            club2 = getIndexAndReturnClub("What's the club-2 index number?","Invalid, Unavailable index number!",1,consoleService.getNoOfClubs());

            if (club1.equals(club2)) System.out.println("Invalid, Both clubs can't be similar in a match!");

        }while (club1.equals(club2));

        // Getting club scores from users and assigning to the variables
        // Goals can be between 0 and 15 because goal record in a match is 13
        int club1Score = Validation.limitedIntegerValidation("What's the club-1 score?","Invalid, Club score can't be less than 0 or greater than 20!",0,20);
        int club2Score = Validation.limitedIntegerValidation("What's the club-2 score?","Invalid, Club score can't be less than 0 or greater than 20!",0,20);

        // Calling Date class method (getDateFromUserInput())
        // This method is used to get string input for date of the match
        LocalDate dateOfMatch = Validation.dateInputValidation("What's the date of the match?","Invalid, Match date can't be past!");
        // TODO Validation.dateInputValidation("What's the date of the match?","Invalid, Match date can't be past!");

        return new Match(club1,club2,club1Score,club2Score,dateOfMatch);
    }


    public static FootballClub getIndexAndReturnClub(String question, String invalidMsg, int min, int max) throws IOException, ClassNotFoundException {
        // manager.displayClubNameIndex() method will print club name and their index
        consoleService.displayClubNameWithIndex();

        // manger.getClubNameForIndex() method will get user input
        return consoleService.getClubForIndex(Validation.limitedIntegerValidation(question, invalidMsg, min, max));
    }

    public static boolean getFinalConfirmation(){
        return Validation.booleanConfirmation("Do you want to delete the club? (Yes/No)","Invalid, Unavailable option!");
    }
}










