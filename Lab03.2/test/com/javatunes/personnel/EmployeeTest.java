package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    //
    private Employee emp1;
    private Employee emp2;


    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Mary Lou", Date.valueOf("1999-09-09"));
        emp2 = new SalariedEmployee("Mary Lou", Date.valueOf("1999-09-09"));
    }

    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame() {
        assertEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2023-01-01"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("DIFFERENT");
        assertNotEquals(emp1, emp2);
    }
}