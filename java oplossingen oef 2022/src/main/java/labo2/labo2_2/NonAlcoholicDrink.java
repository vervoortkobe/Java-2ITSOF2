package labo2.labo2_2;

public class NonAlcoholicDrink extends Drink {
    boolean hasSpark;

    public NonAlcoholicDrink(double price, String name, boolean hasSpark) {
        super(price, name);
        this.hasSpark = hasSpark;
    }

    @Override
    public String toString() {
        return "NonAlcoholicDrink{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", hasSpark=" + hasSpark +
                '}';
    }
}
