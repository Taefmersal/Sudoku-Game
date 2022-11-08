package sugokugame;

import static sugokugame.SudokuField.point;

public class Sub extends CalculatePoint {

    @Override
    void AddPoint() {

    }

    @Override
    void SubPoint() {

        if (point >= 2) {

            point = point - 2;
        } else {
            point = 0;

        }

        System.out.println("Your point :" + point);

    }

}
