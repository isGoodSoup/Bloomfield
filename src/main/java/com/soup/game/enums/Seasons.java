package com.soup.game.enums;

import com.soup.game.service.Localization;

public enum Seasons {
    WINTER("game.season.winter"),
    SPRING("game.season.spring"),
    SUMMER("game.season.summer"),
    AUTUMN("game.season.autumn");

    private final String key;

    Seasons(String key) {
        this.key = key;
    }

    public Seasons next() {
        int next = this.ordinal() + 1;
        if (next >= values().length) {
            return this;
        }
        return values()[next];
    }

    public String getKey() {
        return Localization.lang.t(key);
    }
}
