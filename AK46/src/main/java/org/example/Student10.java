//package org.example;
//
//import java.util.Comparator;
//
//public class Student10 {
//
//    public static void main(String[] args){
//        List<Student> students = List.of(
//
//                new Student("Tran"),
//
//                new Student("Loc"),
//
//                new Student("Huong"),
//
//                new Student("Hop"),
//
//                new Student("Thao"),
//
//                new Student("Tram"),
//
//                new Student("Cuong"),
//
//                new Student("Que"),
//
//                new Student("Hieu")
//
//        );
////        for(Student student : students){
////            student.info();
////            System.out.println("\n===========");
////        }
//        Student maxMathPointStudent = students
//                .stream()
//                .max(Comparator.comparing(Student::getMath))
//                .get();
//
//        System.out.println("===== max Math point Student ====");
//        maxMathPointStudent.infor();
//
//        List<Integer> mathPoints = students
//                .stream()
//                .map(Student::getMath)
//                .toList();
//
//        for(int p :mathPoints){
//            System.out.println(p);
//        }
//
//
//
////
//    }
//}
