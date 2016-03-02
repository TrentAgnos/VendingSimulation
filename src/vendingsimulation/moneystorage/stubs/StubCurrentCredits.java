package vendingsimulation.moneystorage.stubs;

import java.math.BigDecimal;

import vendingsimulation.moneystorage.CurrentCredits;

public class StubCurrentCredits implements CurrentCredits
{
    public boolean m_has_enough_credits = true;
    public boolean m_credits_spent = false;
    
    public StubCurrentCredits()
    {
    }
    
    public boolean hasEnoughCredits( BigDecimal cost )
    {
        return m_has_enough_credits;
    }
    
    public void creditsSpent()
    {
        m_credits_spent = true;
    }
    
    public BigDecimal getCurrentCredits()
    {
        return BigDecimal.ONE;
    }
}
