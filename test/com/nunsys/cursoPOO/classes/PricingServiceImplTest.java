package com.nunsys.cursoPOO.classes;

import com.nunsys.cursoPOO.exceptions.SkuNotFoundException;
import com.nunsys.cursoPOO.interfaces.DataAccess;
import com.nunsys.cursoPOO.interfaces.PricingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public class PricingServiceImplTest {

    private static final String GOOD_SKU = "3283947";
    private static final String BAD_SKU = "-9999993434";
    private static final BigDecimal expectedPrice = new BigDecimal(100);
    private PricingService pricingService;

    @Mock
    private DataAccess mockDataAccess;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pricingService = new PricingServiceImpl();
        pricingService.setDataAccess(mockDataAccess);
    }

    @Test
    public void getPrice() throws SkuNotFoundException {
        // Preparación
        when(mockDataAccess.getPriceBySku(GOOD_SKU)).thenReturn(expectedPrice);


        // Ejecución
        final BigDecimal price = pricingService.getPrice(GOOD_SKU);

        // Verificación
        assertNotNull(price);
        assertEquals(expectedPrice, price);
        verify(mockDataAccess).getPriceBySku(Matchers.eq(GOOD_SKU));
        verify(mockDataAccess, times(1)).getPriceBySku(GOOD_SKU);
    }

    @Test(expected = SkuNotFoundException.class)
    public void getPriceNonExistentSkuThrowsException() throws SkuNotFoundException {
        when(mockDataAccess.getPriceBySku(BAD_SKU)).thenReturn(null);
        final BigDecimal price = pricingService.getPrice(BAD_SKU);
    }

    @Test(expected = RuntimeException.class)
    public void getPriceDataAccessThrowsRuntimeException() throws SkuNotFoundException {
        when(mockDataAccess.getPriceBySku(GOOD_SKU)).thenThrow(new RuntimeException("Error crítico al acceder a datos."));
        final BigDecimal price = pricingService.getPrice(GOOD_SKU);
    }

}