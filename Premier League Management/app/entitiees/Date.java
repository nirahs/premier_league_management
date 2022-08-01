package entitiees;

// Date class no longer used

// package entities;
//
//import java.io.Serializable;
//
//public class Date implements Serializable {
//    private static final int END_YEAR = 2022;
//    private static final int START_YEAR = 2020;
//
//    private String fullDate;
//    private int day;
//    private int month;
//    private int year;
//
//    // Non parameterized constructor
//    public Date(int day, int month, int year){
//        super();
//        this.setMonth(month);
//        this.setYear(year);
//        this.setDay(day);
//        this.setFullDate((getDay()<10?("0"+getDay()):getDay())+"/"+(getMonth()<10?("0"+getMonth()):getMonth())+"/"+getYear());
//    }
//
//    public String getFullDate() {
//        // Getter method for the fullDate instance attribute
//        return fullDate;
//    }
//
//    public void setFullDate(String fullDate) {
//        // Setter method for the fullDate instance attribute
//        this.fullDate = fullDate;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public void setMonth(int month) {
//        if (isMonthCorrect(month)){
//            this.month = month;
//        }else{
//            throw new IllegalArgumentException("Invalid, Month is incorrect");
//        }
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        if (isYearCorrect(year)){
//            this.year = year;
//        }else {
//            throw new IllegalArgumentException("Invalid, Year is incorrect");
//        }
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public void setDay(int day) {
//        if (isDayCorrect(getYear(),getMonth(),day)){
//            this.day = day;
//        }else throw new IllegalArgumentException("Invalid, Date is incorrect");
//    }
//
//    // Validating the user inserted year value
//    // If user enter the correct year isYearCorrect() method will return true other wise false
//    // Year value can be either 2020 or 2021
//    public static boolean isYearCorrect(int year) {
//        return year >= START_YEAR && year <= END_YEAR;
//    }
//
//    // Validating user inserted month value
//    // If user enter the correct month isMonthCorrect() method wil return true other wise false
//    // Month value can be any integer value between 0-12
//    public static boolean isMonthCorrect(int month) {
//        return month >= 1 && month <= 12;
//    }
//
//    // Validating user inserted date value
//    // isDayCorrect() method will check date value based on the month and year
//    // Because leap year will 29 days in february and some months wil have 30 days some months will have 31 days
//    // So isDayCorrect() method will go through user entered month and year and if the date value for that month and year is correct, method will return true
//    // Otherwise method will return false
//    public static boolean isDayCorrect(int year, int month, int day) {
//        // For month with 31 days
//        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
//            return day >= 1 && day <= 31;
//        }
//        // For month with 30 days
//        else if (month == 4 || month == 6 || month == 9 || month == 11) {
//            return day >= 1 && day <= 30;
//        }
//        // Leap year
//        // For month with 28/29 days in February
//        else if(month == 2){
//            if (year % 4 == 0) {
//                return day >= 1 && day <= 29;
//            } else {
//                return day >= 1 && day <= 28;
//            }
//        }
//        return false;
//    }
//
//}