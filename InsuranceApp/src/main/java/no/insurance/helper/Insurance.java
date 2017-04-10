package no.insurance.helper;

/**
 * Created by p on 21/10/2016.
 */
public enum Insurance {
    HOME(1),
    CAR(2),
    THING(3),
    MOTOCYCLE(4),
    BOAT(5),
    TRAVEL(6),
    HEALTHCARE(7);

    private int value;

    Insurance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}