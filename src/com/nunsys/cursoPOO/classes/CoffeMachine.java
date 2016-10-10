package com.nunsys.cursoPOO.classes;

import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;
import com.nunsys.cursoPOO.interfaces.ICoffeeMachine;
import com.nunsys.cursoPOO.interfaces.IContainer;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public class CoffeMachine implements ICoffeeMachine {

    private IContainer coffeeContainer;
    private IContainer waterContainer;


    public CoffeMachine(int coffeeCapacity, int waterCapacity){
        coffeeContainer = new CoffeeContainer(coffeeCapacity);
        waterContainer = new WaterContainer(waterCapacity);
    }

    @Override
    public boolean makeCoffee(Portion portion) throws NotEnoughException {
        boolean isEnoughCoffee = coffeeContainer.getPortion(portion);
        boolean isEnoughWater = waterContainer.getPortion(portion);

        if (isEnoughCoffee && isEnoughWater) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public IContainer getCoffeeContainer() {
        return coffeeContainer;
    }

    @Override
    public IContainer getWaterContainer() {
        return waterContainer;
    }
}
