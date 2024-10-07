package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelTest {
    //2:22
    @Test
    void verify_u_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("u"));
    }
    @Test
    void verify_e_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("e"));
    }
    @Test
    void verify_o_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("o"));
    }
    @Test
    void verify_a_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("a"));
    }
    @Test
    void verify_i_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("i"));
    }
    @Test
    void verify_U_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("U"));
    }
    @Test
    void verify_E_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("E"));
    }
    @Test
    void verify_O_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("O"));
    }
    @Test
    void verify_A_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("A"));
    }
    @Test
    void verify_I_is_vowel(){
        Assert.assertTrue(Vowels.isVowel("I"));
    }

    @Test
    void verify_h_is_not_vowel(){
        Assert.assertFalse(Vowels.isVowel("h"));
    }
    @Test
    void verify_H_is_not_vowel(){
        Assert.assertFalse(Vowels.isVowel("H"));
    }

    @Test
    void verify_exception(){
        try{
            Vowels.isVowel("");
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "input string length must be equal 1" );
        }
    }

}
