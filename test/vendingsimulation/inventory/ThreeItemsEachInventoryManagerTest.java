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
import vendingsimulation.mechanicaldevices.stubs.StubItemVender;
import vendingsimulation.types.PricedAndNamedItem;

/**
 * Tests the three item each inventory manager
 */
public class ThreeItemsEachInventoryManagerTest {
    
    PricedAndNamedItem cola;
    PricedAndNamedItem candy;
    PricedAndNamedItem chips;
    ThreeItemsEachInventoryManager manager;
    StubItemVender vender;
    
    @Before
    public void setUp() 
    {
        vender = new StubItemVender();
        manager = new ThreeItemsEachInventoryManager( vender );
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
     * Test the inventory manager vends items when in stock
     */
    @Test
    public void testDoesVend()
    {
        System.out.println("testDoesVend");
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( vender.m_vended );
    }
    
    /**
     * Test the inventory manager does not vend items when out of stock
     */
    @Test
    public void testDoesNotVendWhenOutOfInventory()
    {
        System.out.println("testDoesVend");
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        assertTrue( manager.vendInventory( cola ) );
        
        // Reset vender stub state
        vender.m_vended = false;
        
        assertFalse( manager.vendInventory( cola ) );
        assertFalse( vender.m_vended );
    }
}
