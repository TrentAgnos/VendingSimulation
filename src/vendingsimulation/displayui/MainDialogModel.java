package vendingsimulation.displayui;

import vendingsimulation.types.VendableItem;

public interface MainDialogModel 
{
    void itemRequested( VendableItem item );
    void setController( MainDialogController controller );
    void changeCollectionRequested();
    void itemCollectionRequested();
    void coinInserted( double voltage_from_coin_reader );
    void ejectUnspentMoney();
}
