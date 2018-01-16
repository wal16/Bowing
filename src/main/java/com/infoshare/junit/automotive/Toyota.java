package com.infoshare.junit.automotive;

public class Toyota extends AbstractCar {
    @Override
    public EmissionLevel getCurrentEmissionLevel() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return EmissionLevel.NORMAL;
    }
}

