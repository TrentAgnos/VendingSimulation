package vendingsimulation.mechanicaldevices.stubs;

import vendingsimulation.mechanicaldevices.ItemVender;
import vendingsimulation.types.VendableItem;

public class StubItemVender implements ItemVender
{
    public boolean m_vended = false;
    
    public void vendItem( VendableItem item )
    {
        m_vended = true;
    }
}
