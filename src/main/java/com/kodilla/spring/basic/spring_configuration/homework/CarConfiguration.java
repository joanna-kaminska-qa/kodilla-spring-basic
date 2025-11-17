package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class CarConfiguration {

    private final SeasonProvider seasonProvider;

    public CarConfiguration(SeasonProvider seasonProvider) {
        this.seasonProvider = seasonProvider;
    }

    @Bean
    public Car car() {
        String season = seasonProvider.getCurrentSeason();
        int currentHour = LocalTime.now().getHour();
        boolean headlightsOn = isHeadlightsOn(currentHour);

        switch (season.toLowerCase()) {
            case "summer":
                return new Cabrio(headlightsOn);
            case "winter":
                return new SUV(headlightsOn);
            case "spring":
            case "autumn":
                return new Sedan(headlightsOn);
            default:
                throw new IllegalArgumentException("Unknown season: " + season);
        }
    }

    boolean isHeadlightsOn(int hour) {
        return (hour >= 20 || hour < 6);
    }
}
