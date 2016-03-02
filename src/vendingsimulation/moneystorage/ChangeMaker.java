package vendingsimulation.moneystorage;

import java.math.BigDecimal;

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
}
