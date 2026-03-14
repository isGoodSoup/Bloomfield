package com.soup.game.enums;

import com.soup.game.intf.Data;
import com.soup.game.service.Localization;

import java.util.Random;

@Data
public enum CropID {
    WHEAT("crop.wheat", 8, 2, 4),
    CABBAGE("crop.cabbage", 8, 24, 6),
    CORN("crop.corn", 16, 4, 6),
    CARROT("crop.carrot", 8, 8, 10),
    POTATO("crop.potato", 16, 16, 12),
    TOMATO("crop.tomato", 16, 8, 12),
    STRAWBERRY("crop.strawberry", 24, 16, 16),
    APPLE("crop.apple", 32, 16, 16),
    GRAPE("crop.grape", 16, 16, 24),
    PUMPKIN("crop.pumpkin", 32, 24, 32);

    private static final Random random = new Random();
    private final String name;
    private final int yield;
    private final int days;
    private final int value;

    CropID(String name, int yield, int days, int value) {
        this.name = name;
        this.yield = yield;
        this.days = days;
        this.value = value;
    }

    public static CropID random() {
        return CropID.values()[random.nextInt(0, CropID.values().length - 1)];
    }
    public String getName() {
        return Localization.lang.t(name);
    }
    public int getYield() {
        return yield;
    }
    public int getDays() {
        return days;
    }
    public int getValue() {
        return value;
    }
}