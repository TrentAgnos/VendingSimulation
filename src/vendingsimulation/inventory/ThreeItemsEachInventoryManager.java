package vendingsimulation.inventory;

import java.util.concurrent.ConcurrentSkipListMap;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.mechanicaldevices.ItemVender;
import vendingsimulation.types.PricedAndNamedItem;
import vendingsimulation.types.VendableItem;

/**
 * With a real vending machine we would likely have some hardware verification
 * of the inventory levels in each slot. Further, we might also abstract
 * the storage mechanism. However, since I don't have access to the expected
 * hardware I'm just assuming each item has its own slot and holds 3.
 * Further, I'm going to start the program with 3 of each.
 */
public class ThreeItemsEachInventoryManager implements InventoryManager
{
    /**
     * Storage representation for the inventory.
     * Concurrent map was chosen because in a real system
     * this would be an RTOS task looping on update on some register
     */
    private ConcurrentSkipListMap<String, Integer> m_inventory_storage;
    /**
     * The class responsible for physically vending the item
     */
    private ItemVender m_item_vender;
    /**
     * The storage space for each item
     */
    final static private Integer storage_space = 3;
    
    /**
     * Constructor
     */
    public ThreeItemsEachInventoryManager( ItemVender item_vender )
    {
        m_item_vender = item_vender;
        m_inventory_storage = new ConcurrentSkipListMap<String, Integer>();
        PricedAndNamedItem cola = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_COLA, CommonIncludes.COLA_NAME );
        PricedAndNamedItem candy = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_CANDY, CommonIncludes.CANDY_NAME );
        PricedAndNamedItem chips = new PricedAndNamedItem( 
            CommonIncludes.COST_OF_CHIPS, CommonIncludes.CHIPS_NAME );
        m_inventory_storage.put( cola.GetName(), storage_space );
        m_inventory_storage.put( candy.GetName(), storage_space );
        m_inventory_storage.put( chips.GetName(), storage_space );
    }
    
    /**
     * Checks if the given item is available in the inventory
     * @param item  The item to check 
     * @return True if the item is in stock
     */
    @Override
    public boolean hasInventory( VendableItem item )
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
    @Override
    public boolean vendInventory( VendableItem item )
    {
        if ( !hasInventory( item ) )
        {
            return false;
        }
        else
        {
            m_item_vender.vendItem( item );
            Integer val = m_inventory_storage.get( item.GetName() );
            m_inventory_storage.put( item.GetName() , --val );
            return true;
        }
    }
    
    
    
}
