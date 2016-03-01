package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents a cola being stored in the vending machine
 */
public class ColaItem implements VendableItem
{
    public ColaItem()
    {
    }
    
    public BigDecimal GetCostInUSD()
    {
        return BigDecimal.ONE;
    }
    
    public String GetName()
    {
        // TODO support internationalizations
        return ""; 
    }
}
