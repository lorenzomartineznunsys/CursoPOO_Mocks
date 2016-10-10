package com.nunsys.cursoPOO.interfaces;

import java.math.BigDecimal;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public interface DataAccess {
    BigDecimal getPriceBySku(String sku);
}
