package com.nunsys.cursoPOO.classes;

import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;
import com.nunsys.cursoPOO.interfaces.IContainer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public abstract class AbstractContainerTest {

    protected IContainer systemUnderTest;
    protected final static int VOLUME = 10;

    @Test
    public void testGetPortion() throws NotEnoughException {
        int expCurVolume = VOLUME;

        systemUnderTest.getPortion(Portion.SMALL);
        expCurVolume -= Portion.SMALL.size();
        assertEquals("Calculation for the SMALL portion is incorrect",
                expCurVolume, systemUnderTest.getCurrentVolume());

        systemUnderTest.getPortion(Portion.MEDIUM);
        expCurVolume -= Portion.MEDIUM.size();
        assertEquals("Calculation for the MEDIUM portion is incorrect",
                expCurVolume, systemUnderTest.getCurrentVolume());

        systemUnderTest.getPortion(Portion.LARGE);
        expCurVolume -= Portion.LARGE.size();
        assertEquals("Calculation for the LARGE portion is incorrect",
                expCurVolume, systemUnderTest.getCurrentVolume());

    }

    @Test(expected = NotEnoughException.class)
    public void testNotEnoughException() throws NotEnoughException {
        systemUnderTest.getPortion(Portion.LARGE);
        systemUnderTest.getPortion(Portion.LARGE);
        systemUnderTest.getPortion(Portion.LARGE);
        systemUnderTest.getPortion(Portion.LARGE);
    }

    @Test
    public void testGetCurrentVolume() {
        assertEquals("Current volume has incorrect value.", VOLUME,
                systemUnderTest.getCurrentVolume());
    }

    @Test
    public void testGetTotalVolume() {
        assertEquals("Total volume has incorrect value.", VOLUME,
                systemUnderTest.getTotalVolume());
    }

    @Test
    public void testRefillContainer() throws NotEnoughException {
        systemUnderTest.getPortion(Portion.SMALL);
        systemUnderTest.refillContainer();
        assertEquals("Refill functionality works incorectly.", VOLUME,
                systemUnderTest.getCurrentVolume());
    }

}