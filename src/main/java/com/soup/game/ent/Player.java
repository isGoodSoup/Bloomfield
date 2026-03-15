package com.soup.game.ent;

import com.soup.game.intf.Entity;
import com.soup.game.service.Inventory;
import com.soup.game.service.Localization;

import java.nio.file.Paths;

/**
 * Represents the player in the game, including their level, experience, and inventory.
 * <p>
 * The Player class tracks the player's progression through experience points and levels.
 * It also maintains an Inventory object that holds all items the player has acquired.
 * </p>
 */
@Entity(type = "player")
public class Player {
    private final String title;
    private final String name;
    private final Inventory inventory;
    private int level;
    private int experience;
    private int nextLevel;

    /**
     * Constructs a new Player with default values.
     * Initializes the inventory, sets the level to 1, and experience to 0.
     */
    public Player() {
        this.name = Paths.get(System.getProperty("user.home"))
                .getFileName().toString();
        title = Localization.lang.t("game.farm.title", name,
                Localization.lang.t("game.farm"));
        this.inventory = new Inventory();
        this.level = 1;
        this.experience = 0;
        this.nextLevel = 0;
    }

    /**
     * Returns a String "name" based on the PC's home username
     * @return the player
     */
    public String name() {
        return name;
    }

    /**
     * Returns the built-in title customized with the player's name
     * @return title of the farm
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the player's inventory.
     * @return the Inventory object associated with the player
     */
    public Inventory getInv() {
        return inventory;
    }

    /**
     * Returns the player's current level.
     * @return the level of the player
     */
    public int getLevel() {
        return level;
    }

    /**
     * Increases the player's level by one.
     * <p>
     * Typically called when the player's experience reaches or exceeds
     * the threshold for the next level.
     * </p>
     */
    public void levelUp() {
        this.level += 1;
    }

    /**
     * Returns the player's current experience points.
     * @return the total experience of the player
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Adds a specified amount of experience points to the player.
     * @param experience the number of experience points to add
     */
    public void addExperience(int experience) {
        this.experience += experience;
    }

    /**
     * Calculates and returns the experience required for the next level.
     * @return the experience points needed to reach the next level
     */
    public int getNextLevel() {
        return nextLevel = (level * experience) / 2;
    }
}