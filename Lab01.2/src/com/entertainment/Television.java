package com.entertainment;

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

    //toString
    public String toString() {
        return String.format("%s: Brand=%s, Volume=%s, CurrentChannel=%s.\n", getClass().getSimpleName(),
                getBrand(), getVolume(), getCurrentChannel());
    }
}