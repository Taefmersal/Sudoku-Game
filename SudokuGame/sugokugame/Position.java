package sugokugame;

public class Position {

    private int x;
    /**
     * x axis of the cell
     */
    private int y;

    /**
     * y axis of the cell
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * gets the value of the x axis "protected" because it should only be
     * accessible to the inheriting classes
     *
     * @return value of the x axis
     */
    protected int getX() {
        return this.x;
    }

    /**
     * gets the value of the y axis "protected" because it should only be
     * accessible to the inheriting classes
     *
     * @return value of the y axis
     */
    protected int getY() {
        return this.y;
    }

}
