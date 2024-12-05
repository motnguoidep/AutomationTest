package org.example;

public class MissingNumberFind {
    public static void main(String args){
         int[] numbers = new int[99];
         int missing = 19;

         for(int i = 0, j = 1; i < numbers.length; j++){
             if(j != missing){
                 numbers[i] = j;
                 i++;
             }
         }

         int expected = 100 * (100 + 1) / 2;

         int actual = 0;
         for(int num : numbers){
             actual += num;
         }

         int missNumber = expected - actual;
        System.out.println("missing number is: " + missNumber);
    }
}
