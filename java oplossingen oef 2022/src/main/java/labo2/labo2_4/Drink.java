package labo2.labo2_4;

public abstract class Drink implements Comparable<Drink>{
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

    @Override
    public int compareTo(Drink o) {
        if (o.price<this.price){
            return 1;
        }
        else {
            return -1;
        }
    }
}
