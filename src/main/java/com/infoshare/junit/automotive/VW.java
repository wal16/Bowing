package com.infoshare.junit.automotive;

public class VW extends AbstractCar {
    private boolean labMode = true;

    public void setLabMode(Boolean value) {
        labMode = value;
    }

    @Override
    public EmissionLevel getCurrentEmissionLevel() {
        return labMode ? EmissionLevel.NORMAL : EmissionLevel.HIGH;
    }

}

