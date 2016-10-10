package com.nunsys.cursoPOO.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public class WaterContainerTest extends AbstractContainerTest {
    @Before
    public void setUp() throws Exception {
        systemUnderTest = new WaterContainer(VOLUME);
    }

    @After
    public void tearDown() throws Exception {
        systemUnderTest = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfCapacityIsZero() {
        systemUnderTest = new WaterContainer(0);
    }

}