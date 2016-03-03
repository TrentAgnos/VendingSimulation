package vendingsimulation.mechanicaldevices;

import vendingsimulation.types.VendableItem;

/**
 * ItemVendors are responsible for control of the physical devices
 * required to vend an item to the customer
 */
public interface ItemVender 
{
    /**
     * Places the item in the retrieval bin.
     * @param item The item to vend.
     */
    void vendItem( VendableItem item );
}
