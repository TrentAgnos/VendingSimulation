/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.inventory;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.displayui.stubs.StubMainDialogModel;
import vendingsimulation.types.PricedAndNamedItem;

/**
 * Tests the three item each inventory manager
 */
public class ThreeItemsEachInventoryManagerTest {
    
    PricedAndNamedItem cola;
    PricedAndNamedItem candy;
    PricedAndNamedItem chips;
    StubMainDialogModel dialog;
    ThreeItemsEachInventoryManager manager;
    
    @Before
    public void setUp() 
    {
        dialog = new StubMainDialogModel();
        manager = new ThreeItemsEachInventoryManager( dialog );
        cola = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_COLA, CommonIncludes.COLA_NAME );
        candy = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_CANDY, CommonIncludes.CANDY_NAME );
        chips = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_CHIPS, CommonIncludes.CHIPS_NAME );
    }

    /**
     * Test all three items defined in the features are present
     */
    @Test
    public void testHasAllThreeItems()
    {
        System.out.println("testHasAllThreeItems");
        assertTrue( manager.hasInventory( cola ) );
        assertTrue( manager.hasInventory( candy ) );
        assertTrue( manager.hasInventory( chips ) );
    }
    
    /**
     * Test the manager returns false to unknown types.
     */
    @Test
    public void testOnlyHasColaChipsAndCandy()
    {
        System.out.println("testOnlyHasColaChipsAndCandy");
        PricedAndNamedItem water = new PricedAndNamedItem( 
            new BigDecimal(1.00), "water" );
        assertFalse( manager.hasInventory( water ) );
    }
    
    /**
     * Test the manager stores 3 and only 3 of each item
     */
    @Test
    public void testHasThreeOfEach()
    {
        System.out.println("testHasThreeOfEach");
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        assertFalse( manager.vendInventory( cola ) );
        assertFalse( manager.hasInventory( cola ) );
        
        assertTrue( manager.vendInventory( candy ) );
        assertTrue( manager.vendInventory( candy ) );
        assertTrue( manager.vendInventory( candy ) );
        assertFalse( manager.vendInventory( candy ) );
        assertFalse( manager.hasInventory( candy ) );
        
        assertTrue( manager.vendInventory( chips ) );
        assertTrue( manager.vendInventory( chips ) );
        assertTrue( manager.vendInventory( chips ) );
        assertFalse( manager.vendInventory( chips ) );
        assertFalse( manager.hasInventory( chips ) );
    }
    
    /**
     * Test the UI is updated when an item is dispensed
     */
    @Test
    public void testSendsHandleItemDispensedToUI()
    {
        System.out.println("testSendsHandleItemDispensedToUI");
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( dialog.m_handled_item_dispensed );
    }
    
    /**
     * Test the UI is not updated when an item is not dispensed
     * because it is out of stock
     */
    @Test
    public void testDoesNotSendHandleItemDispensedToUIWhenOutOfInventory()
    {
        System.out.
            println("testDoesNotSendHandleItemDispensedToUIWhenOutOfInventory");
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        
        // Reset the state before the last vend
        dialog.m_handled_item_dispensed = false;
        
        assertFalse( manager.vendInventory( cola ) );
        assertFalse( manager.hasInventory( cola ) );
        assertFalse( dialog.m_handled_item_dispensed );
    }
    
}
