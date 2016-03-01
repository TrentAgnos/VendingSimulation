package vendingsimulation.types;

import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("GetCostInUSD");
        ColaItem cola = new ColaItem();
        assertEquals("Cola", cola.GetName() );
    }
}
