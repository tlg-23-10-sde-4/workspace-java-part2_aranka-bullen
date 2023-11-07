/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 *  VAT is 17% of taxable amount.
 *  Luxury tax is an additional 25% on amount over $100.
 *  
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator{
    private static final double vatTax =  0.17;
    private static final double luxuryTax = 0.25;
    private static final double taxThreshold =100.0;

    @Override
    public double taxAmount(double taxable) {
        double result = vatTax * taxable;
        if (taxable > taxThreshold) {
            result += (taxable-taxThreshold) *luxuryTax;
        }
        return result;
    }
}