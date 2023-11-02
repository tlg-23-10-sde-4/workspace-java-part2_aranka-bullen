package org.veggies;

class Radish implements Comparable<Radish> {

    private double size;
    private String color;
    private double tailLength;
    private int guysOnTop;


    public Radish( String color, double size, double tailLength, int guysOnTop) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

    @Override
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    @Override
    public String toString() {
        return String.format("%s: color=%s, siz=%s, tailLength=%s, guysOnTop=%s.\n",
                getClass().getSimpleName(), getSize(),getColor(),getTailLength(),getGuysOnTop());
    }
}