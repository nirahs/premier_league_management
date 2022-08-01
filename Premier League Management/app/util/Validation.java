package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

//================================================== Validations =======================================================

    // Validation for yes/no input
    public static boolean booleanConfirmation(String question, String invalidMsg){
        Scanner input = new Scanner(System.in);

        // Printing the question
        System.out.println(question);

        // Converting string input to lowercase
        String confirm = input.next().toLowerCase();

        // Looping until user enters "yes"/"no"
        while(!(confirm.equals("yes") || confirm.equals("no"))){
            System.out.println(invalidMsg);
            System.out.println(question);
            confirm = input.next().toLowerCase();
        }

        switch (confirm){
            case "yes":
                return true;
            case "no":
                return false;
            default:
                throw new IllegalArgumentException("Unexpected error in boolean confirmation");
        }

    }

    // Usually clubName and clubLocation will have a-z values and space characters
    // So if a user inserts any integers or other characters for clubName and clubLocation stringValidation() method will ask for the input again until user enters valid input for clubName and clubCharacters
    public static String stringValidation(String question, String invalidMsg) {
        // Creating scanner object to get user input
        Scanner input = new Scanner(System.in);

        String stringInput;
        Pattern pattern;
        Matcher matcher;
        String[] words;
        String stringOutput;
        boolean inputInvalid = false;

        // Looping until user enters valid string without integer
        do {

            // Printing the question
            System.out.println(question);

            // Getting user input and changing into lower case
            stringInput = input.nextLine().toLowerCase();
            stringOutput = "";

            // "\\s" - whitespace
            words = (stringInput.split("\\s+"));

            // Looping through each string and trying to converting into integer
            // If it's integer for loop will break and ask again for input
            for (int i = 0; i < words.length; i++) {
                // Only characters that are between A-Z and a-z will get accepted
                pattern = Pattern.compile("[A-Za-z[^0-9!@#$%^&*()_+{}:;\"'.>,<?/~`\\|]]+");
                matcher = pattern.matcher(words[i]);
                if (matcher.matches()) {
                    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                    stringOutput = stringOutput + words[i] + " ";
                    inputInvalid = false;
                } else {
                    inputInvalid = true;
                    System.out.println(invalidMsg);
                    break;
                }
            }
        } while (inputInvalid);

        return stringOutput;
    }

    // integerValidation method is for to validate whether user inserts integer or not
    // If user inserts letters or other symbols program will print invalid message and ask again instead of throwing run time error
    // while loop with hasNextInt used in this method to achieve the above feature
    public static int positiveIntegerValidation(String question, String invalidMsg){
        Scanner input = new Scanner(System.in);

        int integerInput;

        do{
            // In this method user can't insert negative number
            System.out.println(question);
            while(!input.hasNextInt()){
                System.out.println(invalidMsg);
                System.out.println(question);
                input.next();
            }
            integerInput = input.nextInt();
            if (integerInput<0){
                System.out.println(invalidMsg);
            }
        }while(integerInput<0);

        return integerInput;
    }

    // This method used to get input between two integer values
    // Used for limited integer validation
    // Looping until user enters correct input
    public static int limitedIntegerValidation(String question, String invalidMsg, int min, int max){
        Scanner input = new Scanner(System.in);

        int integerInput;
        do {
            System.out.println(question);
            while (!input.hasNextInt()) {
                System.out.println(invalidMsg);
                System.out.println(question);
                input.next();
            }
            integerInput =input.nextInt();
            if (integerInput <min || integerInput >max){
                System.out.println(invalidMsg);
            }
        }while ((integerInput<min ||  integerInput>max));
        return integerInput;
    }

    public static LocalDate dateInputValidation(String question, String invalidMsg) {
        Scanner input = new Scanner(System.in);
        LocalDate localDate = null;
        do{
            System.out.println(question);
            String date = input.next();
            try{
                localDate = LocalDate.parse(date);
            } catch ( DateTimeParseException e ) {
                System.out.println(invalidMsg);
            }
        }while(localDate == null);
        return localDate;
    }



//   Old dateInputValidation method 
//   No longer used

//    public static Date dateInputValidation(String question, String invalidMsg) {
//
//        Scanner input = new Scanner(System.in);
//
//        Pattern pattern;
//        Matcher matcher;
//        String dateInput;
//        Date date = null;
//        int year;
//        int month;
//        int day;
//
//        // Looping until user enters valid full date
//        do{
//            // Looping until user enters valid string that matches.txt the pattern (\d\d\W\d\d\W\d\d\d\d)
//            do{
//                // Printing the question string
//                System.out.println(question);
//
//                // Getting user string input and assigning to the dateInput variable
//                dateInput = input.next();
//
//                // Regx to check whether user entered string matches the pattern
//                pattern = Pattern.compile("\\d\\d\\d\\d\\W\\d\\d\\W\\d\\d");
//                matcher = pattern.matcher(dateInput);
//                if (!matcher.matches()){
//                    System.out.println(invalidMsg);
//                }
//            }while(!matcher.matches());
//
//            // Converting the fullDate into day, month, year and type casting into integer
//            year = Integer.parseInt(dateInput.substring(0, 4));
//            month = Integer.parseInt(dateInput.substring(5, 7));
//            day = Integer.parseInt(dateInput.substring(8, 10));
//
//            // If user inserted day, month and year values were correct program will assign the dateInput string value to fullDate
//            if (Date.isYearCorrect(year) && Date.isMonthCorrect(month) && Date.isDayCorrect(year,month,day)) {
//                date = new Date (day,month,year);
//            }
//            // Other wise program will show invalid message in constructor
//            else{
//                System.out.println(invalidMsg);
//            }
//
//        }while (!Date.isYearCorrect(year) || !Date.isMonthCorrect(month) || !Date.isDayCorrect(year,month,day));
//
//        return  date;
//    }
}
