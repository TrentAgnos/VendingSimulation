/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.displayui;

import java.math.BigDecimal;
import java.util.Vector;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.dispenser.Dispenser;
import vendingsimulation.types.Credit;
import vendingsimulation.types.VendableItem;

/**
 * Model for the main dialog with uses a dispenser to 
 * decide the state of the UI.
 */
public class MainDialogDispenserModel implements MainDialogModel
{
    /**
     * Dispenser used for dispensing product based on UI actions.
     */
    Dispenser m_dispenser;
    MainDialogController m_controller;
    
    /**
     * Constructor
     * @param dispenser Dispenser responsible for handling product
     * dispensation.
     * @param controller The dialog controller this model uses
     */
    public MainDialogDispenserModel( Dispenser dispenser, 
        MainDialogController controller )
    {
        m_dispenser = dispenser;
        m_controller = controller;
    }
    
    /**
     * Handle when an item was requested in the UI
     * @param item The item requested
     */
    public void itemRequested( VendableItem item )
    {
        m_dispenser.dispenseItem( item );
    }
    
    /**
     * Handle when a credit is inserted.
     * @param voltage_from_credit_reader The voltage received from the
     * credit reader, which defines the type of credit inserted
     */
    public void creditInserted( double voltage_from_credit_reader )
    {
        
    }
    
    /**
     * Handle when the customer requests inserted credits be returned.
     */
    public void ejectUnspentMoney()
    {
        
    }
    
    /**
     * Handle when an item was requested but the customer has not
     * inserted enough credits.
     * @param item The item that was requested.
     */
    public void handleNotEnoughMoney( VendableItem item )
    {
        
    }
    
    /**
     * Handle when an item was requested but the item is out of stock
     * @param item The item that was requested.
     */
    public void handleOutOfStock( VendableItem item )
    {
        
    }
    
    /**
     * Handle when an item was requested but the user did not insert
     * exactly the cost of the item while the machine required
     * exact change.
     */
    public void handleExactChangeNeeded()
    {
        
    }
    
    /**
     * Handle when a credit was inserted by displaying
     * the current credits
     * @param cur_credits The current credits the user has inserted
     */
    public void handleDisplayCurrentCredits( BigDecimal cur_credits )
    {
        
    }
    
    /**
     * Handle when an item was dispensed successfully
     * @param item The item dispensed.
     */
    public void handleItemDispensed( VendableItem item )
    {
        
    }
    
    /**
     * Handle when change is returned.
     * @param credits The credits returned.
     */
    public void handleChangeReturned( Vector<Credit> coins )
    {
        
    }
    
    /**
     * Handle when the vending machine is in the default state.
     * For example, the machine just finished vending and is waiting
     * for customer input
     */
    public void handleInactiveState()
    {
        
    }
    
    private void handleDispenseReturn( CommonIncludes.DispensingReturns 
        dispense_return )
    {
        switch( dispense_return )
        {
            case NOT_ENOUGH_MONEY:
            {
                /// TODO handle not enough money
                break;
            }
            case OUT_OF_STOCK:
            {
                /// TODO translations
                m_controller.setDisplayText("Out of stock");
                break;
            }
            case EXACT_CHANGE_NEEDED:
            {
                /// TODO handle not enough money
                break;
            }
            case SUCCESSFUL_VEND:
            {
                /// TODO translations
                m_controller.setDisplayText("Thank you.");
                break;
            }
        }
    }
}
