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
    
    public final static BigDecimal COST_OF_COLA = new BigDecimal( 1.00 );
    public final static BigDecimal COST_OF_CANDY = new BigDecimal( 0.65 );
    public final static BigDecimal COST_OF_CHIPS = new BigDecimal( 0.50 );
    public final static String COLA_NAME = "cola";
    public final static String CANDY_NAME = "candy";
    public final static String CHIPS_NAME = "chips";
    
    public final static String NICKLE_NAME = "nickle";
    public final static String NICKLE_PLURAL = "nickels";
    public final static String DIME_NAME = "dime";
    public final static String DIME_PLURAL = "dimes";
    public final static String QUARTER_NAME = "quarter";
    public final static String QUARTER_PLURAL = "quarters";
    public final static BigDecimal VALUE_OF_NICKLE = new BigDecimal( 0.05 );
    public final static BigDecimal VALUE_OF_DIME = new BigDecimal( 0.10 );
    public final static BigDecimal VALUE_OF_QUARTER = new BigDecimal( 0.25 );
}

