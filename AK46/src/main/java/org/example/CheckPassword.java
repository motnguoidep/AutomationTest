package org.example;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * ## 2. Password Complexity
 * len > 8 characters: >8  <8  =8
 * include number
 * include lowercases
 * include uppercases
 * include !@#$%^&*()
 *
 * **create a function**:
 *
 *     - String as input
 *     - Boolean as output
 */

public class CheckPassword {
    // Function to check password complexity
    public static boolean isPassword(String input) {
        // Return true if the input matches the pattern for a valid password
        return input.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{9,}");
    }
    public static void main(String[] args) {
        String testPassword = "Thuong123456a@"; // Change this to test different passwords
        boolean isValid = isPassword(testPassword);
        System.out.println("Is the password valid? " + isValid);
    }

}

