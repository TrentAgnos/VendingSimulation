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
        nickel = new USDCredit( CommonIncludes.NICKLE_NAME, 
            CommonIncludes.VALUE_OF_NICKLE );
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
        assertEquals( CommonIncludes.NICKLE_NAME, nickel.GetName() );
        assertEquals( CommonIncludes.DIME_NAME, dime.GetName() );
        assertEquals( CommonIncludes.QUARTER_NAME, quarter.GetName() );
    }

    /**
     * Test assigned values are returned by get value
     */
    @Test
    public void testGetValue() {
        System.out.println("testGetValue");
        assertEquals( CommonIncludes.VALUE_OF_NICKLE, nickel.GetValue() );
        assertEquals( CommonIncludes.VALUE_OF_DIME, dime.GetValue() );
        assertEquals( CommonIncludes.VALUE_OF_QUARTER, quarter.GetValue() );
    }

    /**
     * Test of GetMonetarySystem method, of class USDCredit.
     */
    @Test
    public void testGetMonetarySystem() {
        System.out.println("testGetValue");
        assertEquals(USDCredit.MONETARY_SYSTEM, 
            nickel.GetMonetarySystem() );
        assertEquals( USDCredit.MONETARY_SYSTEM,
            dime.GetMonetarySystem());
        assertEquals( USDCredit.MONETARY_SYSTEM, 
            quarter.GetMonetarySystem() );
    }
    
}
