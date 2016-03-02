package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents any item that can be stored in the vending machine
 * that has a price and a name
 */
public class PricedAndNamedItem implements VendableItem
{
    private BigDecimal m_cost;
    private String m_name;
    
    /**
     * Constructor
     * @param cost A big decimal representing the cost of this item
     * @param name A name representing this item
     */
    public PricedAndNamedItem( BigDecimal cost, String name )
    {
        m_cost = cost.max( new BigDecimal(0.0) );
        m_name = name;
    }
    
    /**
     * Returns the cost of this item
     * @return A big decimal representing the cost of this item
     */
    public BigDecimal GetCost()
    {
        return m_cost;
    }
    
    /**
     * Returns the name of this item.
     * @return A string representing the name of this object.
     */
    public String GetName()
    {
        return m_name;
    }
}
