package com.soup.game.enums;

import com.soup.game.intf.Data;

import java.util.Random;

@Data
public enum CropID {
    WHEAT("Wheat", 8, 2),
    CORN("Corn", 16, 4),
    CARROT("Carrot", 8, 8),
    POTATO("Potato", 16, 16),
    TOMATO("Tomato", 16, 8),
    STRAWBERRY("Strawberry", 24, 16),
    APPLE("Apple", 32, 16),
    GRAPE("Grape", 16, 16),
    PUMPKIN("Pumpkin", 32, 24),
    CABBAGE("Cabbage", 8, 24);

    private static final Random random = new Random();
    private final String name;
    private final int yield;
    private final int days;

    CropID(String name, int yield, int days) {
        this.name = name;
        this.yield = yield;
        this.days = days;
    }

    public static CropID random() {
        return CropID.values()[random.nextInt(0, CropID.values().length - 1)];
    }
    public String getName() {
        return name;
    }
    public int getYield() {
        return yield;
    }
    public int getDays() {
        return days;
    }
}