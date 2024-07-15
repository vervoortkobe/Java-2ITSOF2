import exceptions.InvalidWeatherStationException;
import model.Prediction;
import services.WeatherAppService;
import sorters.SortByDate;
import sorters.SortByDateAndWeatherStation;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleApp {
    public static void main(String[] args) {
        WeatherAppService app = new WeatherAppService();
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            showMenu();
            input = scanner.nextInt();
            scanner.nextLine();

            String name;
            switch(input) {
                case 1: // Add weatherstation
                    System.out.println("Geef de naam van het weerstation");
                    name = scanner.nextLine().trim();

                    if(app.weatherStationExists(name)) {
                        throw new InvalidWeatherStationException("Weather station already exists!");
                    } else {
                        app.addWeatherStation(name);
                    }
                    break;
                case 2: // Load predictions
                    System.out.println("Geef de naam van het weerstation");
                    name = scanner.nextLine().trim();

                    File file = new File("src/main/resources/"+name.toLowerCase()+".csv");
                    if(!file.exists() || !app.weatherStationExists(name)) {
                        throw new InvalidWeatherStationException("Weather station does not exist!");
                    } else {
                        app.getWeatherStationByName(name).ifPresent(e -> {
                            try {
                                Files.lines(file.toPath())
                                        .skip(1)
                                        .forEach(f -> {
                                            String[] lines = f.split(";");
                                            LocalDate date = LocalDate.parse(lines[0]);
                                            double tavg = 0; if(!lines[1].equals("")) tavg = Double.parseDouble(lines[1].replaceAll(",","."));
                                            double tmin = 0; if(!lines[2].equals("")) tmin = Double.parseDouble(lines[2].replaceAll(",","."));
                                            double tmax = 0; if(!lines[3].equals("")) tmax = Double.parseDouble(lines[3].replaceAll(",","."));
                                            double prcp = 0; if(!lines[4].equals("")) prcp = Double.parseDouble(lines[4].replaceAll(",","."));
                                            int wdir = 0; if(!lines[5].equals("")) wdir = Integer.parseInt(lines[5]);
                                            double wspd = 0; if(!lines[6].equals("")) wspd = Double.parseDouble(lines[6].replaceAll(",","."));
                                            double pres = 0; if(!lines[7].equals("")) pres = Double.parseDouble(lines[7].replaceAll(",","."));

                                            Prediction prediction = new Prediction(e, date, tmin, tavg, tmax, prcp, wdir, wspd, pres);
                                            app.addPrediction(prediction);
                                        });
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        });
                    }

                    break;
                case 3: // Show predictions
                    System.out.println("Datum - Weerstation - Gemiddelde temperatuur - Windkracht");
                    app.getPredictions().stream()
                            .sorted(new SortByDateAndWeatherStation())
                            .forEach(System.out::println);
                    break;
                case 4: // Show summerdays
                    List<String> predictions = app.getPredictions().stream()
                            .filter(e -> e.getMaxTemperature() >= 25)
                            .filter(e -> e.getWeatherStation().getName().toLowerCase().equals("ukkel"))
                            .sorted(new SortByDate())
                            .map(e -> e.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" - "+e.getMaxTemperature()+" - "+e.getRainFall())
                            .collect(Collectors.toList());
                    predictions.add(0, "Datum - Maximum temperatuur - Neerslag");
                    File towrite = new File("src/main/resources/zomerdagen.txt");
                    try {
                        Files.write(towrite.toPath(), predictions);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:

                    break;
            }
        } while(input != 5);
        System.out.println("Tot de volgende keer!");
    }

    private static void showMenu() {
        System.out.println("===========================");
        System.out.println("   Welkom bij de weerapp   ");
        System.out.println("===========================");
        System.out.println();
        System.out.println("Maak uw keuze: ");
        System.out.println("1. Voeg weerstation toe");
        System.out.println("2. Laad voorspellingen op");
        System.out.println("3. Toon voorspellingen");
        System.out.println("4. Rapportering zomerdagen");
        System.out.println("5. Einde");
    }
}
