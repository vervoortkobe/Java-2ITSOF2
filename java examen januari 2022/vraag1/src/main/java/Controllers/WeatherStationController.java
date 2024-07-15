package Controllers;

import dao.WeatherStationDAO;
import model.WeatherStation;

import java.util.List;
import java.util.Optional;

public class WeatherStationController {
    private WeatherStationDAO weatherStationDAO;

    public WeatherStationController() {
        this.weatherStationDAO = new WeatherStationDAO();
    }

    public List<WeatherStation> getWeatherStations() {
        return weatherStationDAO.getWeatherStations();
    }

    public Optional<WeatherStation> getWeatherStationById(int id) {
        return weatherStationDAO.getWeatherStationById(id);
    }

    public Optional<WeatherStation> getWeatherStationByName(String name) {
        return weatherStationDAO.getWeatherStationByName(name);
    }

    public void addWeatherStation(WeatherStation weatherStation) {
        weatherStationDAO.addWeatherStation(weatherStation);
    }

    public void addWeatherStation(String name) {
        weatherStationDAO.addWeatherStation(new WeatherStation(name));
    }

    public boolean exists(String name) {
        return weatherStationDAO.exists(name);
    }
}
