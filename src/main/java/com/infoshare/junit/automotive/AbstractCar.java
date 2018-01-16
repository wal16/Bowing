package com.infoshare.junit.automotive;

public abstract class AbstractCar implements Car {
    Boolean isRunning = false;
    EmissionLevel emissionLevel = EmissionLevel.NORMAL;

    @Override
    public Boolean isRunning() {
        return isRunning;
    }

    @Override
    public void ignite() {
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    EmissionLevel getCurrentEmissionLevel() {
        return emissionLevel;
    }

    @Override
    public EmissionLevel measurePollution() {
        if (!isRunning) {
            return EmissionLevel.NONE;
        }
        return getCurrentEmissionLevel();
    }

}