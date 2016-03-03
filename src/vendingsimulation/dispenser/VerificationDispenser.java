package vendingsimulation.dispenser;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.inventory.InventoryManager;
import vendingsimulation.types.VendableItem;
import vendingsimulation.moneystorage.ChangeMaker;
import vendingsimulation.moneystorage.CurrentCredits;

/**
 * A dispenser which verifies the machine can produce change,
 * has the item in stock, and enough credits have been inserted
 * before dispensing the item.
 */
public class VerificationDispenser implements Dispenser
{
    /**
     * The class responsible for returning change
     */
    private ChangeMaker m_change_maker;
    /**
     * The class responsible for tracking the users
     * current credits
     */
    private CurrentCredits m_current_credits;
    /**
     * The class responsible for tracking the inventory
     * of the vending machine
     */
    private InventoryManager m_inventory_manager;
    
    /**
     * Constructor
     * @param change_maker Class which decides how to product change.
     * @param current_credits Class which tracks current user entered credits
     * @param inventory_manager Class which tracks inventory
     */
    public VerificationDispenser( ChangeMaker change_maker, 
        CurrentCredits current_credits, InventoryManager inventory_manager)
    {
        m_change_maker = change_maker;
        m_current_credits = current_credits;
        m_inventory_manager = inventory_manager;
    }
    
    /**
     * Attempts to dispense the requested item.
     * @param item The item to be dispensed
     * @return SUCCESSFUL_VEND if the item was dispensed, otherwise
     * a descriptive error stating why it could not be dispensed.
     */
    public CommonIncludes.DispensingReturns dispenseItem( VendableItem item )
    {
        if ( !m_inventory_manager.hasInventory( item ) )
        {
            return CommonIncludes.DispensingReturns.OUT_OF_STOCK;
        }
        else if ( !m_current_credits.hasEnoughCredits( 
            item.getCost() ) )
        {
            return CommonIncludes.DispensingReturns.NOT_ENOUGH_MONEY;
        }
        else if ( !m_change_maker.canMakeChange( item.getCost() ) )
        {
            return CommonIncludes.DispensingReturns.EXACT_CHANGE_NEEDED;
        }
        else
        {
            if ( m_inventory_manager.vendInventory( item ) )
            {
                if ( m_change_maker.returnChange( 
                    m_current_credits.getCurrentCredits().
                        subtract(item.getCost()) ) )
                {
                    m_current_credits.creditsSpent();
                    return CommonIncludes.DispensingReturns.SUCCESSFUL_VEND;
                }
                return CommonIncludes.DispensingReturns.EXACT_CHANGE_NEEDED;
            }
            return CommonIncludes.DispensingReturns.OUT_OF_STOCK;   
        }
    }
}
