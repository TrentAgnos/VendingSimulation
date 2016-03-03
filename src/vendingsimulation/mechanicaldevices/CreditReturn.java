package vendingsimulation.mechanicaldevices;

import java.util.TreeMap;
import java.util.Vector;

import vendingsimulation.types.Credit;

/**
 * Credit returns perform the actions required to return credits to 
 * the customer.
 */
public interface CreditReturn 
{
    /**
     * Returns the given credits to the customer.
     */
    void returnCredits( TreeMap<Credit, Integer> credits );
}
