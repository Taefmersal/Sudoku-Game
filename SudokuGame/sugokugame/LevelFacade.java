
package sugokugame;

import java.io.FileNotFoundException;

public class LevelFacade {

    // in this project we used Facade structural design pattern to encapsulate other object and make the client communicate with this class
    // this class will be the communication point between the client and other classes 
    // when the user choose the level if its easy ro hard the Facade class will enter the system to start the game 
    private GameLevel easy;
    private GameLevel hard;

    public static void mainfacade() throws FileNotFoundException {
        Menu newInstance = Menu.getInstace();
        newInstance.name();
        SudokuGame ss = new SudokuGame();
        ss.Level();
    }

    public LevelFacade() {
        easy = new EasyLevel();
        hard = new HardLevel();
    }

    public void levelEasy() {
        easy.level();
    }

    public void levelHard() {
        hard.level();
    }

}
