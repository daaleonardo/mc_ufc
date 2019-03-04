package org.academiadecodigo.tropadelete.alpha.td_punch.Grid;

public interface Grid {


    /**
     * Initializes the grid
     */
    public void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */

}
