package vendingsimulation.displayui;

import java.math.BigDecimal;
import java.util.Vector;


import vendingsimulation.types.VendableItem;
import vendingsimulation.types.Credit;

public interface MainDialogModel 
{
    void itemRequested( VendableItem item );
    void setController( MainDialogController controller );
    void coinInserted( double voltage_from_coin_reader );
    void ejectUnspentMoney();
    
    void handleNotEnoughMoney( VendableItem item );
    void handleOutOfStock( VendableItem item );
    void handleExactChangeNeeded();
    void handleDisplayCurrentCredits( BigDecimal cur_credits );
    void handleItemDispensed( VendableItem item );
    void handleChangeReturned( Vector<Credit> coins );
    void handleInactiveState();
}
