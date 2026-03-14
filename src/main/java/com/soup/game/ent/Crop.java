package com.soup.game.ent;

import com.soup.game.enums.CropID;
import com.soup.game.intf.Entity;

@Entity(type = "crop")
public final class Crop {
    private final CropID id;
    private final int daysToMature;
    private int days;
    private boolean canHarvest;

    public Crop(CropID id) {
        this.id = id;
        this.daysToMature = id.getDays();
        this.days = 0;
    }

    public void grow() {
        if(!canHarvest) {
            days++;
            if(days == daysToMature) canHarvest = true;
        }
    }

    public boolean canHarvest() {
        return canHarvest;
    }
    public CropID getId() {
        return id;
    }
}
