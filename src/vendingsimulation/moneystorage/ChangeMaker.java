package vendingsimulation.moneystorage;

import java.math.BigDecimal;

import vendingsimulation.types.Credit;

/**
 * Change makers collect the correct change and return it to the customer.
 */
public interface ChangeMaker 
{
    /**
     * Check if this change maker is capable of returning change 
     * equal to the amount given
     * @param change_needed The value of change required.
     * @return True if the vending machine has enough change
     * to return to the customer
     */
    boolean canMakeChange( BigDecimal change_needed );
    /**
     * Returns the specified change to the customer
     * @param change_needed The value of the change required
     * @return True if the change was returned successfully.
     */
    boolean returnChange( BigDecimal change_needed );
    
    /**
     * Informs the ChangeMaker that a credit has been inserted but
     * not yet spent
     * @param voltage The voltage found on the pin when the 
     * coin passed through the slot
     * @return True if the ChangeMaker still has room for more change.
     */
    boolean creditInserted( BigDecimal voltage );
    
    /**
     * Informs the ChangeMaker that credits inserted can now be
     * considered owned by the machine
     */
    void creditsSpent();
}
