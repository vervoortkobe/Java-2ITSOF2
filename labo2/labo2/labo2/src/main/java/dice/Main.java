package dice;

public class Main {
    public static void main(String[] args) {

        Dice dice = new Dice(6);
        StringBuilder rolled = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            rolled.append(dice.Roll());
        }

        System.out.println("Numbers rolled: " + rolled +
                "\nSixes?: " + Sixes(rolled.toString()) +
                "\nNumbers?: " + Numbers(rolled.toString()) +
                "\nSequence?: " + Sequence(rolled.toString())
        );
    }
    public static boolean Sixes(String rolled) {
        if(rolled == "66666") return true;
        return false;
    }
    public static boolean Numbers(String rolled) {
        for (int i = 0; i < rolled.length(); i++) {
            if(i == rolled.length()) return true;
            if(rolled.charAt(i) != rolled.charAt(i + 1)) break;
        }
        return false;
    }
    public static boolean Sequence(String rolled) {
        for (int i = 0; i < rolled.length(); i++) {
            if(i == rolled.length()) return true;
            if(i < +rolled.charAt(i + 1) || +rolled.charAt(i) + 1 == +rolled.charAt(i + 1)) break;
        }
        return false;
    }
}
