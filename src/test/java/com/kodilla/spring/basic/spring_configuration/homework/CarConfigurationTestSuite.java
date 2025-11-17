package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarConfigurationTestSuite {

    @Autowired
    private SeasonProvider seasonProvider;

    private CarConfiguration carConfiguration; // nie mogę użyć beana, bo ręcznie wymuszam zmianę pory roku

    @BeforeEach
    public void setUp() {
        carConfiguration = new CarConfiguration(seasonProvider);
    }

    @Test
    public void shouldReturnCabrioInSummer() {
        seasonProvider.setForcedSeason("summer");
        Car car = carConfiguration.car();
        Assertions.assertEquals("Cabrio", car.getCarType());
    }

    @Test
    public void shouldReturnSUVInWinter() {
        seasonProvider.setForcedSeason("winter");
        Car car = carConfiguration.car();
        Assertions.assertEquals("SUV", car.getCarType());
    }

    @Test
    public void shouldReturnSedanInSpring() {
        seasonProvider.setForcedSeason("spring");
        Car car = carConfiguration.car();
        Assertions.assertEquals("Sedan", car.getCarType());
    }

    @Test
    public void shouldReturnSedanInAutumn() {
        seasonProvider.setForcedSeason("autumn");
        Car car = carConfiguration.car();
        Assertions.assertEquals("Sedan", car.getCarType());
    }

    // testy do świateł:

    @Test
    public void shouldTurnOnHeadlightsAtNight() {
        Assertions.assertTrue(carConfiguration.isHeadlightsOn(22));
        Assertions.assertTrue(carConfiguration.isHeadlightsOn(5));
    }

    @Test
    public void shouldTurnOffHeadlightsDuringDay() {
        Assertions.assertFalse(carConfiguration.isHeadlightsOn(10));
        Assertions.assertFalse(carConfiguration.isHeadlightsOn(7));
    }

    // test do SeasonProvider:

    @Test
    public void shouldThrowExceptionForUnknownSeason() {
        seasonProvider.setForcedSeason("hrhrhhew");
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carConfiguration.car();
        });
        Assertions.assertTrue(exception.getMessage().contains("Unknown season"));
    }
}