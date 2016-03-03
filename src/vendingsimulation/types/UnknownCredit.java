package vendingsimulation.types;

import java.math.BigDecimal;

/**
 * Represents an unknown credit. Credits are unknown because the credit reader
 * is incapable of reading the inserted type.
 */
public class UnknownCredit extends Credit
{
    /**
     * The name of the credit
     */
    public final static String m_name = "Unknown";
    /**
     * The name of the monetary system this credit is a part of.
     */
    public final static String MONETARY_SYSTEM = "Unknown";
    /**
     * The value of this credit in its monetary system
     */
    public final static BigDecimal m_value = BigDecimal.ZERO;
    
    /**
     * Constructor
     */
    public UnknownCredit(  )
    {
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
