package labo5.labo5_5;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }


    static int fibonacci(int number){

        if (number <= 1)
            return 1;

        return fibonacci(number - 1 ) + fibonacci(number - 2);
    }
}
