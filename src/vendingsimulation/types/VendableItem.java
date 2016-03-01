package vendingsimulation.types;

import java.math.BigDecimal;

public interface VendableItem 
{
    BigDecimal GetCostInUSD();
    String GetName();
}
