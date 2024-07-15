import meteo.Location;
import meteo.Temperature;
import meteo.TemperatureService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TemperatureServiceTest {
    @Test
    public void getTemperaturesEmpty() {
        TemperatureService temperatureService = new TemperatureService();
        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(0, result.size());
    }

    @Test
    public void getTemperaturesOne() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.now(), 20.0);

        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(1, result.size());
    }

    @Test
    public void getTemperaturesMany() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.now(), 20.0);
        temperatureService.addTemperature(Location.GENT, LocalDateTime.now(), 10.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.now(), 30.);

        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(3, result.size());
    }

    @Test
    public void addTemperaturePositive() {
        TemperatureService temperatureService = new TemperatureService();

        Temperature temperature = new Temperature(1, Location.ANTWERPEN, LocalDateTime.now(), 20.0);
        List<Temperature> result = temperatureService.addTemperature(temperature.getLocation(), temperature.getTime(), temperature.getValue());

        assertEquals(1, result.size());
        assertEquals(temperature.getLocation(), result.get(0).getLocation());
        assertEquals(temperature.getTime(), result.get(0).getTime());
        assertEquals(temperature.getValue(), result.get(0).getValue());
    }

    @Test
    public void addTemperatureExisting() {
        TemperatureService temperatureService = new TemperatureService();

        Temperature temperature = new Temperature(1, Location.ANTWERPEN, LocalDateTime.now(), 20.0);
        temperatureService.addTemperature(temperature.getLocation(), temperature.getTime(), temperature.getValue());

        temperature.setValue(30.0);
        List<Temperature> result = temperatureService.addTemperature(temperature.getLocation(), temperature.getTime(), temperature.getValue());

        assertEquals(1, result.size());
        assertEquals(temperature.getValue(), result.get(0).getValue());
    }

    @Test
    public void addTemperatureNegative() {
        TemperatureService temperatureService = new TemperatureService();

        Temperature temperature = new Temperature(1, Location.ANTWERPEN, LocalDateTime.of(LocalDate.of(2025, 1, 1), LocalTime.now()), 20.0);
        List<Temperature> result = temperatureService.addTemperature(temperature.getLocation(), temperature.getTime(), temperature.getValue());

        assertNull(result);
    }

    @Test
    public void deleteTemperatureAddOneDeleteOne() {
        TemperatureService temperatureService = new TemperatureService();

        Temperature added = temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.now(), 20.0).get(0);
        temperatureService.deleteTemperature(added.getIndex());

        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(0, result.size());
    }

    @Test
    public void deleteTemperatureAddNoneDeleteOne() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.deleteTemperature(0);
        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(0, result.size());
    }

    @Test
    public void deleteTemperatureAddManyDeleteNone() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.now(), 10.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.now(), 20.0);
        temperatureService.addTemperature(Location.GENT, LocalDateTime.now(), 30.0);

        temperatureService.deleteTemperature(-1);

        List<Temperature> result = temperatureService.getTemperatures();

        assertEquals(3, result.size());
    }

    @Test
    public void getTemperaturesForLocationOneLocation() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 0, 0)), 10.0);
        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 0, 0)), 20.0);
        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0, 0)), 30.0);

        List<Temperature> result = temperatureService.getTemperaturesForLocation(Location.ANTWERPEN);

        assertEquals(3, result.size());
    }

    @Test
    public void getTemperaturesForLocationManyLocations() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 0, 0)), 10.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 0, 0)), 20.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0, 0)), 30.0);

        List<Temperature> result = temperatureService.getTemperaturesForLocation(Location.BRUSSEL);

        assertEquals(2, result.size());
    }

    @Test
    public void getTemperaturesForLocationNoLocations() {
        TemperatureService temperatureService = new TemperatureService();

        temperatureService.addTemperature(Location.ANTWERPEN, LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 0, 0)), 10.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 0, 0)), 20.0);
        temperatureService.addTemperature(Location.BRUSSEL, LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0, 0)), 30.0);

        List<Temperature> result = temperatureService.getTemperaturesForLocation(Location.GENT);

        assertEquals(0, result.size());
    }
}
