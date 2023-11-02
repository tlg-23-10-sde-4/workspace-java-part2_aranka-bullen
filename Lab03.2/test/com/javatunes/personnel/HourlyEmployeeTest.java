package com.javatunes.personnel;

import org.junit.*;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    //fixture -> business object under test
    private HourlyEmployee emp;

    @Before
    public void setUp()  {
        System.out.println("beforeTest");
        emp = new HourlyEmployee("Amilia", Date.valueOf("2020-02-06"),
                30.0, 40.0);
    }

    @Test
    public void testPay() {                         //expected value: hours * rate
        assertEquals(1200.0, emp.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {                    // expected value: hours *rate *.25
        assertEquals(300.0, emp.payTaxes(), 0.001);
    }

}