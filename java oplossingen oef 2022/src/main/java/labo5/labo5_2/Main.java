package labo5.labo5_2;

public class Main {
    public static void main(String[] args) {

        countdownRocket(10);
    }

    static void countdownRocket(int len){

        if(len == 0){
            System.out.println("Take Off");
            return;
        }

        System.out.println(len);
        countdownRocket(len - 1);

    }
}
