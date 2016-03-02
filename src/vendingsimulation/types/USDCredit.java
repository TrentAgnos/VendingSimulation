package vendingsimulation.types;

import java.math.BigDecimal;

import vendingsimulation.types.Credit;

/**
 * A generic representation of some US monetary item
 */
public class USDCredit implements Credit
{
    /**
     * The name of the credit
     */
    private String m_name;
    /**
     * The name of the monetary system this credit is a part of.
     */
    private final static String m_monetary_system = "USD";
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
    public String GetName()
    {
        return m_name;
    }
    
    /**
     * Returns the value of the credit in its own system
     * @return BigDecimal representing the value
     */
    public BigDecimal GetValue()
    {
        return m_value;
    }
    
    /**
     * Return the name of the monetary system this credit belongs to
     * @return String representing the monetary system
     */
    public String GetMonetarySystem()
    {
        return m_monetary_system;
    }
}
