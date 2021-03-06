package vendingsimulation.types;

import java.math.BigDecimal;

import vendingsimulation.types.Credit;

/**
 * A generic representation of some US monetary item
 */
public class USDCredit extends Credit
{
    /**
     * The name of the credit
     */
    private String m_name;
    /**
     * The name of the monetary system this credit is a part of.
     */
    public final static String MONETARY_SYSTEM = "USD";
    /**
     * The value of this credit in its monetary system
     */
    private BigDecimal m_value;
    
    /**
     * Constructor
     * @param name The name of the credit
     * @param value The value of the credit in its own system
     */
    public USDCredit( String name, BigDecimal value )
    {
        m_name = name;
        m_value = value;
    }
    
    /**
     * Returns the name of the credit
     * @return String describing the credit
     */
    public String getName()
    {
        return m_name;
    }
    
    /**
     * Returns the value of the credit in its own system
     * @return BigDecimal representing the value
     */
    public BigDecimal getValue()
    {
        return m_value;
    }
    
    /**
     * Return the name of the monetary system this credit belongs to
     * @return String representing the monetary system
     */
    public String getMonetarySystem()
    {
        return MONETARY_SYSTEM;
    }
}
