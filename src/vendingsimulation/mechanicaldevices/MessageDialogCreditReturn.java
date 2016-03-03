package vendingsimulation.mechanicaldevices;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javafx.scene.control.Alert;
import vendingsimulation.common.CommonIncludes;

import vendingsimulation.types.Credit;

/**
 * Since there is no coin hopper I'll just pop up a message informing the user
 * they have received change
 */
public class MessageDialogCreditReturn implements CreditReturn
{
    /**
     * Returns the given credits to the customer.
     */
    public void returnCredits( TreeMap<Credit, Integer> credits )
    {
        String quarters = "";
        String dimes = "";
        String nickels = "";
        String pennies = "";
        for ( Map.Entry<Credit, Integer> entry: credits.entrySet() )
        {
            Integer num_occurences = entry.getValue();
            
            if ( num_occurences < 1 )
            {
                continue;
            }
            
            String description = "";
            if ( entry.getKey().equals( CommonIncludes.QUARTER ))
            {
                if ( num_occurences > 1 )
                {
                    quarters = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.QUARTER_PLURAL );
                }
                else
                {
                    quarters = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.QUARTER_NAME );
                }
            }
            else if ( entry.getKey().equals( CommonIncludes.DIME ))
            {
                if ( num_occurences > 1 )
                {
                    dimes = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.DIME_PLURAL );
                }
                else
                {
                    dimes = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.DIME_NAME );
                }
            }
            else if ( entry.getKey().equals( CommonIncludes.NICKEL ))
            {
                if ( num_occurences > 1 )
                {
                    nickels = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.NICKEL_PLURAL );
                }
                else
                {
                    nickels = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.NICKEL_NAME );
                }
            }
            else if ( entry.getKey().equals( CommonIncludes.PENNY ))
            {
                if ( num_occurences > 1 )
                {
                    pennies = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.PENNY_PLURAL );
                }
                else
                {
                    pennies = String.format( "%d %s ", 
                        num_occurences, CommonIncludes.PENNY_NAME );
                }
            }
        }
        
        if ( quarters.isEmpty() && dimes.isEmpty() && nickels.isEmpty() &&
            pennies.isEmpty() )
        {
            return;
        }
        
        String output = String.format("Coins Returned: %s%s%s%s", 
            quarters, dimes, nickels, pennies ) ;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Coins Returned");
        alert.setHeaderText(output);
        alert.show();
    }
}
