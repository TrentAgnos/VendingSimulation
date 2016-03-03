package vendingsimulation.moneystorage;

import java.math.BigDecimal;
import java.util.Vector;
import vendingsimulation.common.CommonIncludes;

import vendingsimulation.displayui.MainDialogModel;
import vendingsimulation.types.Credit;
import vendingsimulation.types.USDCredit;

/**
 * Realistically this class would be messaged by another class 
 * which is reading from some register to obtain what coins were entered.
 * Lacking that actual hardware, this class will take direct calls from 
 * the UI in the form of a voltage. It will then translate that voltage
 * into a specific coin. Further, it only allows nickels, dimes, and quarters.
 * Finally, I'm assuming the hopper has 10 slots for each coin type and
 * starts off with 5 of each type.
 */
public class NickelDimeQuarter10EachChangeMaker implements ChangeMaker
{
    /**
     * The main dialog mode. Used to pop up a message on the UI
     * that change was returned
     */
    private MainDialogModel m_model;
    private int m_num_nickels = 5;
    private int m_num_dimes = 5;
    private int m_num_quarters = 5;
    
    public final static BigDecimal VALUE_OF_NICKEL = new BigDecimal( 0.5 );
    public final static BigDecimal VALUE_OF_DIME = new BigDecimal( 0.10 );
    public final static BigDecimal VALUE_OF_QUARTER = new BigDecimal( 0.25 );
    
    private Vector<Credit> m_unspent_inserted_credits;
    
    public NickelDimeQuarter10EachChangeMaker( MainDialogModel model )
    {
        m_model = model;
        m_unspent_inserted_credits = new Vector<Credit>();
        checkIfExactChangeNeeded();
    }
    
    /**
     * Check if this change maker is capable of returning change 
     * equal to the amount given
     * @param change_needed The value of change required.
     * @return True if the vending machine has enough change
     * to return to the customer
     */
    public boolean canMakeChange( BigDecimal change_needed )
    {
        if ( !change_needed.remainder( new BigDecimal( 5 ) ).
            equals( new BigDecimal( 0 ) ) )
        {
            // We cannot return change that isn't a factor of 5
            return false;
        }
        
        BigDecimal temp_change_needed = change_needed;
        int num_nickels = m_num_nickels;
        int num_dimes = m_num_nickels;
        int num_quarters = m_num_quarters;
        
        while ( true )
        {
            if ( ( num_quarters > 0 ) && 
                temp_change_needed.compareTo( VALUE_OF_QUARTER ) >= 0 )
            {
                --num_quarters;
                temp_change_needed.subtract( VALUE_OF_QUARTER );
            }
            else if ( ( num_dimes > 0 ) && 
                temp_change_needed.compareTo( VALUE_OF_DIME ) >= 0 )
            {
                --num_dimes;
                temp_change_needed.subtract( VALUE_OF_DIME );
            }
            else if ( ( num_nickels > 0 ) && 
                temp_change_needed.compareTo( VALUE_OF_NICKEL ) >= 0 )
            {
                --num_nickels;
                temp_change_needed.subtract( VALUE_OF_NICKEL );
            }
            else
            {
                break;
            }
        }
        
        return temp_change_needed.equals(BigDecimal.ZERO);
    }
    
    /**
     * Returns the specified change to the customer
     * @param change_needed The value of the change required
     * @return True if the change was returned successfully.
     */
    public boolean returnChange( BigDecimal change_needed )
    {
        return false;
    }
    
    /**
     * Informs the ChangeMaker that a credit has been inserted but
     * not yet spent
     * @param credit The credit inserted
     * @return True if the ChangeMaker still has room for more change.
     */
    public CommonIncludes.CreditInsertedReturns creditInserted( Credit credit )
    {
        return CommonIncludes.CreditInsertedReturns.SUCCESS;
    }
    
    /**
     * Informs the ChangeMaker that credits inserted can now be
     * considered owned by the machine
     */
    public void creditsSpent()
    {
        // loop over credits and assign their value
    }
    
    private boolean checkIfExactChangeNeeded()
    {
        return false;
    }
    
    private Vector<Credit> returnChange()
    {
        return new Vector<Credit>();
    }
}
