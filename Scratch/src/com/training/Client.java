package com.training;

class Client {

    public static void main(String[] args) {

        //Projector projector = new Projector();

        //classloader loads Instructor.class, which initializes that static "shared"
        //Projector object
//        Instructor inst = new Instructor("Jay", 28);
//        Instructor inst2 = new Instructor("Ed", 24);

        Instructor.touch();
        Instructor.touch();


    }
}