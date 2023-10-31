package com.entertainment;

import java.util.Objects;
import  java.util.HashSet;
import java.util.Set;

public class Television {
    //fields
    private String brand;
    private int volume;
    private final Tuner tuner = new Tuner();

    //constructors
    public Television(){
    }

    public  Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //Accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }


    //methods
    public int getCurrentChannel() {
     return tuner.getChannel();
    }

    public void  changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    @Override
    public int hashCode(){
        /*
         *This is a poorly written has function, because it easily yields "hash collisions."
         * A hash collisionis when "different" objects have the same hash code (just by coincident).
         */
         //return getBrand().length() + getVolume();

         //Instead, we rely on Objects.has() to give us a "scientifically correct" hash function.
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        //proceed  only if 'obj' is really referencing a Television object.
        if(obj instanceof Television) {

            //safely downcast 'obj' to more specific reference type Television
            Television other = (Television) obj;

            // do the checks: business equality is defined by brand, volume being the same
            result= Objects.equals(this.getBrand(), other.getBrand()) &&  // this a null safe method (Object.equals())
                    this.getVolume()==other.getVolume();  // primitives cannot be null
        }
        return result;
    }

    //toString
    public String toString() {
        return String.format("%s: Brand=%s, Volume=%s, CurrentChannel=%s.\n", getClass().getSimpleName(),
                getBrand(), getVolume(), getCurrentChannel());
    }
}