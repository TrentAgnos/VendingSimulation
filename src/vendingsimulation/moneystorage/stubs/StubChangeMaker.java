package vendingsimulation.moneystorage.stubs;

import java.math.BigDecimal;

import vendingsimulation.moneystorage.ChangeMaker;

public class StubChangeMaker implements ChangeMaker
{
    public boolean m_can_make_change = true;
    public boolean m_asked_to_give_change = false;
    
    public StubChangeMaker()
    {
    }
    
    public boolean canMakeChange( BigDecimal cost )
    {
        return m_can_make_change;
    }
    
    public boolean returnChange( BigDecimal cost )
    {
        m_asked_to_give_change = true;
        return true;
    }
    
    public boolean creditInserted( BigDecimal voltage )
    {
        return true;
    }
    
    public void creditsSpent()
    {
        
    }
}
