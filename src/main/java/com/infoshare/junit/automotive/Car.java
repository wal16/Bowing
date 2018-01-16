package com.infoshare.junit.automotive;

public interface Car {
    EmissionLevel measurePollution();

    void ignite();

    void stop();

    Boolean isRunning();

}