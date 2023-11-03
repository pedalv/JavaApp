package no.insurance.helper;

/**
 * Created by p on 21/10/2016.
 */
public enum State {
    SEND(1),
    PAY(2),
    CANCEL(3),
    ACTIVE(4),
    INACTIVE(5),
    PENDING(6);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
