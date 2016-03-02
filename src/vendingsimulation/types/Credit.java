package vendingsimulation.types;

import java.math.BigDecimal;


public interface Credit 
{
    /**
     * Returns the name of the credit
     * @return String describing the credit
     */
    public String GetName();
    
    /**
     * Returns the value of the credit in its own system
     * @return BigDecimal representing the value
     */
    public BigDecimal GetValue();
    
    /**
     * Return the name of the monetary system this credit belongs to
     * @return String representing the monetary system
     */
    public String GetMonetarySystem();
}
