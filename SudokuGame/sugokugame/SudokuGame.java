package sugokugame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SudokuGame {

    public static int level;
    LevelFacade levelFactory = new LevelFacade();

    static byte[][] sudokuEasy = {
        {-1, 2, 9, -1, 5, -1, -1, -1, 6},
        {3, -1, 4, 7, 2, 8, -1, -1, 1},
        {-1, -1, -1, -1, -1, -1, 3, -1, -1},
        {-1, 5, 2, 8, 9, 1, 6, 4, -1},
        {-1, 1, 3, -1, 6, 4, 2, 7, -1},
        {-1, -1, -1, -1, -1, 7, 9, -1, -1},
        {-1, 9, -1, -1, -1, -1, 1, 5, 7},
        {5, -1, -1, 1, 8, -1, 4, -1, 2},
        {-1, -1, -1, -1, -1, -1, 8, 3, -1}

    };
    static byte[][] sudokuHard = {
        {5, -1, -1, -1, 8, -1, 1, -1, -1},
        {-1, -1, 4, -1, -1, -1, -1, 2, -1},
        {7, -1, 8, 2, -1, -1, -1, 4, -1},
        {-1, -1, -1, -1, -1, -1, -1, 5, -1},
        {-1, 5, -1, 3, -1, -1, -1, -1, 1},
        {-1, -1, -1, -1, -1, 4, -1, -1, 2},
        {8, -1, 1, -1, -1, 6, 5, -1, -1},
        {-1, -1, 3, -1, -1, -1, -1, -1, -1},
        {4, -1, -1, -1, -1, 1, 3, -1, 7}

    };

    public void Level() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("###               CHOOSE THE LEVEL               ###");
        System.out.println("----------------------------------------------------");
        System.out.println("| 1  :                 Easy                        |");
        System.out.println("| 2  :                 Hard                        |");
        System.out.println("----------------------------------------------------");
        System.out.print("> Please enter your choice... (1-2): ");

        try {
            level = input.nextInt();    // the user chose one choice ..
        } catch (InputMismatchException e) {
            System.out.println("you can't enter string \n");
            Level();
        }// for catch 
        if (level == 1 || level == 2) {
            select();
        } else {
            System.out.println("Invalid Input!!! you have to enter 1 or 2, Please Try Again\n");
            Level();
        }
    }// for method level

    public void select() throws FileNotFoundException {

        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("***               Welcome Again                 ***");
        System.out.println("---------------------------------------------------");
        System.out.println("| 1  :                 Resume                     |");
        System.out.println("| 2  :                  New                       |");
        System.out.println("---------------------------------------------------");
        System.out.print("> Please enter your choice... (1-2): ");

        try {
            choice = input.nextInt(); // the user chose one choice ..\
        } catch (InputMismatchException e) {
            System.out.println("you have to enter an integer \n");
            select();
        }
        if (choice == 1) {
            readFile();

        } else if (choice == 2) {
            switch (level) {
                case 1:
                    levelFactory.levelEasy();
                    break;
                case 2:
                    levelFactory.levelHard();
                    break;
                default:
                    System.out.println("\nInvalid Input!!! you have to enter 1 or 2, Please Try Again\n");
                    break;
            }// end switch choise
        } else {
            System.out.println("\nInvalid Input!!! you have 1 or 2 please, try again\n");
            select();
        }
    }

    public void readFile() throws FileNotFoundException {
        File file;
        if (level == 1) {
            file = new File("easy.txt");
        } else {
            file = new File("hard.txt");
        }

        Scanner scanner = new Scanner(file);
        // to read  file line by line
        if (!scanner.hasNextLine()) {
            if (level == 1) {
                levelFactory.levelEasy();
            }
            if (level == 2) {
                levelFactory.levelHard();
            }

        } else {
            level = Integer.parseInt(scanner.nextLine());
            SudokuField.point = Integer.parseInt(scanner.nextLine());

            //System.out.println(level);
            int i = 0;
            while (scanner.hasNextLine()) // run the loop until file is end
            {
                String line = scanner.nextLine(); // reading the line

                String word[] = line.split(" ");// split the line on bases of space to get the value
                for (int j = 0; j < word.length; j++) {
                    if (level == 1) {
                        sudokuEasy[i][j] = (byte) Integer.parseInt(word[j]);
                    } else if (level == 2) {
                        sudokuHard[i][j] = (byte) Integer.parseInt(word[j]);
                    }
                }
                i++;

            }

        }
        if (level == 1) {

            levelFactory.levelEasy();
        }
        if (level == 2) {
            levelFactory.levelHard();
        }

    }

    public static void writeFile() {
        try {
            FileWriter myWriter;
            if (level == 1) {
                myWriter = new FileWriter("easy.txt");
            } else {
                myWriter = new FileWriter("hard.txt");
            }

            Cell[][] field = SudokuField.getField();
            myWriter.write(level + "\n");
            myWriter.write(SudokuField.point + "\n"); 

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    myWriter.write(field[i][j].getValue() + " ");
                }
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException exception) {
            System.out.println("An file writing error occurred.");
        }
    }

}
