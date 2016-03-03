package vendingsimulation.moneystorage;

import static java.lang.Integer.min;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.TreeMap;
import java.util.Vector;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.mechanicaldevices.CreditReturn;
import vendingsimulation.types.Credit;
import vendingsimulation.types.USDCredit;

/**
 * Realistically this class would be messaged by another class 
 * which is reading from some register to obtain what coins were entered.
 * Lacking that actual hardware, this class will take direct calls from 
 * the UI in the form of a voltage. It will then translate that voltage
 * into a specific coin. Further, it only allows nickels, dimes, and quarters.
 * Finally, I'm assuming it starts off with 5 of each supported coin.
 */
public class NickelDimeQuarterChangeMaker implements ChangeMaker
{
    private class ChangeTuple
    {
        public int num_nickels = 0;
        public int num_dimes = 0;
        public int num_quarters = 0;
        public int num_pennies = 0;
        boolean could_make_change = false;
    }
    
    public final static int MAX_STORAGE = 10;
    
    private int m_num_nickels = 5;
    private int m_num_dimes = 5;
    private int m_num_quarters = 5;
    private int m_num_unspent_nickels = 0;
    private int m_num_unspent_dimes = 0;
    private int m_num_unspent_quarters = 0;
    
    CurrentCredits m_current_credits;
    
    CreditReturn m_credit_return;
    
    public NickelDimeQuarterChangeMaker( CreditReturn credit_return,
        CurrentCredits current_credits )
    {
        m_credit_return = credit_return;
        m_current_credits = current_credits;
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
        ChangeTuple change_tuple = constructChange( change_needed );
        
        return change_tuple.could_make_change;
    }
    
    /**
     * Returns the specified change to the customer
     * @param change_needed The value of the change required
     * @return True if the change was returned successfully.
     */
    public boolean returnChange( BigDecimal change_needed )
    { 
        ChangeTuple change_tuple = constructChange( change_needed );
        
        if ( change_tuple.could_make_change )
        {
            m_credit_return.returnCredits( 
                buildTreepFromTuple( change_tuple )  );
        }
        return change_tuple.could_make_change;
    }
    
    /**
     * Informs the ChangeMaker that a credit has been inserted but
     * not yet spent
     * @param credit The credit inserted
     * @return True if the ChangeMaker still has room for more change.
     */
    public CommonIncludes.CreditInsertedReturns creditInserted( Credit credit )
    {
        CommonIncludes.CreditInsertedReturns ret = 
            CommonIncludes.CreditInsertedReturns.UNSUPPORTED_TYPE;
        if ( credit.getMonetarySystem().equals( USDCredit.MONETARY_SYSTEM ) )
        {
            if ( credit.equals( CommonIncludes.QUARTER ) )
            {
                ++m_num_unspent_quarters;
                ret = CommonIncludes.CreditInsertedReturns.SUCCESS;
            }
            else if ( credit.equals( CommonIncludes.DIME ) )
            {
                ++m_num_unspent_dimes;
                ret = CommonIncludes.CreditInsertedReturns.SUCCESS;
            }
            else if ( credit.equals( CommonIncludes.NICKEL ) )
            {
                ++m_num_unspent_nickels;
                ret = CommonIncludes.CreditInsertedReturns.SUCCESS;
            }
            else if ( credit.equals( CommonIncludes.PENNY ) )
            {
                // Send pennies back out
                ChangeTuple tuple = new ChangeTuple();
                tuple.could_make_change = true;
                tuple.num_pennies = 1;
                m_credit_return.returnCredits( 
                    buildTreepFromTuple( tuple )  );
            }
        }
        
        return ret;
    }
    
    /**
     * Informs the ChangeMaker that credits inserted can now be
     * considered owned by the machine
     */
    public void creditsSpent()
    {
        m_num_quarters += m_num_unspent_quarters;
        m_num_dimes += m_num_unspent_dimes;
        m_num_nickels += m_num_unspent_nickels;
        m_num_unspent_quarters = 0;
        m_num_unspent_dimes = 0;
        m_num_unspent_nickels = 0;
    }
    
    public void ejectUnspentMoney()
    {
        ChangeTuple change_tuple = new ChangeTuple();
        change_tuple.num_dimes = m_num_unspent_dimes;
        change_tuple.num_nickels = m_num_unspent_nickels;
        change_tuple.num_quarters = m_num_unspent_quarters;
        change_tuple.could_make_change = true;    
        m_credit_return.returnCredits( 
                buildTreepFromTuple( change_tuple )  );
        creditsSpent();
        m_current_credits.creditsSpent();
    }
    
    /**
     * Return true if this machine requires exact change
     * @return True if exact change needed
     */
    public boolean checkIfExactChangeNeeded()
    {
        boolean two_dimes_one_nickel = ( ( m_num_nickels >= 1 ) && 
            ( m_num_dimes >= 2 ) );
        boolean one_dime_three_nickels = ( ( m_num_nickels >= 3 ) && 
            ( m_num_dimes >= 1 ) );
        boolean five_nickels = m_num_nickels >= 5;
        return !two_dimes_one_nickel && !one_dime_three_nickels && 
            !five_nickels;
        
    }
    
    /**
     * Construct the data structure used to output credits
     * based on the change being returned
     * @param tuple Describes the change
     * @return A map stating how many of each credit will be returned;
     */
    private TreeMap<Credit, Integer> buildTreepFromTuple( ChangeTuple tuple )
    {
        TreeMap<Credit, Integer> credit_map = new TreeMap<Credit, Integer>();
        credit_map.put( CommonIncludes.QUARTER, tuple.num_quarters );
        credit_map.put( CommonIncludes.DIME, tuple.num_dimes );
        credit_map.put( CommonIncludes.NICKEL, tuple.num_nickels );
        credit_map.put( CommonIncludes.PENNY, tuple.num_pennies );
        return credit_map;
    }
    
    /**
     * Constructs a TreeMap of how many of each credit to return as change
     * The TreeMap is empty if change could not be made
     * @param change_needed The change required
     * @return A vector of credits to return.
     */
    private ChangeTuple constructChange( BigDecimal change_needed )
    {
        ChangeTuple ret = new ChangeTuple();
        int total_nickels = m_num_nickels + m_num_unspent_nickels;
        int total_dimes = m_num_dimes + m_num_unspent_dimes;
        int total_quarters = m_num_quarters + m_num_unspent_quarters;
        
        int num_quarters_returned = 0;
        int num_dimes_returned = 0;
        int num_nickels_returned = 0;
        
        
        int quarters_that_fit = 
            change_needed.divide(CommonIncludes.VALUE_OF_QUARTER, 2,
                RoundingMode.HALF_UP).intValue();
        num_quarters_returned = min( quarters_that_fit, total_quarters );
        change_needed = change_needed.subtract(
            CommonIncludes.VALUE_OF_QUARTER.multiply( 
                    new BigDecimal( num_quarters_returned ) ) );
        
        int dimes_that_fit = 
            change_needed.divide(CommonIncludes.VALUE_OF_DIME, 2,
                RoundingMode.HALF_UP).intValue();
        num_dimes_returned = min( dimes_that_fit, total_dimes );
        change_needed = change_needed.subtract(
           CommonIncludes.VALUE_OF_DIME.multiply( 
                    new BigDecimal( num_dimes_returned )) );
        
        int nickels_that_fit = 
            change_needed.divide(CommonIncludes.VALUE_OF_NICKEL, 2, 
                RoundingMode.HALF_UP).intValue();
        num_nickels_returned = min( nickels_that_fit, total_nickels );
        change_needed = change_needed.subtract(
           CommonIncludes.VALUE_OF_NICKEL.multiply( 
                    new BigDecimal( num_nickels_returned )) );
        
        if ( change_needed.abs().compareTo( 
            CommonIncludes.VALUE_OF_PENNY ) < 0 )
        {
            ret.num_quarters = num_quarters_returned;
            ret.num_dimes = num_dimes_returned;
            ret.num_nickels = num_nickels_returned;
            ret.could_make_change = true;
        }
        return ret;
    }
}
