package sugokugame;

public class Cell extends Position {

    private int value;

    /**
     * value of the cell
     */

    public Cell(int x, int y) {
        super(x, y); //assigning the position
        this.value = -1; //initiates the value of the Cell with -1 (empty).

    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
