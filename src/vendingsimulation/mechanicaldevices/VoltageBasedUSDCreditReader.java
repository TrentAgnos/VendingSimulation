package vendingsimulation.mechanicaldevices;

import java.math.BigDecimal;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.moneystorage.ChangeMaker;
import vendingsimulation.moneystorage.CurrentCredits;
import vendingsimulation.types.Credit;
import vendingsimulation.types.USDCredit;
import vendingsimulation.types.UnknownCredit;

/**
 * A credit reader which takes in a voltage and converts
 * to a Credit
 * 
 * Based on
 * http://www.best-microcontroller-projects.com/coin-detector-and-counter.html
 * 
 */
public class VoltageBasedUSDCreditReader implements CreditReader
{
    /**
     * Voltage output from the coin slot reader when a nickel passes by
     */
    public final static BigDecimal VOLTAGE_FOR_NICKEL = new BigDecimal( 3.68 );
    /**
     * Voltage output from the coin slot reader when a dime passes by
     */
    public final static BigDecimal VOLTAGE_FOR_DIME = new BigDecimal( 2.40 );
    /**
     * Voltage output from the coin slot reader when a quarter passes by
     */
    public final static BigDecimal VOLTAGE_FOR_QUARTER = new BigDecimal( 5.31 );
    /**
     * Voltage output from the coin slot reader when a penny passes by
     */
    public final static BigDecimal VOLTAGE_FOR_PENNY = new BigDecimal( 2.95 );
    /**
     * Class responsible for returning change
     */
    private ChangeMaker m_change_maker;
    /**
     * Class responsible for tracking current customer inserted credits
     */
    private CurrentCredits m_cur_credits;
    
    /**
     * Constructor
     * @param change_maker Class responsible for producing change
     * @param cur_credits Class responsible for tracking customer inserted
     * credits
     */
    public VoltageBasedUSDCreditReader( ChangeMaker change_maker, 
        CurrentCredits cur_credits )
    {
        m_change_maker = change_maker;
        m_cur_credits = cur_credits;
    }
    
    /**
     * Handle a new voltage from the coin slot by constructing
     * the appropriate credit and telling the change maker and
     * current credits 
     * @param voltage The voltage from the coin reader
     */
    public void newVoltage( BigDecimal voltage )
    {
        Credit credit;
        if ( voltage.equals( VOLTAGE_FOR_NICKEL ) )
        {
            credit = new USDCredit( CommonIncludes.NICKEL_NAME, 
                CommonIncludes.VALUE_OF_NICKEL );
        }
        else if ( voltage.equals( VOLTAGE_FOR_DIME ) )
        {
            credit = new USDCredit( CommonIncludes.DIME_NAME, 
                CommonIncludes.VALUE_OF_DIME );
        }
        else if ( voltage.equals( VOLTAGE_FOR_QUARTER ) )
        {
            credit = new USDCredit( CommonIncludes.QUARTER_NAME, 
                CommonIncludes.VALUE_OF_QUARTER );
        }
        else if ( voltage.equals( VOLTAGE_FOR_PENNY ) )
        {
            credit = new USDCredit( CommonIncludes.PENNY_NAME, 
                CommonIncludes.VALUE_OF_PENNY );
        }
        else
        {
            credit = new UnknownCredit();
        }
        
        System.out.println( String.format("Credit value %s", credit.getValue().toString() ) );
        
        if ( m_change_maker.creditInserted( credit ) == 
            CommonIncludes.CreditInsertedReturns.SUCCESS )
        {
            m_cur_credits.newCreditInserted( credit );
        }
    }
}
