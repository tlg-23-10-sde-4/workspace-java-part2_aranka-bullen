package com.javatunes.personnel;

import org.junit.*;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("beforeTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("beforeTest");
        //fixture -> business object under test
        emp = new SalariedEmployee("Logan", Date.valueOf("2020-02-06"), 1500.0);
        emp2 = new SalariedEmployee("Logan", Date.valueOf("2020-02-06"), 1500.0);
    }
    @Test
    public void hashCode_shouldReturnFalse_whenDifferentHashCode() {
        assertEquals(emp.hashCode(), emp2.hashCode());  //does and equals() check
        assertTrue(emp.equals(emp2));  //alternative assertion
    @Test
    public void hashCode_shouldReturnTrue_whenAllPropertiesSame() {
        assertEquals(emp.hashCode(), emp2.hashCode());  //does and equals() check
        assertTrue(emp.equals(emp2));  //alternative assertion
    }

    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame() {
        assertEquals(emp, emp2);  //does and equals() check
        assertTrue(emp.equals(emp2));  //alternative assertion
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);
        assertNotEquals(emp, emp2);
        assertFalse(emp.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2023-11-02"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("DIF");
        assertNotEquals(emp, emp2);
        assertFalse(emp.equals(emp2));
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.00, emp.payTaxes(), 0.001);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("afterTest");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("afterTestRun");
    }
}