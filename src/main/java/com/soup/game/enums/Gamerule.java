package com.soup.game.enums;

public enum Gamerule {
    ENABLE_CHEATS("doEnableCheats", false),
    ENABLE_MARKET("doEnableMarket", true),
    ENABLE_BREEDING("doEnableBreeding", true),
    ENABLE_LEVEL_UP("doEnableLevelUp", true),
    ENABLE_EXPERIENCE("doEnableExperienceGain", true),
    ENABLE_WEATHER_CYCLE("doEnableWeatherCycle", true),
    ENABLE_STOP_TIME("doEnableStopTime", false),
    ENABLE_TUTORIAL("doEnableTutorial", true);

    public final static Gamerule rule = Gamerule.ENABLE_TUTORIAL;
    private final String key;
    private boolean value;

    Gamerule(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    public Gamerule keyOf(String str) {
        if(str.equalsIgnoreCase(key)) {
            return this;
        }
        return null;
    }

    public String key() {
        return key;
    }

    public boolean value() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
