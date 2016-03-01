package vendingsimulation.types;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

/**
 * Tests ColaItem follows expectations
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
        ColaItem cola = new ColaItem( new BigDecimal(1.00));
        assertEquals("Cola", cola.GetName() );
    }
    
    /**
     * Tests that the cost of a cola is US $1.00
     */
    @Test
    public void testGetCostInUSDReturnsOneDollar()
    {
        System.out.println("testGetCostInUSDReturnsOneDollar");
        BigDecimal test_val = new BigDecimal(1.00);
        ColaItem cola = new ColaItem(test_val);
        assertEquals( test_val, cola.GetCostInUSD());
    }
    
    /**
     * Tests that the cost of a cola can be changed
     */
    @Test
    public void testGetCostInUSDReturnsWhatIsSetInConstructor()
    {
        System.out.println("testGetCostInUSDReturnsWhatIsSetInConstructor");
        BigDecimal test_val = new BigDecimal(65.00);
        ColaItem cola = new ColaItem(test_val);
        assertEquals( test_val, cola.GetCostInUSD());
    }
}
