/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.types;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests ColaItem follows expectations
 */
public class CandyItemTest 
{
    /**
     * Constructor
     */
    public CandyItemTest() 
    {
    }

    /**
     * Test the CandyItem returns its name as candy
     */
    @Test
    public void testGetNameReturnsCandy()
    {
        System.out.println("testGetNameReturnsCandy");
        CandyItem candy = new CandyItem();
        assertEquals("Candy", candy.GetName() );
    }
    
    /**
     * Tests that the cost of candy is US $0.65
     */
    @Test
    public void testGetCostInUSDReturns65Cents()
    {
        System.out.println("testGetCostInUSDReturns65Cents");
        CandyItem candy = new CandyItem();
        assertEquals( new BigDecimal(0.65), candy.GetCostInUSD());
    }
}
