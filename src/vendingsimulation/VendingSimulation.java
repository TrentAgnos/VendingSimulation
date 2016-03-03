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
import vendingsimulation.mechanicaldevices.ItemVender;
import vendingsimulation.mechanicaldevices.MessageDialogItemVender;
import vendingsimulation.moneystorage.ChangeMaker;
import vendingsimulation.moneystorage.CurrentCredits;
import vendingsimulation.moneystorage.stubs.StubChangeMaker;
import vendingsimulation.moneystorage.stubs.StubCurrentCredits;

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
        
        ChangeMaker change_maker = new StubChangeMaker();
        CurrentCredits cur_credits = new StubCurrentCredits();
        ItemVender vender = new MessageDialogItemVender();
        InventoryManager inven_manager = new ThreeItemsEachInventoryManager( 
            vender );
        
        Dispenser dispenser = new VerificationDispenser( change_maker,
            cur_credits, inven_manager );
        MainDialogModel model = new MainDialogDispenserModel( 
            dispenser, controller );
        
        controller.setModel( model );
        
        stage.show();
    }
}

