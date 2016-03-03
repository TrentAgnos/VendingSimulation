package vendingsimulation.moneystorage.stubs;

import java.math.BigDecimal;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.moneystorage.ChangeMaker;
import vendingsimulation.types.Credit;
import vendingsimulation.types.UnknownCredit;

public class StubChangeMaker implements ChangeMaker
{
    public boolean m_can_make_change = true;
    public boolean m_asked_to_give_change = false;
    public Credit m_last_credit = new UnknownCredit();
    
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
    
    public CommonIncludes.CreditInsertedReturns creditInserted( Credit credit )
    {
        m_last_credit = credit;
        return CommonIncludes.CreditInsertedReturns.SUCCESS;
    }
    
    public void creditsSpent()
    {
        
    }
    
    public void ejectUnspentMoney()
    {
        
    }
    
    public boolean checkIfExactChangeNeeded()
    {
        return false;
    }
}
