package labo2.labo2_3;

import java.util.ArrayList;

public class Bar {
    public static void main(String[] args){
        //Drink water = new Drink(1.5 , "water"); This now doesn't work because Drink is abstract
        AlcoholicDrink whiskey = new AlcoholicDrink(19.99, "whiskey", 7.4);
        NonAlcoholicDrink cola = new NonAlcoholicDrink(2.3, "cola", true);

        ArrayList<Drink> drinkList = new ArrayList<Drink>();
        drinkList.add(whiskey);
        drinkList.add(cola);


        for (Drink drink : drinkList){
            System.out.println(drink.toString());
        }
    }
}
