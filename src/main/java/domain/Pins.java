package domain;

public class Pins {
    private static final int MAX = 10;
    private static final int MIN = 0;

    private final int currentPins;

    private Pins(int currentPins) {
        this.currentPins = currentPins;
    }

    public static Pins init() {
        return new Pins(MAX);
    }

    public Pins knockDown(int countOfDownPins) {
        if (currentPins < countOfDownPins || countOfDownPins < MIN) {
            throw new IllegalArgumentException();
        }
        return new Pins(currentPins - countOfDownPins);
    }

    public int getCurrentPins() {
        return currentPins;
    }
}
