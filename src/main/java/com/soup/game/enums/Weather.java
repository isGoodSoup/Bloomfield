package com.soup.game.enums;

import com.soup.game.service.Localization;

import java.util.Random;

/**
 * Represents the different weather conditions in the game.
 *
 * <p>Weather can affect crop growth, hydration, and other
 * farm dynamics. Each weather type has a localized message
 * describing it.</p>
 *
 * <ul>
 *     <li>{@link #DRY} – extremely dry conditions</li>
 *     <li>{@link #SUNNY} – normal sunny day</li>
 *     <li>{@link #CLOUDY} – overcast day</li>
 *     <li>{@link #RAIN} – rainy weather, hydrates crops</li>
 *     <li>{@link #STORM} – severe storm, may damage crops</li>
 * </ul>
 */
public enum Weather {
    DRY("weather.dry.message"),
    SUNNY("weather.sunny.message"),
    CLOUDY("weather.cloudy.message"),
    RAIN("weather.rain.message"),
    STORM("weather.storm.message");

    private static final Random random = new Random();
    private final String message;

    /**
     * Constructor for Weather enum.
     * @param message localization key for the weather description
     */
    Weather(String message) {
        this.message = message;
    }

    /**
     * Returns the localized message describing this weather.
     * @return localized weather message
     */
    public String message() {
        return Localization.lang.t(message);
    }

    /**
     * Returns a random weather condition.
     * @return a randomly selected {@link Weather} value
     */
    public static Weather getRandomWeather() {
        return Weather.values()[random.nextInt(0, Weather.values().length - 1)];
    }
}