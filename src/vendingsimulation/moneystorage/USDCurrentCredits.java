package vendingsimulation.moneystorage;

import java.math.BigDecimal;
import vendingsimulation.types.Credit;
import vendingsimulation.types.USDCredit;

/**
 * Tracks current credits inserted but only in USD
 */
public class USDCurrentCredits implements CurrentCredits
{
    /**
     * The value of the user inserted credits in USD.
     */
    private BigDecimal m_current_user_credits = BigDecimal.ZERO;
    
    /**
     * Constructor
     */
    public USDCurrentCredits()
    {
    }
    
    /**
     * Check if the customer has inserted enough credits
     * @param cost The cost of the item the customer is trying to buy
     * @return True if there are more credits than cost
     */
    public boolean hasEnoughCredits( BigDecimal cost )
    {
        return ( m_current_user_credits.compareTo( cost ) >= 0 );
    }
    
    /**
     * Zero out the credits stored in the system because the user
     * has spent them and any remaining value was returned with change.
     */
    public void creditsSpent()
    {
        m_current_user_credits = BigDecimal.ZERO;
    }
    
    /**
     * Get the current value of credits the customer has inserted into the 
     * machine.
     * @return The value of the credits the customer inserted
     */
    public BigDecimal getCurrentCredits()
    {
        return m_current_user_credits;
    }
    
    /**
     * Handle when a new credit is inserted by adding to the total
     * if and only if it is a USD credit
     * @param credit The new credit inserted
     */
    public void newCreditInserted( Credit credit )
    {
        if ( credit.getMonetarySystem().equals( USDCredit.MONETARY_SYSTEM ) )
        {
            m_current_user_credits = 
                m_current_user_credits.add( credit.getValue() );
        }
    }
}
