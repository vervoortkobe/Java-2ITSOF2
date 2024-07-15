package services;

import Controllers.PredictionController;
import Controllers.WeatherStationController;
import model.Prediction;
import model.WeatherStation;

import java.util.List;
import java.util.Optional;

public class WeatherAppService {
    private PredictionController predictions;
    private WeatherStationController weatherStations;

    public WeatherAppService() {
        this.predictions = new PredictionController();
        this.weatherStations = new WeatherStationController();
    }

    /* PREDICTIONS */
    public List<Prediction> getPredictions() {
        return predictions.getPredictions();
    }

    public Optional<Prediction> getPredictionById(int id) {
        return predictions.getPredictionById(id);
    }

    public void addPrediction(Prediction prediction) {
        predictions.addPrediction(prediction);
    }


    /* WEATHER STATIONS */
    public List<WeatherStation> getWeatherStations() {
        return weatherStations.getWeatherStations();
    }

    public Optional<WeatherStation> getWeatherStationById(int id) {
        return weatherStations.getWeatherStationById(id);
    }

    public Optional<WeatherStation> getWeatherStationByName(String name) {
        return weatherStations.getWeatherStationByName(name);
    }

    public void addWeatherStation(WeatherStation weatherStation) {
        weatherStations.addWeatherStation(weatherStation);
    }

    public void addWeatherStation(String name) {
        weatherStations.addWeatherStation(new WeatherStation(name));
    }

    public boolean weatherStationExists(String name) {
        return weatherStations.exists(name);
    }
}
