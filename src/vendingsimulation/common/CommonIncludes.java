package vendingsimulation.common;

import java.math.BigDecimal;

/**
 * Common enums and defines
 */
public class CommonIncludes
{
    /**
     * Possible results when attemtping to dispense an item
     */
    public enum DispensingReturns
    {
        NOT_ENOUGH_MONEY,
        OUT_OF_STOCK,
        EXACT_CHANGE_NEEDED,
        SUCCESSFUL_VEND
    }
    
    /**
     * Possible returns when inserting credits
     */
    public enum CreditInsertedReturns
    {
        STORAGE_FULL,
        UNSUPPORTED_TYPE,
        SUCCESS
    }
    
    public final static BigDecimal COST_OF_COLA = new BigDecimal( 1.00 );
    public final static BigDecimal COST_OF_CANDY = new BigDecimal( 0.65 );
    public final static BigDecimal COST_OF_CHIPS = new BigDecimal( 0.50 );
    public final static String COLA_NAME = "cola";
    public final static String CANDY_NAME = "candy";
    public final static String CHIPS_NAME = "chips";
    
    public final static String NICKEL_NAME = "nickel";
    public final static String NICKEL_PLURAL = "nickels";
    public final static String DIME_NAME = "dime";
    public final static String DIME_PLURAL = "dimes";
    public final static String QUARTER_NAME = "quarter";
    public final static String QUARTER_PLURAL = "quarters";
    public final static String PENNY_NAME = "penny";
    public final static String PENNY_PLURAL = "pennies";
    public final static BigDecimal VALUE_OF_NICKEL = new BigDecimal( 0.05 );
    public final static BigDecimal VALUE_OF_DIME = new BigDecimal( 0.10 );
    public final static BigDecimal VALUE_OF_QUARTER = new BigDecimal( 0.25 );
    public final static BigDecimal VALUE_OF_PENNY = new BigDecimal( 0.01 );
}

