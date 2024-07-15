package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="PREDICTIONS")
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinTable(name="PREDICTIONS_WEATHERSTATIONS")
    private WeatherStation weatherStation;
    @Column(name="date")
    private LocalDate date;
    @Column(name="minimumTemperature")
    private double mininumTemperature;
    @Column(name="averageTemperature")
    private double averageTemperature;
    @Column(name="maxTemperature")
    private double maxTemperature;
    @Column(name="rainFall")
    private double rainFall;
    @Column(name="windDirection")
    private int windDirection;
    @Column(name="windSpeed")
    private double windSpeed;
    @Column(name="airPressure")
    private double airPressure;

    public Prediction() {}

    public Prediction(WeatherStation weatherStation, LocalDate date, double mininumTemperature, double averageTemperature, double maxTemperature, double rainFall, int windDirection, double windSpeed, double airPressure) {
        this.weatherStation = weatherStation;
        this.date = date;
        this.mininumTemperature = mininumTemperature;
        this.averageTemperature = averageTemperature;
        this.maxTemperature = maxTemperature;
        this.rainFall = rainFall;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.airPressure = airPressure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeatherStation getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public String getWindSpeedString() {
        if(this.windSpeed < 1)
            return "windstil";
        if(this.windSpeed < 12)
            return "zwakke wind";
        if(this.windSpeed < 28)
            return "matige wind";
        if(this.windSpeed < 50)
            return "krachtige wind";
        return "storm";
    }

    @Override
    public String toString() {
        return this.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" - "
                +this.getWeatherStation().getName()+" - "
                +this.getAverageTemperature()+" - "
                +this.getWindSpeedString();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMininumTemperature() {
        return mininumTemperature;
    }

    public void setMininumTemperature(double mininumTemperature) {
        this.mininumTemperature = mininumTemperature;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getRainFall() {
        return rainFall;
    }

    public void setRainFall(double rainFall) {
        this.rainFall = rainFall;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }
}
