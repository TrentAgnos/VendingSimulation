package vendingsimulation.mechanicaldevices;

import java.math.BigDecimal;

/**
 * Credit readers analyze a form of credit inserted and 
 */
public interface CreditReader 
{ 
    /**
     * Handle a new voltage from credit reading device
     * @param voltage The voltage describing the credit
     */
    public void newVoltage( BigDecimal voltage );
}
