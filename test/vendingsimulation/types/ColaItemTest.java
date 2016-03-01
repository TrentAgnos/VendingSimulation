package vendingsimulation.types;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

/**
 * Tests ColaItem follows expectations
 * @author trent_000
 */
public class ColaItemTest 
{
    public ColaItemTest() 
    {
    }

    /**
     * Test the ColaItem returns its name as cola
     */
    @Test
    public void testGetNameReturnsCola()
    {
        System.out.println("testGetNameReturnsCola");
        ColaItem cola = new ColaItem();
        assertEquals("Cola", cola.GetName() );
    }
    
    /**
     * Tests that the cost of a cola is US $1.00
     */
    @Test
    public void testGetCostInUSDReturnsOneDollar()
    {
        System.out.println("testGetCostInUSDReturnsOneDollar");
        ColaItem cola = new ColaItem();
        assertEquals( new BigDecimal(1.00), cola.GetCostInUSD());
    }
}
