package vendingsimulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import vendingsimulation.dispenser.Dispenser;
import vendingsimulation.dispenser.VerificationDispenser;
import vendingsimulation.displayui.MainDialogController;
import vendingsimulation.displayui.MainDialogDispenserModel;
import vendingsimulation.displayui.MainDialogModel;
import vendingsimulation.inventory.InventoryManager;
import vendingsimulation.inventory.ThreeItemsEachInventoryManager;
import vendingsimulation.mechanicaldevices.CreditReader;
import vendingsimulation.mechanicaldevices.CreditReturn;
import vendingsimulation.mechanicaldevices.ItemVender;
import vendingsimulation.mechanicaldevices.MessageDialogCreditReturn;
import vendingsimulation.mechanicaldevices.MessageDialogItemVender;
import vendingsimulation.mechanicaldevices.VoltageBasedUSDCreditReader;
import vendingsimulation.moneystorage.ChangeMaker;
import vendingsimulation.moneystorage.CurrentCredits;
import vendingsimulation.moneystorage.NickelDimeQuarterChangeMaker;
import vendingsimulation.moneystorage.USDCurrentCredits;
import vendingsimulation.moneystorage.stubs.StubChangeMaker;

/**
 * Entry point for the vending simulation
 */
public class VendingSimulation  extends Application
{
    /**
     * Called upon construction of this class
     * @param stage Top level java fx container
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader( getClass().
            getResource("displayui/MainDialog.fxml") );
        Parent root = (Parent) loader.load();

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        MainDialogController controller = 
            (MainDialogController)loader.getController();
        
        CreditReturn credit_return = new MessageDialogCreditReturn();
        CurrentCredits cur_credits = new USDCurrentCredits();
        ChangeMaker change_maker = new NickelDimeQuarterChangeMaker( 
            credit_return, cur_credits );
        ItemVender vender = new MessageDialogItemVender();
        InventoryManager inven_manager = new ThreeItemsEachInventoryManager( 
            vender );
        CreditReader reader = new VoltageBasedUSDCreditReader( 
            change_maker, cur_credits );
        
        Dispenser dispenser = new VerificationDispenser( change_maker,
            cur_credits, inven_manager );
        MainDialogModel model = new MainDialogDispenserModel( 
            dispenser, controller, cur_credits, reader, change_maker );
        
        controller.setModel( model );
        
        stage.show();
    }
}

