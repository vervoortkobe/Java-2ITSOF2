package dice;

import java.util.Random;

public class Dice {
    private int pips = 6;

    public Dice(int pips) {
        this.pips = pips;
    }
    public int Roll() {
        Random random = new Random();
        return random.nextInt(pips);
    }
}
