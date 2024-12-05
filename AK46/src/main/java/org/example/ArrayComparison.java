package org.example;

import java.util.Arrays;

public class ArrayComparison {
    public static void main(String args) {
        String[] arr1 = {"tana", "linda"};
        String[] arr2 = {"adida", "phat"};

        boolean ischeck = Arrays.equals(arr1, arr2);

        if (ischeck) {
            System.out.println("giong");
        } else {
            System.out.println("khac");
        }
    }
}
