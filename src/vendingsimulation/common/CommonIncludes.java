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
}

