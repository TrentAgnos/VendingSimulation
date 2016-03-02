package vendingsimulation.inventory;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentSkipListMap;

import vendingsimulation.displayui.MainDialogModel;
import vendingsimulation.types.PricedAndNamedItem;
import vendingsimulation.types.VendableItem;

/**
 * With a real vending machine we would likely have some hardware verification
 * of the inventory levels in each slot. Further, we might also abstract
 * the storage mechanism. However, since I don't have access to the expected
 * hardware I'm just assuming each item has its own slot and holds 3.
 * Further, I'm going to start the program with 3 of each.
 */
public class ThreeItemsEachInventoryManager 
{
    /**
     * The main dialog mode. Used to pop up a message on the UI
     * that an item was dispensed. 
     */
    private MainDialogModel m_model;
    /**
     * Storage representation for the inventory.
     * Concurrent map was chosen because in a real system
     * this would be an RTOS task looping on update on some register
     */
    private ConcurrentSkipListMap<String, Integer> m_inventory_storage;
    /**
     * The storage space for each item
     */
    final static private Integer storage_space = 3;
    
    /**
     * Constructor
     * @param model Model of the main dialog
     */
    public ThreeItemsEachInventoryManager( MainDialogModel model )
    {
        m_model = model;
        m_inventory_storage = new ConcurrentSkipListMap<String, Integer>();
        PricedAndNamedItem cola = new PricedAndNamedItem( 
            new BigDecimal( 1.00 ), "cola" );
        PricedAndNamedItem candy = new PricedAndNamedItem( 
            new BigDecimal( 0.65 ), "candy" );
        PricedAndNamedItem chips = new PricedAndNamedItem( 
            new BigDecimal( 0.50 ), "chips" );
        m_inventory_storage.put( cola.GetName(), storage_space );
        m_inventory_storage.put( candy.GetName(), storage_space );
        m_inventory_storage.put( chips.GetName(), storage_space );
    }
    
    /**
     * Checks if the given item is available in the inventory
     * @param item  The item to check 
     * @return True if the item is in stock
     */
    boolean hasInventory( VendableItem item )
    {
        Integer val = m_inventory_storage.get( item.GetName() );
        if ( val == null )
        {
            return false;
        }
        else
        {
            return val > 0;
        }
    }
    
    /**
     * Vends the requested item if possible
     * @param item The item to vend
     * @return True if the item was vended successfully.
     */
    boolean vendInventory( VendableItem item )
    {
        if ( !hasInventory( item ) )
        {
            return false;
        }
        else
        {
            Integer val = m_inventory_storage.get( item.GetName() );
            m_inventory_storage.put( item.GetName() , --val );
            m_model.handleItemDispensed( item );
            return true;
        }
    }
}
