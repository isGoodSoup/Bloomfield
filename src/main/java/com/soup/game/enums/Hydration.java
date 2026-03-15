package com.soup.game.enums;

/**
 * Represents the hydration level of a crop.
 *
 * <p>Hydration affects crop growth and survival. Crops may
 * wither if hydration is too low, and grow faster or healthier
 * when hydration is higher.</p>
 *
 * <ul>
 *     <li>{@link #NONE} – crop is completely dry, will wither</li>
 *     <li>{@link #LOW} – minimal water</li>
 *     <li>{@link #MID} – moderate hydration</li>
 *     <li>{@link #HIGH} – well hydrated</li>
 *     <li>{@link #MAX} – fully saturated</li>
 * </ul>
 */
public enum Hydration {
    NONE, LOW, MID, HIGH, MAX
}