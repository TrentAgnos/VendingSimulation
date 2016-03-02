package vendingsimulation.moneystorage;

import java.math.BigDecimal;

public interface CurrentCredits 
{
    /**
     * Check if the customer has inserted enough credits
     * @param cost The cost of the item the customer is trying to buy
     * @return True if there are more credits than cost
     */
    boolean hasEnoughCredits( BigDecimal cost );
    /**
     * Zero out the credits stored in the system because the user
     * has spent them and any remaining value was returned with change.
     */
    void creditsSpent();
    /**
     * Get the current value of credits the customer has inserted into the 
     * machine.
     * @return The value of the credits the customer inserted
     */
    BigDecimal getCurrentCredits();
}
