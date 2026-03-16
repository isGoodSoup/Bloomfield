package com.soup.game.service;

import com.soup.game.intf.Data;

/**
 * Represents a position on the farm grid with row and column coordinates.
 * <p>
 * This record is immutable and can be used to reference specific tiles
 * within the farm grid, for example when iterating over all tiles
 * or targeting a specific crop for planting, harvesting, or watering.
 * </p>
 *
 * @param row the row index of the position (0-based)
 * @param col the column index of the position (0-based)
 */
@Data
public record Pos(int row, int col) {}