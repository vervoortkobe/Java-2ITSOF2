package meteo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TemperatureService {
    private List<Temperature> list;
    private int index;

    public TemperatureService() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public List<Temperature> getTemperatures() {
        return list;
    }

    public int getCurrentIndex() {
        return index;
    }

    public void setTemperatures(List<Temperature> list, int currentIndex) {
        this.list = list;
        this.index = currentIndex;
    }

    public List<Temperature> addTemperature(Location location, LocalDateTime time, Double value) {
        //check required
        if (location == null || time == null || value == null) {
            return null;
        }
        //check no temperature in the future
        if (time.isAfter(LocalDateTime.now())) {
            return null;
        }
        //check existing
        if (list.stream().anyMatch(p -> p.getLocation() == location && p.getTime().equals(time))) {
            //update with new value
            Temperature temperature = list.stream().filter(p -> p.getLocation() == location && p.getTime().equals(time)).findFirst().get();
            temperature.setValue(value);
        } else {
            //create new
            //increase index
            index++;
            //add new object to list
            list.add(new Temperature(index, location, time, value));
        }
        //return updated list
        return list;
    }

    public List<Temperature> deleteTemperature(int id) {
        //check existing
        if (list.stream().anyMatch(p -> p.getIndex() == id)) {
            //remove from list
            Temperature temperature = list.stream().filter(p -> p.getIndex() == id).findFirst().get();
            list.remove(temperature);
        }
        //return updated list
        return list;
    }

    public List<Temperature> getTemperaturesForLocation(Location location) {
        return list.stream().filter(p -> p.getLocation() == location).collect(Collectors.toList());
    }
}