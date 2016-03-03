package vendingsimulation.displayui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import java.util.ResourceBundle;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.displayui.MainDialogModel;
import vendingsimulation.types.VendableItem;
import vendingsimulation.types.PricedAndNamedItem;

/**
 * Controller class for the main dialog UI.
 */
public class MainDialogController implements Initializable 
{
    @FXML private Button buttonCandy;
    @FXML private Button buttonChips;
    @FXML private Button buttonCola;
    @FXML private Button buttonEjectUnspentMoney;
    @FXML private Button buttonInsertCoin;
    @FXML private ChoiceBox choiceBoxCoins;
    @FXML private Label labelCoinSlot;
    @FXML private Label labelDisplay;
    
    private MainDialogModel m_model;

    /**
     * Constructor
     */
    public MainDialogController()
    {
    }
    
    /**
     * Add items to the coins combo box and set up a value listener
     * @param url Unused
     * @param rb  Unused
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO replace this with a separate file holding the supported
        // insert types and translations.
        choiceBoxCoins.getItems().addAll("Penny", "Nickel", "Dime", "Quarter", 
            "Half Dollar", "Euro");
        choiceBoxCoins.getSelectionModel().selectFirst();
    }  
    
    /**
     * Late construction to add the model for this controller.
     * TODO find some way to manually construct the controller 
     * instead of letting JavaFx do it so I can pass extra arguments.
     * @param model The model for this controller.
     */
    public void setModel( MainDialogModel model )
    {
        m_model = model;
    }
    
    /**
     * Set the display output to the user
     * @param text The text to show
     */
    public void setDisplayText( String text )
    {
        labelDisplay.setText(text);
    }
    
    /**
     * Pops ups a message telling the user what coins were collected
     * in change return slot
     * @param text The text to display to the user
     */
    public void displayCoinsCollected( String text )
    {
        // TODO pop up message display the coins collected
    }
    
    /**
     * Display the items the user found in the vending bin.
     * @param text The text to the display to the user
     */
    public void displayItemsCollected( String text )
    {
        /// TODO pop up message displaying the items vendered.
    }
    
    /**
     * Handle when the candy dispenser button is clicked
     * @param event The action event
     */
    @FXML
    private void handleButtonCandy(ActionEvent event) 
    {
        if ( m_model != null )
        {
            VendableItem item = new PricedAndNamedItem( 
                CommonIncludes.COST_OF_CANDY, CommonIncludes.CANDY_NAME );
            m_model.itemRequested( item );
        }
    }
    
    /**
     * Handle when the candy dispenser button is clicked
     * @param event The action event
     */
    @FXML
    private void handleButtonChips(ActionEvent event)
    {
        if ( m_model != null )
        {
            VendableItem item = new PricedAndNamedItem( 
                CommonIncludes.COST_OF_CHIPS, CommonIncludes.CHIPS_NAME );
            m_model.itemRequested( item );
        }
    }
    
    /**
     * Handle when the cola dispenser button is clicked
     * @param event The action event
     */
    @FXML
    private void handleButtonCola(ActionEvent event)
    {
        if ( m_model != null )
        {
            VendableItem item = new PricedAndNamedItem( 
                CommonIncludes.COST_OF_COLA, CommonIncludes.COLA_NAME );
            m_model.itemRequested( item );
        }
    }
    
    /**
     * Handle when the insert coin button is clicked.
     * @param event The action event
     */
    @FXML
    private void handleButtonInsertCoin(ActionEvent event)
    {
        // TODO Grab the coin type from the choice box and send model a 
        // voltage representing a specific coin.
        // add class to do those conversions    
    }
    
    @FXML
    private void handleButtonEjectUnspentMoney(ActionEvent event)
    {
        // TODO send request to eject money when no purchase
        // has been made
    }
}

