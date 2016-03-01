package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents a cola being stored in the vending machine
 */
public class ColaItem implements VendableItem
{
    // The cost of a cola in this vending machine
    final static double COST = 1.00;
    
    /**
     * Constructor
     */
    public ColaItem()
    {
    }
    
    /**
     * Returns the cost in US dollars for this item.
     * @return A BigDecimal representing the price in USD.
     */
    public BigDecimal GetCostInUSD()
    {
        return new BigDecimal( COST );
    }
    
    /**
     * Returns the name of this product
     * @return A string representing this product.
     */
    public String GetName()
    {
        // TODO support internationalizations
        return "Cola"; 
    }
}
