package sugokugame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Play extends SudokuField {

    private String command;
    private int row, column, value;
    private String oldLayout;
    private Scanner scan = new Scanner(System.in);
    int datavilde;
    Menu newInstance = Menu.getInstace();

    public Play(byte[][] f) {
        super(f);
    }

    private void getData() {

        while (true) {
            try {
                datavilde = 1;
                command = scan.next();
                row = scan.nextInt();
                column = scan.nextInt();
                value = scan.nextInt(); //InputMisma
                break;

            } catch (InputMismatchException a) {
                System.out.print("you have to type 'enter', and row col and value as intger\n");
                datavilde = -1;
                scan.nextLine();
                //throw a;
            }
        }
    }

    private boolean isfieldfull() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.getCellVal(i, j) == -1) {
                    return false; //if only one cell is still empty then field still not full 
                }
            }
        }
        return true;
    }

    public void printWithInstructions() {

        System.out.println(this); //to print the field
    }

    public void start() {

        newInstance.menu();
        printWithInstructions();
        boolean execute = true;
        this.oldLayout = this.toString();

        while (!isfieldfull() && execute) {
            try {
                datavilde = 1;
                this.getData();
            } catch (InputMismatchException a) {
                System.out.print("you have to type 'enter', and row col and value as intger\n");
                datavilde = -1;
            }
            if (datavilde == 1) {
                switch (command) {
                    case "enter":
                        this.setCellVal(row, column, value);
                        break;
                    default:
                        System.out.println("your command isn't valid");
                }

                if (!this.oldLayout.equals(this.toString())) { //to check weather there is a new value entered or not. If yes, the field should be printed again including this new value
                    printWithInstructions();
                    this.oldLayout = this.toString();
                }
            }
        }
        //if the sudokufield is completely full that means the playes has won. 
        if (isfieldfull()) {
            System.out.println("YOU WIN!! :) YAHOO :)");
        }

    }
}
