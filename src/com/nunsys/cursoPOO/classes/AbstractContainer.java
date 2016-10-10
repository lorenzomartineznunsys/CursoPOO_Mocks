package com.nunsys.cursoPOO.classes;

import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;
import com.nunsys.cursoPOO.interfaces.IContainer;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public abstract class AbstractContainer implements IContainer {

    private int containerTotalVolume;
    private int currentVolume;

    public AbstractContainer(int volume) {
        if (volume < 1)
            throw new IllegalArgumentException("La capacidad del contenedor debe ser mayor que 0.");
        containerTotalVolume = volume;
        currentVolume = volume;
    }

    @Override
    public boolean getPortion(Portion portion) throws NotEnoughException {
        int delta = currentVolume - portion.size();
        if (delta > -1) {
            currentVolume -= portion.size();
            return true;
        } else
            throw new NotEnoughException("Rellene el " + this.getClass().getName());
    }

    @Override
    public int getCurrentVolume() {
        return currentVolume;
    }

    @Override
    public int getTotalVolume() {
        return containerTotalVolume;
    }

    @Override
    public void refillContainer() {
        currentVolume = containerTotalVolume;
    }

}
