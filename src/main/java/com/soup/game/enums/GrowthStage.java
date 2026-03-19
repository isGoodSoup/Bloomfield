package com.soup.game.enums;

/**
 * Represents the different stages of crop growth in the game.
 *
 * <p>The stages are sequential and describe the lifecycle of a crop:</p>
 * <ul>
 *     <li>{@link #SEED} – initial planted stage</li>
 *     <li>{@link #BUD} – early growth</li>
 *     <li>{@link #GROWING} – mid-growth phase</li>
 *     <li>{@link #MATURE} – fully grown but not yet harvestable</li>
 *     <li>{@link #HARVESTABLE} – ready to be harvested</li>
 * </ul>
 *
 * <p>This enum provides a utility method to advance a crop to its
 * next growth stage.</p>
 */
public enum GrowthStage {
    SEED, BUD, GROWING, MATURE, HARVESTABLE;

    /**
     * Returns the next stage in the growth lifecycle.
     *
     * <p>If the current stage is {@link #HARVESTABLE}, it returns
     * itself since it is the final stage.</p>
     * @return the next {@link GrowthStage} in sequence, or the same stage if already at final
     */
    public GrowthStage next(int steps) {
        if(Gamerule.isEnabled(Gamerule.ENABLE_STOP_TIME)) { return this; }
        int next = this.ordinal() + steps;
        if (next >= values().length) {
            return this;
        }
        return values()[next];
    }
}