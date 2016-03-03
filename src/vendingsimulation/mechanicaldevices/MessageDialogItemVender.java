package vendingsimulation.mechanicaldevices;

import javafx.scene.control.Alert;
import vendingsimulation.types.VendableItem;

/**
 * An abstraction that eliminates the hardware device and instead
 * informs the user what was vended
 */
public class MessageDialogItemVender implements ItemVender
{
    /**
     * This is where we'd send off commands to another class or microcontroller
     * to execute the mechanical movement to vend. However, since I do not
     * have hardware this pops up a dialog. Popping up a message dialog
     * deep in some class isn't usually a good idea, but the real 
     * work I'm trying to do shouldn't involve UI. So, I'm accepting
     * the hack of a dialog to make a usable and testable UI.
     * @param item The item to vend
     */
    @Override
    public void vendItem( VendableItem item )
    {
        String output = String.format("Vended: %s", item.getName());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item Vended");
        alert.setHeaderText(output);
        alert.show();
    }
}
