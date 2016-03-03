/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.types;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Priced and named item class
 */
public class PricedAndNamedItemTest {
    
    public PricedAndNamedItemTest() 
    {
    }

    /**
     * Test the PricedAndNamedItem returns the name "Random"
     */
    @Test
    public void testGetNameReturnsNameRandom()
    {
        System.out.println("testGetNameReturnsNameRandom");
        String name = "Random";
        BigDecimal test_val = new BigDecimal(1.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(name, item.getName() );
    }
    
    /**
     * Test the PricedAndNamedItem handles a blank name
     */
    @Test
    public void testGetNameHandlesBlankName()
    {
        System.out.println("testGetNameHandlesBlankName");
        String name = "";
        BigDecimal test_val = new BigDecimal(1.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(name, item.getName() );
    }
    
    /**
     * Test the PricedAndNamedItem handles a long name
     */
    @Test
    public void testGetNameHandlesLongName()
    {
        System.out.println("testGetNameHandlesLongName");
        String name = "dddddddddsdfsdfasdfasdfsadfasdfasdfasdfasdfasfdasdfasdf";
        BigDecimal test_val = new BigDecimal(1.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(name, item.getName() );
    }
    
    /**
     * Tests the PricedAndNamedItem handles special characters
     */
    @Test
    public void testGetNameHandlesSpecialCharacter()
    {
        System.out.println("testGetNameHandlesSpecialCharacter");
        String name = "!@##$#@$%#$^$%^&*(&)|{}[]:'<>'";
        BigDecimal test_val = new BigDecimal(1.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(name, item.getName() );
    }
    
    /**
     * Tests the PricedAndNamedItem handles 0 as its price
     */
    @Test
    public void testGetCostHandles0()
    {
        System.out.println("testGetCostHandles0");
        String name = "Test";
        BigDecimal test_val = new BigDecimal(0.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(test_val, item.getCost() );
    }
    
    /**
     * Tests the PriceAndNameditem does not allow negative numbers
     */
    @Test
    public void testGetCostRefusesNegatives()
    {
        System.out.println("testGetCostRefusesNegatives");
        String name = "Test";
        BigDecimal test_val = new BigDecimal(-1.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(new BigDecimal(0.00), item.getCost() );
    }
    
    /**
     * Tests the PriceAndNameditem handles positive numbers
     */
    @Test
    public void testGetCostAllowsPositives()
    {
        System.out.println("testGetCostAllowsPositives");
        String name = "Test";
        BigDecimal test_val = new BigDecimal(25.00);
        PricedAndNamedItem item = new PricedAndNamedItem( test_val, name );
        assertEquals(test_val, item.getCost() );
    }
    
}
