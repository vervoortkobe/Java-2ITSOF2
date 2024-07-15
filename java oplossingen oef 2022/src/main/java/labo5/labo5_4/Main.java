package labo5.labo5_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int disks = Integer.parseInt(userInput.next());

        Tower tower = new Tower();

        tower.startTower(disks);
    }


}
