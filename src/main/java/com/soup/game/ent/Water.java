package com.soup.game.ent;

import com.soup.game.intf.Entity;
import com.soup.game.intf.Item;
import com.soup.game.service.Localization;

@Entity
public class Water implements Item {
    private final String name;
    private final int value = 5000;

    public Water(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return Localization.lang.t(name);
    }

    @Override
    public int getValue() {
        return value;
    }
}
