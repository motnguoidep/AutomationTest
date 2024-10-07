package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeapYearTest {
    @Test
    void verify_2024_is_leap_year(){
        Assert.assertTrue(LeapYear.isLeapYear(2024));
    }
    @Test
    void verify_1200_is_leap_year(){
        Assert.assertTrue(LeapYear.isLeapYear(1200));
    }
    @Test
    void verify_400_is_leap_year(){
        Assert.assertTrue(LeapYear.isLeapYear(400));
    }
    @Test
    void verify_800_is_leap_year(){
        Assert.assertTrue(LeapYear.isLeapYear(800));
    }

    @Test
    void verify_2023_is_not_leap_year(){
        Assert.assertFalse(LeapYear.isLeapYear(2023));
    }
    @Test
    void verify_100_is_not_leap_year(){
        Assert.assertFalse(LeapYear.isLeapYear(100));
    }



}
