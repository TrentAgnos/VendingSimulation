package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * A vendable item is any product the vending machine can provide
 */
public interface VendableItem 
{
    /**
     * The cost of the item
     * @return A Big Decimal representing the cost of the item
     */
    BigDecimal GetCost();
    /**
     * Get the name of the item
     * @return A string representing the name of the item.
     */
    String GetName();
}
