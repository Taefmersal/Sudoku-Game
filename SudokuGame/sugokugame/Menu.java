package sugokugame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // in this class we used Singleton creational design pattern to be the menu class accessable for other object 
    // to minimize the creation of Menu object to reduce using the memory
    private static Menu instance = null;
    Context context = new Context();
    StartState startState = new StartState();
   

    

    private Menu() {
    }

    public static Menu getInstace() {

        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public static void menu() {

        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("###           WELCOME TO SUDOKU GAME             ###");
        System.out.println("----------------------------------------------------");
        System.out.println("| 1  :                 Play                        |");
        System.out.println("| 2  :                 Exit                        |");
        System.out.println("| 3  :                 Help                        |");
        System.out.println("----------------------------------------------------");
        System.out.print("> Please enter your choice... (1-3): ");

        do {
            try {
                choice = input.nextInt();    // the user chose one choice ..
            } catch (InputMismatchException e) {
                System.out.println("you can't enter string \n");
                menu();
            }
            switch (choice) {
                case 1:
                   

                    break;
                case 2:
                    Menu m = new Menu();
                    m.Exit();
                    
                     
                    break;
                case 3:
                    Help();
                    break;

                default:
                    System.out.println("Invalid Input!!! you have to enter 1,2 or 3, Please Try Again\n");
                    break;

            }// end switch choise

        } while (choice > 3); // end loop

    }

    public static void Help() {

        System.out.println("\n *** Instuction on How to play the game ***");

        System.out.println("\n(1) There is only one valid solution to each Sudoku puzzle."
                + "\n The only way the puzzle can be considered solved correctly is when all"
                + " \n 81 boxes contain numbers and the other Sudoku rules have been followed."
                + "\n \n(2) When you start a game of Sudoku, some blocks will be pre-filled for you. "
                + "\n You cannot change these numbers in the course of the game."
                + "\n \n (3) Each column must contain all of the numbers 1 through 9 and no two numbers "
                + "in the same column of a Sudoku puzzle can be the same."
                + "\n \n (4) Each row must contain all of the numbers 1 through 9 and no two numbers in"
                + " the same row of a Sudoku puzzle can be the same."
                + "\n \n (5) Each block must contain all of the numbers 1 through 9 and no two numbers "
                + "in the same block of a Sudoku puzzle can be the same.");
        System.out.println("\n***********************************************************************\n");
        menu();
    }

    public  void Exit() {
        int exit = 0;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\n *** The game will be stopped, Do you want to exit the game?***"
                    + "\n To exit enter 1.\n To cancle enter 2.");
            exit = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("you can't enter string \n");
            Exit();
        }
        if (exit == 2) {
            menu();
        } else if (exit == 1) {
                StopState stopState = new StopState();
		stopState.doAction(context);
		System.out.println(context.getState().toString());

               

            System.exit(0);
        } else {
            System.out.println("\nInvalid Input!!!you have to enter 1 or 2 Please Try Again...\n");
            Exit();
        }
    }

    public void board() {

        int board_choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("***           Board of Sudoku Game              ***");
        System.out.println("---------------------------------------------------");
        System.out.println("| 1  :                 Try again                  |");
        System.out.println("| 2  :                 Main menu                  |");
        System.out.println("| 3  :                 Stop                       |");
        System.out.println("---------------------------------------------------");
        System.out.print("> Please enter your choice... (1-3): ");

        do {
            try {
                board_choice = input.nextInt();    // the user chose one choice ..
            } catch (InputMismatchException e) {
                System.out.println("you can't enter string \n");
                board();
            }
            switch (board_choice) {
                case 1:

                    break;
                case 2:
                    menu();
                    break;
                case 3:

                    SudokuGame.writeFile();
                    System.out.println("******* THANK YOU FOR USING SUDOKU GAME *******");
                    System.exit(0);

                    break;

                default:
                    System.out.println("Invalid Input!!! you have to enter 1 , 2 or 3 , Please Try Again\n");
                    break;

            }// end switch choise

        } while (board_choice > 3); // end loop

    }

    public void success() {

        int board_choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("***           Board of Sudoku Game              ***");
        System.out.println("---------------------------------------------------");
        System.out.println("| 1  :                 continue                   |");
        System.out.println("| 2  :                 Main menue                 |");
        System.out.println("| 3  :                 Stop                       |");
        System.out.println("---------------------------------------------------");
        System.out.print("> Please enter your choice... (1-3): ");

        do {
            try {
                board_choice = input.nextInt();    // the user chose one choice ..
            } catch (InputMismatchException e) {
                System.out.println("you can't enter string \n");
                success();
            }
            switch (board_choice) {
                case 1:

                    break;
                case 2:
                    menu();
                    break;
                case 3:

                    SudokuGame.writeFile();
                    System.out.println("******* THANK YOU FOR USING SUDOKU GAME *******");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input!!! you have to enter 1 , 2 or 3, Please Try Again\n");
                    break;

            }// end switch choise

        } while (board_choice > 3); // end loop

    }

    public void name() {

        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name (note : the name should be 3-8 letters ):");

        name = input.nextLine();

        if (!name.matches("^[A-Za-z]{3,8}$")) {
            System.out.println("Please try again!");
            System.out.println("##the name should be 3-8 letters not integer ##");
            name();
        } else {
            
            System.out.println("********* Welcome " + name + " *********");
            
            StartState startState = new StartState();
		startState.doAction(context);
		System.out.println(context.getState().toString());


        }
    }

}
