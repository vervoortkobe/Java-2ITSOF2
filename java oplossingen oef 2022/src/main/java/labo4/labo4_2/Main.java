package labo4.labo4_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String originalString = "Dit is een String";

        System.out.println(method1(originalString));
        System.out.println(method2(originalString));
        System.out.println(method3(originalString));
        System.out.println(method4(originalString));
        System.out.println(method5(originalString));

    }
    //1. Bouw een andere string met een loop
    public static String method1(String input) {
        String returnString = "";
        char character;
        for (int i = 0; i<input.length(); i++) {
            character= input.charAt(i);
            returnString= character + returnString;
        }
        return returnString;
    }



    //2. Gebruiken een array van Char
    public static String method2(String input){
        char[] charArray = input.toCharArray();
        String returnString = "";
        for (int i = charArray.length - 1; i >= 0; i--)
            returnString += charArray[i];

        return returnString;
    }
    //3. Gebruik de StringUtils
    public static String method3(String input){
        StringBuilder returnString = new StringBuilder();

        returnString.append(input);
        returnString.reverse();

        return returnString.toString();
    }
    //4. byte array
    public static String method4(String input){
        byte[] strAsByteArray = input.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        return new String(result);
    }
    //5. recursive
    public static String method5(String input){
        if(input.length() == 1)
            return input;

        return input.charAt(input.length()-1) + method5(input.substring(0, input.length()-1));
    }
}
