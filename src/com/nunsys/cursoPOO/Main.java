package com.nunsys.cursoPOO;

import com.nunsys.cursoPOO.classes.CoffeMachine;
import com.nunsys.cursoPOO.enums.Portion;
import com.nunsys.cursoPOO.exceptions.NotEnoughException;
import com.nunsys.cursoPOO.interfaces.ICoffeeMachine;

public class Main {

    public static void main(String[] args) {

        ICoffeeMachine coffeeMachine = new CoffeMachine(10, 10);
        ShowCoffeeMachineStatus(coffeeMachine);

        while(true){
            try {
                coffeeMachine.makeCoffee(Portion.LARGE);
                ShowCoffeeMachineStatus(coffeeMachine);
            } catch (NotEnoughException e) {
                System.out.println("Se acabó...");
                break;
            }
        }

    }

    private static void ShowCoffeeMachineStatus(ICoffeeMachine coffeeMachine) {
        System.out.println("Máquina de café");
        System.out.println("=====================================");
        System.out.println("Contenedor de agua: " + coffeeMachine.getWaterContainer().getCurrentVolume()+ " litros");
        System.out.println("Contenedor de café: " + coffeeMachine.getCoffeeContainer().getCurrentVolume()+ " porciones");
        System.out.println("=====================================");
    }
}
