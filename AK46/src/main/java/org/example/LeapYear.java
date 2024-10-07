package org.example;

public class LeapYear {
    /**
     * Viet mot func nam nhuan
     * input year - int
     * return true if leap year
     * return false if not
     *
     * @return
     */

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0 );
    }
}
