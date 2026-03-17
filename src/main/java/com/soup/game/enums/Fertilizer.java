package com.soup.game.enums;

import com.soup.game.intf.Item;
import com.soup.game.service.Localization;

/**
 * Represents fertilizer types that can be applied to a farm tile.
 * <p>
 * Fertilizers are typically applied to a {@code Tile} and influence crop
 * behavior during the growth cycle.
 * </p>
 * <ul>
 *   <li>{@link #NONE} – no fertilizer applied.</li>
 *   <li>{@link #SPEED} – increases crop growth speed.</li>
 *   <li>{@link #YIELD} – improves the amount of harvested crops.</li>
 * </ul>
 *
 */
public enum Fertilizer implements Item {
    NONE(),
    SPEED(),
    YIELD();

    @Override public int value() { return 0; }
    @Override public String getName() { return Localization.lang.t("market.fertilizer"); }
}