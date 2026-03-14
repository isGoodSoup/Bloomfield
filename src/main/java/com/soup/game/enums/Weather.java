package com.soup.game.enums;

import com.soup.game.service.Localization;

import java.util.Random;

public enum Weather {
    DRY("weather.dry.message"),
    SUNNY("weather.sunny.message"),
    CLOUDY("weather.cloudy.message"),
    RAIN("weather.rain.message"),
    STORM("weather.storm.message");

    private static final Random random = new Random();
    private final String message;

    Weather(String message) {
        this.message = message;
    }

    public String message() {
        return Localization.lang.t(message);
    }

    public static Weather getRandomWeather() {
        return Weather.values()[random.nextInt(0, Weather.values().length - 1)];
    }
}
