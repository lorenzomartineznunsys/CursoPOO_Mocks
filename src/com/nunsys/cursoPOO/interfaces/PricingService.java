package com.nunsys.cursoPOO.interfaces;

import com.nunsys.cursoPOO.exceptions.SkuNotFoundException;

import java.math.BigDecimal;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public interface PricingService {
    void setDataAccess(DataAccess dataAccess);
    BigDecimal getPrice(String sku) throws SkuNotFoundException;

}
