package labo2.labo2_1;

public class AlcoholicDrink extends Drink{
    double alcoholPercentage;

    public AlcoholicDrink(double price, String name, double alcoholPercentage) {
        super(price, name);
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public String toString() {
        return "AlcoholicDrink{" +
                "alcoholPercentage=" + alcoholPercentage +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
