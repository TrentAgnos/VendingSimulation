/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.displayui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Vector;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.dispenser.Dispenser;
import vendingsimulation.mechanicaldevices.CreditReader;
import vendingsimulation.moneystorage.CurrentCredits;
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
    /**
     * Controller for main dialog
     */
    MainDialogController m_controller;
    /**
     * Class responsible for tracking customer inserted credits.
     */
    CurrentCredits m_cur_credits;
    /***
     * This is another class that shouldn't be here. I need it because
     * while a real machine would be looping and reading from a register
     * I only have a UI. So I place it here to send the voltage from the UI.
     */
    CreditReader m_reader;
    
    /**
     * Constructor
     * @param dispenser Dispenser responsible for handling product
     * dispensation.
     * @param controller The dialog controller this model uses
     * @param cur_credits The class responsible for tracking the customer
     * inserted credits
     */
    public MainDialogDispenserModel( Dispenser dispenser, 
        MainDialogController controller, CurrentCredits cur_credits,
        CreditReader reader )
    {
        m_dispenser = dispenser;
        m_controller = controller;
        m_cur_credits = cur_credits;
        m_reader = reader;
    }
    
    /**
     * Handle when an item was requested in the UI
     * @param item The item requested
     */
    public void itemRequested( VendableItem item )
    {
        handleDispenseReturn( m_dispenser.dispenseItem( item ), item );
    }
    
    /**
     * Handle when a credit is inserted.
     * @param voltage_from_credit_reader The voltage received from the
     * credit reader, which defines the type of credit inserted
     */
    public void creditInserted( BigDecimal voltage_from_credit_reader )
    {
        m_reader.newVoltage( voltage_from_credit_reader );
        m_controller.setDisplayText( 
            m_cur_credits.getCurrentCredits().setScale(2, RoundingMode.HALF_UP).
                toString() );
        
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
        dispense_return, VendableItem item )
    {
        switch( dispense_return )
        {
            case NOT_ENOUGH_MONEY:
            {
                m_controller.setDisplayText( String.format("Price %s", 
                    item.getCost().setScale( 2, RoundingMode.HALF_UP ) ) );
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
                m_controller.setDisplayText("Exact Change Needed");
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
