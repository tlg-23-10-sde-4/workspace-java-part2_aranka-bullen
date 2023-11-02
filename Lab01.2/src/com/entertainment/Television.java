package com.entertainment;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

// Natural order is defined by sort key 'brand' (String)
public class Television implements Comparable<Television> {
    //fields
    private String brand;
    private int volume;

    // Television HAS-A Tuner (for all things related to channel)
    private final Tuner tuner = new Tuner();

    //constructors
    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }


    //methods
    public int getCurrentChannel() {
        return tuner.getChannel();  //delegates to the tuner
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);    //delegates to the tuner
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



    /*
    @Override
    public boolean equals(Object obj) {
        //
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;

        return this.getVolume() == that.getVolume() &&
            Objects.equals(this.getBrand(), that.getBrand());
    }

*/


    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        /*
         *This is a poorly written has function, because it easily yields "hash collisions."
         * A hash collision is when "different" objects have the same hash code (just by coincident).
         * Given our poor initial hash function below,
         *"Sony" 50  and  "LG" 52  both have hash codes of 54, as does  "Samsung" 47.
         * These are "different" objects per the equals() method, but have the same hash code.
         */
        //return getBrand().length() + getVolume();

        //Instead, we rely on Objects.has() to give us a "scientifically correct" hash function.
        return Objects.hash(getBrand(), getVolume());
    }


    @Override
    public boolean equals(Object obj) {
        System.out.println("equals called");
        boolean result = false;

        //proceed  only if 'obj' is really referencing a Television object.
        // use getClass for exact match and instanceof for IS-A relationship match
        //== is valid when comparing Class objects and Enums, anywhere else .equals() is the better option.

        // 'this' (me) and 'obj' refer to the same physical object in memory!
        if (this == obj) {
            result = true;              // and we're done, return result (true)
        }


        // 'obj' is not-null and my Class object is the same as its Class object, proceed
        // otherwise, skip this whole thing and return result (false)
        //safely downcast 'obj' to more specific reference type Television
        // do the checks: business equality is defined by brand, volume being the same
        else if (obj != null && (this.getClass() == obj.getClass())) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&        // null-safe
                    this.getVolume() == other.getVolume();       // primitives can't be null
        }
        return result;
    }

    /*
     * primary sort key 'brand (String).
     * Secondary sort key 'volume'' (int).
     */
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {  //tied on brand, i.ee, they have the same brand
            result = Integer.compare(this.getVolume(), other.getVolume());
        }

            return result;

    }

        @Override
        public String toString() {
            return String.format("%s [brand=%s, volume=%s, currentChannel=%s]\n",
                    getClass().getSimpleName(),getBrand(), getVolume(), getCurrentChannel());
        }
    }
