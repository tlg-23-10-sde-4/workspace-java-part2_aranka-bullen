package com.training;

class Instructor {
    //share among all Instructor objects
    private static  final Projector projector = new Projector();


    //instances variables for each Instructor object
    private final String name;
    private final int yearsExperience;

    //Constructors
    Instructor(String name, int yearsExperience) {
        System.out.println("Instructor ctor called");
        this.name = name;
        this.yearsExperience = yearsExperience;
    }

    public static void touch() {
        System.out.println("Instructor's touch method() called");
    }

    public String getName() {
        return name;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    static {
       System.out.println("static fields initialized, Instructor.class loaded into memory");
   }
}