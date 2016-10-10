package com.nunsys.cursoPOO.interfaces;

import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public interface ICoffeeMachine {

    public boolean makeCoffee(Portion portion) throws NotEnoughException;
    public IContainer getCoffeeContainer();
    public IContainer getWaterContainer();

}
