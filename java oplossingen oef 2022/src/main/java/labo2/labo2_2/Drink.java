package labo2.labo2_2;

public abstract class Drink {
    double price;
    String name;

    public Drink(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
