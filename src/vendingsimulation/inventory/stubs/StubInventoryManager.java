package vendingsimulation.inventory.stubs;

import vendingsimulation.inventory.InventoryManager;
import vendingsimulation.types.VendableItem;

public class StubInventoryManager implements InventoryManager
{
    public boolean m_has_inventory = true;
    public boolean m_requested_vend = false;
    
    public StubInventoryManager()
    {
    }
    
    public boolean hasInventory( VendableItem item )
    {
        return m_has_inventory;
    }
    
    public boolean vendInventory( VendableItem item )
    {
        m_requested_vend = true;
        return true;
    }
}
