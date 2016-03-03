package vendingsimulation.displayui.stubs;

import java.math.BigDecimal;
import java.util.Vector;

import vendingsimulation.displayui.MainDialogController;
import vendingsimulation.displayui.MainDialogModel;
import vendingsimulation.types.Credit;
import vendingsimulation.types.VendableItem;

public class StubMainDialogModel implements MainDialogModel
{
    public boolean m_handled_not_enough_money = false;
    public boolean m_handled_out_of_stock = false;
    public boolean m_handled_exact_change_needed = false;
    public boolean m_handled_display_current_credits = false;
    public boolean m_handled_item_dispensed = false;
    public boolean m_handled_change_returned = false;
    public boolean m_handled_inactive_state = false;
    
    public StubMainDialogModel()
    {
        
    }
    
    public void itemRequested( VendableItem item )
    {   
    }
    
    public void creditInserted( BigDecimal voltage_from_credit_reader )
    { 
    }
    
    public void ejectUnspentMoney()
    { 
    }
    
    public void handleNotEnoughMoney( VendableItem item )
    { 
        m_handled_not_enough_money = true;
    }
    
    public void handleOutOfStock( VendableItem item )
    { 
    }
    
    public void handleExactChangeNeeded()
    {
        
    }
    
    public void handleDisplayCurrentCredits( BigDecimal cur_credits )
    {
        
    }
    
    public void handleItemDispensed( VendableItem item )
    {
        m_handled_item_dispensed = true;
    }
    
    public void handleChangeReturned( Vector<Credit> coins )
    {
        
    }
    
    public void handleInactiveState()
    {
        
    }
}
