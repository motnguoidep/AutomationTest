package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExerciseTest {
    // Kiem tra so chan or le
    @Test
    void verify_10_is_EvenNumber(){
        Assert.assertTrue(Exercise.checkEvenOdd(10));
    }

    @Test
    void verify_11_is_OddNumber(){
        Assert.assertFalse(Exercise.checkEvenOdd(11));
    }

    @Test
    void verify_o_is_Oddnumber(){
        Assert.assertTrue(Exercise.checkEvenOdd(0));
    }




}

