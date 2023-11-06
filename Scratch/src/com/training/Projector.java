package com.training;

class Projector {
    public Projector() {
        System.out.println("projector ctor called");
    }

    // this executes when the Classloader loads Projector.class into memory
    static{
        System.out.println("Projector.class loaded into memory ");
    }

}