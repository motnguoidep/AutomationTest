package org.example;

public class Vowels {
    /**
     * Viet 1 ham kiem tra 1 ky tu nhap vao co phai la so nguyen am(vowels) hay ko?
     * return true => vowels
     * return false => not vowels
     * ueoaiUEOAI
     *
     * @return
     */

    public static boolean isVowel(String input){
        if(input.length() != 1) throw new IllegalArgumentException("");
        return "ueoaiUEOAI".contains(input);
    }

}
