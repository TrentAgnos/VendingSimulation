package vendingsimulation.moneystorage;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.types.Credit;
import vendingsimulation.types.USDCredit;

/**
 * Tests the USDCurrentCredits class
 */
public class USDCurrentCreditsTest
{
    
    USDCurrentCredits cur_credits;
    USDCredit quarter;
    
    @Before
    public void setUp() 
    {
        cur_credits = new USDCurrentCredits();
        quarter = new USDCredit( CommonIncludes.QUARTER_NAME, 
            CommonIncludes.VALUE_OF_QUARTER );
    }

    /**
     * Test USDCurrentCredits starts off with zero credits
     */
    @Test
    public void testDefaultsToZero() {
        System.out.println("testDefaultsToZero");
        assertEquals( cur_credits.getCurrentCredits(), BigDecimal.ZERO );

    }

    /**
     * Tests that having no credits is enough when the item is free.
     */
    @Test
    public void testNoCreditsIsEnoughForNoCost()
    {
        System.out.println("testNoCreditsIsEnoughForNoCost");
        assertTrue( cur_credits.hasEnoughCredits( BigDecimal.ZERO ) );
    }
    
    /**
     * Tests that zero credits is not enough to buy a non free item
     */
    @Test
    public void testNoCreditsIsNotEnoughIfItemIsNotFree()
    {
        System.out.println("testNoCreditsIsEnoughForNoCost");
        assertFalse( cur_credits.hasEnoughCredits( BigDecimal.ONE ) );
    }
    
    /**
     * Tests that a negative cost is considered free
     */
    @Test
    public void testNegativeIsFree()
    {
        System.out.println("testNegativeIsFree");
        assertTrue( cur_credits.hasEnoughCredits( new BigDecimal( -1 ) ) );
    }
    
    /**
     * Tests that when the current credits are 0 and we set them as spent
     * it remains zero.
     */
    @Test
    public void testCreditsSpentGoesToZeroFromZero()
    {
        System.out.println("testCreditsSpentGoesToZeroFromZero");
        cur_credits.creditsSpent();
        assertEquals( cur_credits.getCurrentCredits(), BigDecimal.ZERO );
    }
    
    /**
     * Test that adding a quarter and setting credits spent returns to zero
     */
    @Test
    public void testCreditsSpentGoesToZeroAfterAddingAQuarter()
    {
        System.out.println("testCreditsSpentGoesToZeroAfterAddingAQuarter");
        cur_credits.newCreditInserted( quarter );
        assertEquals( cur_credits.getCurrentCredits(), quarter.getValue() );
        cur_credits.creditsSpent();
        assertEquals( cur_credits.getCurrentCredits(), BigDecimal.ZERO );
    }
    
    /**
     * Test that has enough is correct with a quarter
     */
    @Test
    public void testHasEnoughCorrectWithAQuarter()
    {
        System.out.println("testHasEnoughCorrectWithAQuarter");
        cur_credits.newCreditInserted( quarter );
        assertFalse( cur_credits.hasEnoughCredits( new BigDecimal( 1.00 ) ) );
        assertTrue( cur_credits.hasEnoughCredits( new BigDecimal( 0.05 ) ) );
    }
    
    /**
     * Tests that subsequent quarters add correctly
     */
    @Test
    public void testNewCreditInsertedAddsCorrectly()
    {
        System.out.println("testNewCreditInsertedAddsCorrectly");
        BigDecimal summed_val = quarter.getValue();
        cur_credits.newCreditInserted( quarter );
        assertEquals( cur_credits.getCurrentCredits(), summed_val );
        summed_val = summed_val.add( quarter.getValue() );
        cur_credits.newCreditInserted( quarter );
        assertEquals( cur_credits.getCurrentCredits(), summed_val );
        summed_val = summed_val.add( quarter.getValue() );
        cur_credits.newCreditInserted( quarter );
        assertEquals( cur_credits.getCurrentCredits(), summed_val );
    }
    
}
