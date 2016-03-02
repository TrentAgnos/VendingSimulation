package vendingsimulation.dispenser;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.types.VendableItem;

/**
 * Dispensers decide if an item is dispensed and returns an error if
 * the item is not dispensed.
 */
public interface Dispenser 
{
    /**
     * Attempt to dispense an item
     * @param item The item requested to be dispensed
     * @return SUCCESSFUL_VEND if the item was dispensed, otherwise
     * a descriptive error stating why it could not be dispensed.
     */
    CommonIncludes.DispensingReturns dispenseItem( VendableItem item );
}
