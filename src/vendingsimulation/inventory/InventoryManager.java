package vendingsimulation.inventory;

import vendingsimulation.types.VendableItem;

/**
 * Inventory managers track the inventory of the vending machine.
 * NOTE: The inventory manager assumes there is some hardware verification
 * going on inside implementations. Thus, it does not allow items to be added.
 */
public interface InventoryManager 
{
    /**
     * Checks if the given item is available in the inventory
     * @param item  The item to check 
     * @return 
     */
    boolean hasInventory( VendableItem item );
    /**
     * Vends the requested item if possible
     * @param item The item to vend
     * @return True if the item was vended successfully.
     */
    boolean vendInventory( VendableItem item );
}
