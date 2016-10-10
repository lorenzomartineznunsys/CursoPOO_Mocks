package com.nunsys.cursoPOO.interfaces;

import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public interface IContainer {

    public boolean getPortion(Portion portion) throws NotEnoughException;
    public int getCurrentVolume();
    public int getTotalVolume();
    public void refillContainer();

}
