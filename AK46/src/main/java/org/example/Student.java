package org.example;

/*
* Tao class Student voi cac thuoc tinh
* Name
* ID => random 1 chuoi prefix TVN-<number>
* Math: 0-10
* Physic: 0-10
* Chemistry: 0-10
* Constructor: new Student(String name)
* */

import java.util.Random;

public class Student {
    private String name;
    private String id;
    private double math;
    private double physics;
    private double chemistry;

//    constructor
    public Student(String name){
        this.name = name;
        this.id = generateId();
        this.math = generateRandomScore();
        this.physics = generateRandomScore();
        this.chemistry = generateRandomScore();
    }

//    tao id ngau nhien
    private static String generateId(){
        return "TVN-" + new Random().nextInt(1000);
    }

//    tao diem ngau nhien tu 0 - 10
    private static double generateRandomScore(){
        return Math.round(new Random().nextDouble() * 10 * 10.0) /10.0;
    }

//    Getters
    public String getName(){ return name;}
    public String getId(){ return id;}
    public double getMath(){ return math;}
    public double getPhysics(){ return physics;}
    public double getChemistry(){ return chemistry;}




}
