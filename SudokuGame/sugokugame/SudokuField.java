package sugokugame;

public class SudokuField {

    Menu newInstance = Menu.getInstace();
    private static Cell[][] field = new Cell[9][9]; // the playing field

    public SudokuField(byte[][] f) {
        //checking number of rows
        if (f.length != 9) {
            System.err.println("The playing field isn't valid");
            System.exit(2);
        }
        //checking number of cols per each row
        for (int i = 0; i < 9; i++) {
            if (f[i].length != 9) {
                System.err.println("The playing field isn't valid");
                System.exit(2);
            }
        }
        //now the field is valid 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.field[i][j] = new Cell(i, j); //assigning the position (x and y) to every single cell
                this.field[i][j].setValue(f[i][j]); //assigning the values 
            }
        }
    }

    static int point = 0;

    public boolean setCellVal(int x, int y, int value) {
        if (isValid(x, y, value)) {

            this.field[x][y].setValue(value);

            System.out.println("Number" + value + "is successfully insted in cell"
                    + "(" + x + "," + y + ")");

            CalculatePoint pd = new Add();
            pd.AddPoint();
            System.out.println();

            newInstance.success();

            return true;
        }

        CalculatePoint ps = new Sub();
        ps.SubPoint();
        System.out.println();

        System.out.println("The inserted number " + value + " in cell " + "(" + x + "," + y + ")"
                + "is not correct ");

        newInstance.board();

        return false;

    }

    public int getCellVal(int x, int y) {
        return this.field[x][y].getValue();
    }

    private boolean isValid(int x, int y, int value) {
        if (value < 1 || value > 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) { //if the value already exists in same row or column
            if (field[x][i].getValue() == value || field[i][y].getValue() == value) {
                return false;
            }
        }
        if (!isValidInSquare(x, y, value)) {
            return false; //if the value already exists in its 3x3 square
        }
        return true;
    }

    private boolean isValidInSquare(int x, int y, int value) { //to check weather the value already exists in its 3x3 square or not.
        int rows = -1; //the index of rows from which the loop will start.
        int cols = -1; //the index of cols from which the loop will start.

        if (x < 3) {
            rows = 0; //rows will get its value depending on the value of x 
        } else if (x < 6) {
            rows = 3;
        } else if (x < 9) {
            rows = 6;
        }

        if (y < 3) {
            cols = 0; //cols will get its value depending on the value of y
        } else if (y < 6) {
            cols = 3;
        } else if (y < 9) {
            cols = 6;
        }
        //now we know in which square we should compare and check the values.
        int limitCols = cols + 3; //where the loop of cols should stop
        int holdCols = cols;    //to reassign the value of cols in each row. 
        for (int limitRows = rows + 3; rows < limitRows; rows++) {
            for (cols = holdCols; cols < limitCols; cols++) {
                if (field[rows][cols].getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String s = "   **SUDOKU GAME**\n";

        s += " |0 1 2|3 4 5|6 7 8|";
        s += "\n-+-----+-----+-----+\n";

        for (int i = 0; i < 9; i++) {
            s += String.valueOf(i) + "|";

            for (int j = 0, count = 1; j < 9; j++, count++) {
                if (this.field[i][j].getValue() == -1) {
                    s += " ";
                } else {
                    s += String.valueOf(this.field[i][j].getValue());
                }
                if (count == 3) {
                    s += "|";
                    count = 0;
                } else {
                    s += " ";
                }
            }
            s += "\n";

            if (i + 1 == 3 || i + 1 == 6 || i + 1 == 9) {
                s += "-+-----+-----+-----+\n";
            } else {
                s += " |     |     |     |\n";
            }
        }
        System.out.println("type 'enter' <row> <column> <value> ");
        return s;

    }

    public static Cell[][] getField() {
        return field;
    }
}
