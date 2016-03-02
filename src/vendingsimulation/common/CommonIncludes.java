package vendingsimulation.common;

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
}

