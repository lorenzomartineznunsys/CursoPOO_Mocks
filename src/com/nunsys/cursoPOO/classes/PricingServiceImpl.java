package com.nunsys.cursoPOO.classes;

import com.nunsys.cursoPOO.exceptions.SkuNotFoundException;
import com.nunsys.cursoPOO.interfaces.DataAccess;
import com.nunsys.cursoPOO.interfaces.PricingService;

import java.math.BigDecimal;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public class PricingServiceImpl implements PricingService {

    private DataAccess dataAccess;

    @Override
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public BigDecimal getPrice(String sku) throws SkuNotFoundException {
        BigDecimal price = dataAccess.getPriceBySku(sku);
        if (null == price){
            throw new SkuNotFoundException("No se ha encontrado el SKU");
        }
        return price;
    }
}
