package vendingsimulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().
            getResource("displayui/MainDialog.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}

