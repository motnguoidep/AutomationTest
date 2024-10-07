//package org.example;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
///*
//* tim phan tu lon nhat trong 1 mang
//* [1,4,8,9]
//*/
//public class FindMaxNumber {
//    public static void main(String[] args) {
////        cach 1
//        int[] arr = {1, 4, 9, 0, 2, 8};
//        if (arr.length == 0) throw new IllegalArgumentException("mang rong");
//
//        int max = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//        System.out.println("Phan tu lon nhat trong mang la " + max);
//
////        cach 2
//        int[] arr1 = new int[] {1, 4, 9, 0, 2, 8};
//        int max1 = Arrays.stream(arr1).max1().getAsInt();
//
//        int min = Arrays.stream(arr).min().getAsInt();
//        System.out.println(min);
//
////        cach 3
//        List<Integer> list = Arrays.stream(arr).boxed().toList();
//        int maxIndex = list.indexOf(max);
//        System.out.println(maxIndex);
//
//    }
//}
