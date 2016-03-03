/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.types;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import vendingsimulation.common.CommonIncludes;

/**
 * Tests USDCredit class
 */
public class USDCreditTest 
{
    USDCredit nickel;
    USDCredit dime;
    USDCredit quarter;
    
    @Before
    public void setUp() 
    {
        nickel = new USDCredit( CommonIncludes.NICKEL_NAME, 
            CommonIncludes.VALUE_OF_NICKEL );
        dime = new USDCredit( CommonIncludes.DIME_NAME, 
            CommonIncludes.VALUE_OF_DIME );
        quarter = new USDCredit( CommonIncludes.QUARTER_NAME, 
            CommonIncludes.VALUE_OF_QUARTER );
    }
    

    /**
     * Test assigned names are returned by get name
     */
    @Test
    public void testCorrectNameReturned() {
        System.out.println("testCorrectNameReturned");
        assertEquals(CommonIncludes.NICKEL_NAME, nickel.getName() );
        assertEquals( CommonIncludes.DIME_NAME, dime.getName() );
        assertEquals( CommonIncludes.QUARTER_NAME, quarter.getName() );
    }

    /**
     * Test assigned values are returned by get value
     */
    @Test
    public void testGetValue() {
        System.out.println("testGetValue");
        assertEquals(CommonIncludes.VALUE_OF_NICKEL, nickel.getValue() );
        assertEquals( CommonIncludes.VALUE_OF_DIME, dime.getValue() );
        assertEquals( CommonIncludes.VALUE_OF_QUARTER, quarter.getValue() );
    }

    /**
     * Test of GetMonetarySystem method, of class USDCredit.
     */
    @Test
    public void testGetMonetarySystem() {
        System.out.println("testGetValue");
        assertEquals(USDCredit.MONETARY_SYSTEM, 
            nickel.getMonetarySystem() );
        assertEquals( USDCredit.MONETARY_SYSTEM,
            dime.getMonetarySystem());
        assertEquals( USDCredit.MONETARY_SYSTEM, 
            quarter.getMonetarySystem() );
    }
    
}
