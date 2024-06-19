package gcd;

public class Main {
    public static void main(String[] args) {
        System.out.println(gcd(15, 20));
    }
    public static int gcd(int getal1, int getal2) {
        /*int gcd = 1;
        for(int i = 1; i <= getal1 && i <= getal2; i++) if(getal1 % i == 0 && getal2 % i == 0) gcd = i;
        return gcd;*/
        if (getal1 == 0) return getal2;
        return gcd(getal2 % getal1, getal1);
    }
}
