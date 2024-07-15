package labo2.labo2_1;

public class Bar {
    public static void main(String[] args){
        Drink water = new Drink(1.5 , "water");
        AlcoholicDrink whiskey = new AlcoholicDrink(19.99, "whiskey", 7.4);
        NonAlcoholicDrink cola = new NonAlcoholicDrink(2.3, "cola", true);

        System.out.println(water);
        System.out.println(whiskey);
        System.out.println(cola);
    }
}
