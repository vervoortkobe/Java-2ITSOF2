package labo6.labo6_2;

import labo6.labo6_2.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Object CSV_SEPARATOR = ';';

    static PizzaTool pizzaTool;

    private static List<PizzaClient> clients;
    private static PizzaClient currentClient;

    public static void main(String[] args) {
        clients = new ArrayList<PizzaClient>();
        pizzaTool = new PizzaTool();
        pizzaTool.importCsvData();
        startUIApp();
    }

    private static void startUIApp() {
        System.out.println("Welkom @ Java pizza's");
        askClient();

        boolean runApp = true;
        while (runApp) {
            int menuOption = getMenuOption();
            switch (menuOption) {
                case 1:
                    showFindPizza();
                    break;
                case 2:
                    showInspireMe();
                    break;
                case 3:
                    finishOrder();
                    switch (askNewClient()) {
                        case 1:
                            askClient();
                            break;
                        case 2:
                            WriteToCsv();
                            return;
                    }
                    break;
                case 4:
                    WriteToCsv();
                    return;
                default:
                    break;
            }
        }

    }

    private static void askClient() {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Wie helpen we vandaag?");
        System.out.print("Uw naam: ");
        String name = consoleInput.nextLine();
        System.out.println("Welkom :" + name);

        currentClient = new PizzaClient(name);

    }private static int askNewClient() {
        System.out.println("Wat wil u verder doen?");
        System.out.println("1. Plaats nieuwe bestelling");
        System.out.println("2. Sluit af");
        return getInput("Geef de nummer van uw keuze:");
    }

    private static void finishOrder() {

        System.out.println("Uw bestelling:");
        List<PizzaOrder> orders = currentClient.getOrders();
        Double price = 0d;
        for (PizzaOrder order : orders) {

            Double pizzaPrice = order.getPizza().getPrice();
            if (PizzaSize.LARGE.equals(order.getPizzaSize())) {
                pizzaPrice = pizzaPrice * 1.1d;
            }
            if (PizzaBottom.CHEESYCRUST.equals(order.getPizzaSize())) {
                pizzaPrice += 2;
            }
            System.out.println(String.format("%s - %s - %s - € %.2f", order.getPizza().getName(), order.getPizzaSize(),
                    order.getPizzaBottom(), pizzaPrice));
            price += pizzaPrice;
        }
        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, 30);
        currentClient.setTotalPrice(price);
        clients.add(currentClient);

        System.out.println(String.format("Beste %s uw bestelling komt op € %.2f en zal voor %02d:%02d geleverd worden.",
                currentClient.getName(), price, currentTimeNow.get(Calendar.HOUR_OF_DAY),
                currentTimeNow.get(Calendar.MINUTE)));
    }

    private static void showInspireMe() {
        List<String> ingredients = new ArrayList<String>(pizzaTool.getIngredients());
        String ingredient = askOptions(ingredients);
        askPizzaToOrder(pizzaTool.getPizzasWithIngredient(ingredient));
    }

    private static String askOptions(List<String> options) {
        int index = 1;
        for (String option : options) {
            System.out.println(index + ". " + option);
            index++;
        }
        int input = getInput("Geef de nummer van uw keuze:");

        return options.get(input - 1);
    }

    private static void showFindPizza() {
        int index = 1;

        System.out.println("In welke categorie wil u kiezen?");
        String cat = askOptions(new ArrayList<String>(pizzaTool.getCategories()));
        askPizzaToOrder(pizzaTool.getPizzasWithCat(cat));
    }

    private static void askPizzaToOrder(List<Pizza> pizzas) {
        int index = 1;

        System.out.println("In welke pizza wil u kiezen?");
        for (Pizza pizza : pizzas) {
            System.out.println(index + ". " + pizza.getName());
            index++;
        }
        int input = getInput("Geef de nummer van uw keuze:");

        Pizza pizzaToOrder = pizzas.get(input - 1);
        PizzaSize size = askSize();
        PizzaBottom bottom = askBottom(size);
        currentClient.addOrder(new PizzaOrder(pizzaToOrder, size, bottom));
        System.out.println(String.format("We have add a %s %s to your order!", size, pizzaToOrder.getName()));

    }

    private static PizzaSize askSize() {
        int index = 1;

        System.out.println("Hoe groot moet de pizza zijn?");
        PizzaSize[] options = PizzaSize.values();
        for (PizzaSize size : options) {
            System.out.println(index + ". " + size.toString());
            index++;
        }

        int input = getInput("Geef de nummer van uw keuze:");

        return options[input - 1];

    }

    private static PizzaBottom askBottom(PizzaSize size) {
        int index = 1;

        System.out.println("Welke bodem moet de pizza hebben?");
        PizzaBottom[] options = PizzaBottom.values();
        for (PizzaBottom bottom : options) {
            if (PizzaBottom.CHEESYCRUST.equals(bottom) && !PizzaSize.LARGE.equals(size)) {
                continue;
            }
            System.out.println(index + ". " + bottom.toString());
            index++;
        }

        int input = getInput("Geef de nummer van uw keuze:");

        return options[input - 1];

    }

    private static int getMenuOption() {
        System.out.println("Hoe kunnen we u helpen bij uw bestelling?");
        System.out.println("1. Zoek een pizza");
        System.out.println("2. Inspireer mij");
        System.out.println("3. Plaats bestelling");
        System.out.println("4. Sluit af");
        return getInput("Geef de nummer van uw keuze:");
    }

    private static int getInput(String question) {
        System.out.print(question);
        Scanner consoleInput = new Scanner(System.in);
        return consoleInput.nextInt();
    }

    public static void WriteToCsv() {
        System.out.println("Saving orders ...");
        File csvOutputFile = new File("src/main/resources/pizza-orders.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            clients.stream().forEach(c -> {
                System.out.println(c);
                pw.print(String.format("%2$s %1$s € %3$.2f %1$s %4$s", CSV_SEPARATOR,c.getName(),c.getTotalPrice(),c.getOrders()));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Orders Saved!");

    }
}