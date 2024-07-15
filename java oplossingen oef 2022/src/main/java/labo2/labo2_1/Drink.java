package labo2.labo2_1;

public class Drink {
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
