package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.stereotype.Component;

@Component
public class SeasonProvider {

    private String forcedSeason = null;

    public String getCurrentSeason() {
        if (forcedSeason != null) {
            return forcedSeason;
        }
        int month = java.time.LocalDate.now().getMonthValue();

        if (month == 12 || month == 1 || month == 2) {
            return "winter";
        } else if (month >= 3 && month <= 5) {
            return "spring";
        } else if (month >= 6 && month <= 8) {
            return "summer";
        } else {
            return "autumn";
        }
    }

    public void setForcedSeason(String forcedSeason) {
        this.forcedSeason = forcedSeason;
    }
}
