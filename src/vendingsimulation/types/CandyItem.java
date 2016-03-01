package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents some candy being stored in the vending machine
 */
public class CandyItem implements VendableItem
{
    /**
     * Constructor
     */
    public CandyItem()
    {
    }
    
    /**
     * Returns the cost in US dollars for this item.
     * @return A BigDecimal representing the price in USD.
     */
    public BigDecimal GetCostInUSD()
    {
        return new BigDecimal(0.65);
    }
    
    /**
     * Returns the name of this product
     * @return A string representing this product.
     */
    public String GetName()
    {
        // TODO support internationalizations
        return "Candy"; 
    }
}
