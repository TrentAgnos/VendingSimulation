package vendingsimulation.displayui;

import java.math.BigDecimal;
import java.util.Vector;


import vendingsimulation.types.VendableItem;
import vendingsimulation.types.Credit;

public interface MainDialogModel 
{
    /**
     * Handle when an item was requested in the UI
     * @param item The item requested
     */
    void itemRequested( VendableItem item );
    
    /**
     * Handle when a credit is inserted.
     * @param voltage_from_credit_reader The voltage received from the
     * credit reader, which defines the type of credit inserted
     */
    void creditInserted( BigDecimal voltage_from_credit_reader );
    
    /**
     * Handle when the customer requests inserted credits be returned.
     */
    void ejectUnspentMoney();
    
    /**
     * Handle when an item was requested but the customer has not
     * inserted enough credits.
     * @param item The item that was requested.
     */
    void handleNotEnoughMoney( VendableItem item );
    
    /**
     * Handle when an item was requested but the item is out of stock
     * @param item The item that was requested.
     */
    void handleOutOfStock( VendableItem item );
    
    /**
     * Handle when an item was requested but the user did not insert
     * exactly the cost of the item while the machine required
     * exact change.
     */
    void handleExactChangeNeeded();
    
    /**
     * Handle when a credit was inserted by displaying
     * the current credits
     * @param cur_credits The current credits the user has inserted
     */
    void handleDisplayCurrentCredits( BigDecimal cur_credits );
    
    /**
     * Handle when an item was dispensed successfully
     * @param item The item dispensed.
     */
    void handleItemDispensed( VendableItem item );
    
    /**
     * Handle when change is returned.
     * @param credits The credits returned.
     */
    void handleChangeReturned( Vector<Credit> credits );
    
    /**
     * Handle when the vending machine is in the default state.
     * For example, the machine just finished vending and is waiting
     * for customer input
     */
    void handleInactiveState();
}
