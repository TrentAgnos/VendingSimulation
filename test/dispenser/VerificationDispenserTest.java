package dispenser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.dispenser.VerificationDispenser;
import vendingsimulation.inventory.stubs.StubInventoryManager;
import vendingsimulation.moneystorage.stubs.StubChangeMaker;
import vendingsimulation.moneystorage.stubs.StubCurrentCredits;
import vendingsimulation.types.PricedAndNamedItem;

/**
 * Tests the verification dispenser
 */
public class VerificationDispenserTest {
    
    private StubChangeMaker change_maker;
    private StubCurrentCredits cur_credits;
    private StubInventoryManager inventory;
    private PricedAndNamedItem item;
    private VerificationDispenser dispenser;
    
    @Before
    public void setUp()
    {
        change_maker = new StubChangeMaker();
        cur_credits = new StubCurrentCredits();
        inventory = new StubInventoryManager();
        item = new PricedAndNamedItem(BigDecimal.ONE, "Test");
        dispenser = new VerificationDispenser( change_maker, cur_credits, 
            inventory );
    }

    /**
     * Test inventory is required to dispense
     */
    @Test
    public void testCantDispenseWithoutInventory()
    {
        System.out.println("testCantDispenseWithoutInventory");
        inventory.m_has_inventory = false;
        assertEquals( CommonIncludes.DispensingReturns.OUT_OF_STOCK,
            dispenser.dispenseItem( item ) );
    }
    
    /**
     * Test available change is required to dispense
     */
    @Test
    public void testCantDispenseIfCannotMakeChange()
    {
        System.out.println("testCantDispenseIfCannotMakeChange");
        change_maker.m_can_make_change = false;
        assertEquals( CommonIncludes.DispensingReturns.EXACT_CHANGE_NEEDED, 
            dispenser.dispenseItem( item ) );
    }
   
    /**
     * Test sufficient credits required to dispense
     */
    @Test
    public void testCantDispenseIfNotEnoughCredits()
    {
        System.out.println("testCantDispenseIfNotEnoughCredits");
        cur_credits.m_has_enough_credits = false;
        assertEquals( CommonIncludes.DispensingReturns.NOT_ENOUGH_MONEY,
            dispenser.dispenseItem( item ) );
    }
    
    /**
     * Test dispenser dispenses when all criteria are met
     */
    @Test
    public void testCanDispenseWhenAllCriteriaMet()
    {
        System.out.println("testCanDispenseWhenAllCriteriaMet");
        assertEquals( dispenser.dispenseItem( item ),
            CommonIncludes.DispensingReturns.SUCCESSFUL_VEND );
    }
    
    /**
     * Test change is requested when the item is dispensed
     */
    @Test 
    public void testChangeReturnedWhenItemDispensed()
    {
        System.out.println("testChangeReturnedWhenItemDispensed");
        dispenser.dispenseItem( item );
        assertEquals( true, change_maker.m_asked_to_give_change );
    }
    
    /**
     * Test change is not requested when the item is not dispensed
     */
    @Test 
    public void testChangeNotReturnedWhenItemIsNotDispensed()
    {
        System.out.println("testChangeNotReturnedWhenItemIsNotDispensed");
        inventory.m_has_inventory = false;
        dispenser.dispenseItem( item );
        assertEquals( false, change_maker.m_asked_to_give_change );
    }
    
    /**
     * Test the item is vended when the item is dispensed
     */
    @Test
    public void testItemVendsWhenItemIsDispensed()
    {
        System.out.println("testItemVendsWhenItemIsDispensed");
        dispenser.dispenseItem( item );
        assertEquals( true, inventory.m_requested_vend );
    }
    
    /**
     * Test the item is not vended when the item is not dispensed
     */
    @Test
    public void testItemDoesNotVendWhenItemIsNotDispensed()
    {
        System.out.println("testItemDoesNotVendWhenItemIsNotDispensed");
        inventory.m_has_inventory = false;
        dispenser.dispenseItem( item );
        assertEquals( false, inventory.m_requested_vend  );
    }
    
    
    /**
     * Test credits are reset when the item is dispensed
     */
    @Test
    public void testCreditsResetWhenItemIsDispensed()
    {
        System.out.println("testCreditsResetWhenItemIsDispensed");
        dispenser.dispenseItem( item );
        assertEquals( true, cur_credits.m_credits_spent );
    }
    
    /**
     * Test credits are not reset when the item is not dispensed
     */
    @Test
    public void testCreditsDoNotResetWhenItemIsNotDispensed()
    {
        System.out.println("testCreditsDoNotResetWhenItemIsNotDispensed");
        inventory.m_has_inventory = false;
        dispenser.dispenseItem( item );
        assertEquals( false, cur_credits.m_credits_spent );
    }
    
}
