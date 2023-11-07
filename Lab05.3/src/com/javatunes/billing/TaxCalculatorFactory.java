package com.javatunes.billing;

public class TaxCalculatorFactory{

    //this is private so it cannot be instantiated.
    private TaxCalculatorFactory(){
    }
    /*
     * Considering implementing a cache of TaXCalculator objects.
     *
     * If I have not previously created the object (e.g. USATax), that is it is not in the
     * cache. Then I'll create it with new and add to my cache, and then return it.
     *
     * Hint: you could use a simple Map<Location, TaxCalculator> for the cache.
     * It would  be 3-ROW Map, each row has Location | TaxCalculator
     */


    public static TaxCalculator getTaxCalculator(Location location) {

        TaxCalculator calc = null;

        switch (location) {
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
                break;
            case ONLINE:
                calc = new OnlineTax();
                break;
        }
        return calc;
    }
}