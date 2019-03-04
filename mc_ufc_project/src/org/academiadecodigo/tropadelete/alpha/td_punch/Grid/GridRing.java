package org.academiadecodigo.tropadelete.alpha.td_punch.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridRing implements Grid {

    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle rectangle;

    private final int CELL_SIZE = 10;

    public GridRing(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        rectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
        rectangle.draw();
    }

    /**
     * @see Grid#getCols()
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * @see Grid#getRows()
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return cols * getCellSize();
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return rows * getCellSize();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        return CELL_SIZE;
    }

}
