package vendingsimulation.types;

import java.math.BigDecimal;


public abstract class Credit 
{
    /**
     * Returns the name of the credit
     * @return String describing the credit
     */
    abstract public String getName();
    
    /**
     * Returns the value of the credit in its own system
     * @return BigDecimal representing the value
     */
    abstract public BigDecimal getValue();
    
    /**
     * Return the name of the monetary system this credit belongs to
     * @return String representing the monetary system
     */
    abstract public String getMonetarySystem();
    
    /**
     * Returns true if this credit and the other credit are the same
     * @return True if they are the same
     */
    public boolean equals( Credit other )
    {
        return this.getName().equals(other.getName() ) &&
                this.getValue().equals(other.getValue() ) &&
                this.getMonetarySystem().equals(other.getMonetarySystem() );
    }
}
