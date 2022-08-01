//package entities;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class DateTest {
//
//    @Test
//    public void getFullDate() {
//        Date date = new Date(12,11,2021);
//        assertEquals("12/11/2021", date.getFullDate());
//    }
//
//    @Test
//    public void setFullDate() {
//        Date date = new Date(12,11,2021);
//        date.setFullDate("12/11/2021");
//        assertEquals("12/11/2021", date.getFullDate());
//    }
//
//    @Test
//    public void getMonth() {
//        Date date = new Date(12,11,2021);
//        assertEquals(11, date.getMonth());
//    }
//
//    @Test
//    public void setMonth() {
//        Date date = new Date(12,11,2021);
//        date.setMonth(12);
//        assertEquals(12, date.getMonth());
//    }
//
//    @Test
//    public void getYear() {
//        Date date = new Date(12,11,2021);
//        assertEquals(2021, date.getYear());
//    }
//
//    @Test
//    public void setYear() {
//        Date date = new Date(12,11,2021);
//        date.setYear(2020);
//        assertEquals(2020, date.getYear());
//    }
//
//    @Test
//    public void getDay() {
//        Date date = new Date(12,11,2021);
//        assertEquals(12, date.getDay());
//    }
//
//    @Test
//    public void setDay() {
//        Date date = new Date(12,11,2021);
//        date.setDay(11);
//        assertEquals(11, date.getDay());
//    }
//
//    @Test
//    public void isYearCorrect() {
//        assertTrue(Date.isDayCorrect(2020, 12, 13));
//    }
//
//    @Test
//    public void isMonthCorrect() {
//        assertTrue(Date.isDayCorrect(2020, 12, 13));
//    }
//
//    @Test
//    public void isDayCorrect() {
//        assertTrue(Date.isDayCorrect(2020, 12, 13));
//    }
//}