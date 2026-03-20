package com.soup.game.world;

import com.soup.game.intf.Data;

/**
 * Represents a single selectable option within an interactive, choice-driven menu.
 * <p>
 * A {@code Choice} encapsulates:
 * <ul>
 *     <li>A selection key (e.g. "A", "B", "C") used for user input</li>
 *     <li>A localization key used to render the display text</li>
 *     <li>An executable action triggered when the choice is selected</li>
 * </ul>
 * </p>
 *
 * <p>
 * The {@code text} field is expected to be a localization key resolved via
 * {@link com.soup.game.service.Localization}, not a raw display string.
 * </p>
 *
 * <p>
 * This abstraction enables a flexible, data-driven interaction system suitable for
 * roguelike-style menus, dialogues, and contextual actions.
 * </p>
 *
 * @param key the user input key used to select this choice (case-insensitive)
 * @param text the localization key representing the display text for this choice
 * @param action the action executed when the choice is selected
 */
@Data
public record Choice(String key, String text, Runnable action) {
    /**
     * Executes the action associated with this choice.
     * <p>
     * This method delegates directly to the underlying {@link Runnable}.
     * It is typically invoked after validating user input against {@link #key()}.
     * </p>
     */
    public void execute() {
        action.run();
    }
}
