import DAO.CarDAO;
import Entity.Car;
import Entity.CarType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    private static CarDAO carDAO;

    public static void main(String[] args) {
        carDAO = new CarDAO();
        initiateMenu();
    }

    private static void initiateMenu(){
        boolean showMenu = true;
        while (showMenu){
            System.out.println("Options: ");
            System.out.println("1. Add a car");
            System.out.println("2. Show inventory");
            System.out.println("3. Exit");
            int choice = Integer.parseInt(getInput("Enter your choice: "));

            switch (choice){
                case 1:
                    System.out.println("You chose to add a car");
                    Car car = new Car(askCarBrand(), askCarModel(), askCarRegistrationDate(), askCarType(), askCarPrice());
                    carDAO.addCar(car);
                    break;
                case 2:
                    System.out.println("You chose to show inventory");
                    displayInventory();
                    break;
                case 3:
                    System.out.println("Closing program...");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }

    private static void displayInventory(){
        List<Car> cars = carDAO.getCars();

        String input = getInput("Sort by firstRegisteryDate or purchasePrice: ");
        if (input.equals("firstRegisteryDate")) {
            cars.sort((o1, o2) -> o1.getFirstRegisteryDate().compareTo(o2.getFirstRegisteryDate()));
        }
        else if (input.equals("purchasePrice")) {
            cars.sort((o1, o2) -> Double.compare(o1.getCarPrice(), o2.getCarPrice()));
        }
        cars.forEach(System.out::println);
        System.out.println("Total car value: " + cars.stream().mapToDouble(Car::getCarPrice).sum());

    }

    private static String getInput(String question) {
        System.out.print(question);
        Scanner consoleInput = new Scanner(System.in);
        return consoleInput.nextLine();
    }


    private static String askCarBrand() {

        do {
            String brand = getInput("Enter car brand: ");
            if (brand.length() > 0) {
                return brand;
            }
        } while (true);
    }
    private static String askCarModel() {

        do {
            String model = getInput("Enter car model: ");
            if (model.length() > 0) {
                return model;

            }
        } while (true);
    }
    private static LocalDate askCarRegistrationDate() {
        do {
            String date = getInput("Enter car registration date (yyyy-mm-dd): ");
            try {
                return LocalDate.parse(date);
            }
            catch (Exception e) {
                System.out.println("Invalid date format");
            }
        } while (true);
    }
    private static CarType askCarType() {
        do {
            String type = getInput("Enter car type (SUV, BREAK, SEDAN, HATCHBACK, SPORT): ");
            try {
                return CarType.valueOf(type);
            }
            catch (Exception e) {
                System.out.println("Invalid car type");
            }
        } while (true);
    }
    private static double askCarPrice() {
        do {
            String price = getInput("Enter car price: ");
            try {
                return Double.parseDouble(price);
            }
            catch (Exception e) {
                System.out.println("Invalid price");
            }
        } while (true);
    }

}
