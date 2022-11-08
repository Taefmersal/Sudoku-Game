
package sugokugame;

import static sugokugame.SudokuField.point;

public class Add extends CalculatePoint {

    @Override
    void AddPoint() {

        point = point + 5;
        System.out.println("Your point :" + point);

    }

    @Override
    void SubPoint() {

    }

}

