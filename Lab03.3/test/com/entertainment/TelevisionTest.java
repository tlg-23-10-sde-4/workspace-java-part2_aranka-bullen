package com.entertainment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest implements Comparable<Television> {
    private Television tv;
    private Television tv1;

    @Before
    public void setUp()  {
        tv = new Television("Sony");
        tv1 = new Television("Sony");
    }
    @Test(expected = IllegalArgumentException.class)
    public void compareTo_shouldReturnTrue_whenSame_Not() throws IllegalArgumentException{
        tv.setBrand("LG");
        assertEquals(tv, tv1.compareTo(tv1));
    }


    @Test
    public void compareTo_shouldReturnTrue_whenSame_() {
        assertEquals(0, tv1.compareTo(tv1));
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(0);

    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);;
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
       try {
           tv.setVolume(101);
           fail("Should have thrown Illegal Argument Expection");
       }
       catch(IllegalArgumentException e) {
           String expected = "Invalid Volume: 101. Valid volume are [0-100].";
           assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);
    }
}