package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents a cola being stored in the vending machine
 */
public class ColaItem implements VendableItem
{
    // The cost of a cola in this vending machine
    BigDecimal m_cost;
    
    /**
     * Constructor
     */
    public ColaItem( BigDecimal cost )
    {
        m_cost = cost;
    }
    
    /**
     * Returns the cost in US dollars for this item.
     * @return A BigDecimal representing the price in USD.
     */
    public BigDecimal GetCostInUSD()
    {
        return m_cost;
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
