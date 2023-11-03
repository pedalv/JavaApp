package no.agitec.fagaften.mars.kotlin.section05.oochallenge.javacode;

import lombok.Data;

import java.util.Objects;

public @Data class BicycleLombok {
    private final int cadence;
    private final int gear;
    private final int speed;
}

class BicycleJava {

    private final int cadence;
    private final int gear;
    private final int speed;

    @Override
    public String toString() {
        return "BicycleJava{" +
                "cadence=" + cadence +
                ", gear=" + gear +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BicycleJava)) return false;
        BicycleJava that = (BicycleJava) o;
        return getCadence() == that.getCadence() &&
                getGear() == that.getGear() &&
                getSpeed() == that.getSpeed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCadence(), getGear(), getSpeed());
    }

    public BicycleJava(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
    }

    public int getCadence() {
        return cadence;
    }

    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }
}