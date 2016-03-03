/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingsimulation.mechanicaldevices;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import vendingsimulation.common.CommonIncludes;
import vendingsimulation.moneystorage.stubs.StubChangeMaker;
import vendingsimulation.moneystorage.stubs.StubCurrentCredits;
import vendingsimulation.types.USDCredit;
import vendingsimulation.types.UnknownCredit;

/**
 * Tests the voltage based usd credit reader returns the correct credit type
 */
public class VoltageBasedUSDCreditReaderTest 
{
    
    StubChangeMaker change_maker;
    StubCurrentCredits cur_credits;
    VoltageBasedUSDCreditReader reader;
    USDCredit penny;
    USDCredit nickel;
    USDCredit dime;
    USDCredit quarter;
    UnknownCredit unknown;
    
    @Before
    public void setUp() 
    {
        change_maker = new StubChangeMaker();
        cur_credits = new StubCurrentCredits();
        reader = new VoltageBasedUSDCreditReader( change_maker, cur_credits );
        penny = new USDCredit( CommonIncludes.PENNY_NAME, 
            CommonIncludes.VALUE_OF_PENNY );
        nickel = new USDCredit( CommonIncludes.NICKEL_NAME, 
            CommonIncludes.VALUE_OF_NICKEL );
        dime = new USDCredit( CommonIncludes.DIME_NAME, 
            CommonIncludes.VALUE_OF_DIME );
        quarter = new USDCredit( CommonIncludes.QUARTER_NAME, 
            CommonIncludes.VALUE_OF_QUARTER );
        unknown = new UnknownCredit();
    }
    
    /**
     * Test new voltage returns USD types
     */
    @Test
    public void testNewVoltageSupportsBasicUSDCoins() 
    {
        System.out.println("testNewVoltageSupportsBasicUSDCoins");
        
        reader.newVoltage( VoltageBasedUSDCreditReader.VOLTAGE_FOR_PENNY );
        assertTrue( penny.equals(change_maker.m_last_credit) );
        assertTrue( penny.equals(cur_credits.m_last_credit) );
        reader.newVoltage( VoltageBasedUSDCreditReader.VOLTAGE_FOR_NICKEL );
        assertTrue( nickel.equals(change_maker.m_last_credit) );
        assertTrue( nickel.equals(cur_credits.m_last_credit) );
        reader.newVoltage( VoltageBasedUSDCreditReader.VOLTAGE_FOR_DIME );
        assertTrue( dime.equals(change_maker.m_last_credit) );
        assertTrue( dime.equals(cur_credits.m_last_credit) );
        reader.newVoltage( VoltageBasedUSDCreditReader.VOLTAGE_FOR_QUARTER );
        assertTrue( quarter.equals(change_maker.m_last_credit) );
        assertTrue( quarter.equals(cur_credits.m_last_credit) );
    }
    
    /**
     * Test random voltages result in unknown credits
     */
    @Test
    public void testNewVoltageDoesNotSupportOtherTypes()
    {
        System.out.println("testNewVoltageDoesNotSupportOtherTypes");
        reader.newVoltage( new BigDecimal( 333 ) );
        assertTrue( unknown.equals(change_maker.m_last_credit) ); 
        assertTrue( unknown.equals(cur_credits.m_last_credit) );
    }
    
}
