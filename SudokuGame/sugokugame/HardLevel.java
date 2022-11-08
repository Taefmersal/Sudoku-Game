
package sugokugame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static sugokugame.SudokuGame.sudokuHard;



public class HardLevel implements GameLevel {
    
    
      @Override
     public void level() {
         
         
     

        Play game = new Play(sudokuHard); // craete an object from class play to call the method that inside the play class
        game.start();//call the start method

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sudokuHard.length; i++)//for each row
        {
            for (int j = 0; j < sudokuHard.length; j++)//for each column
            {
                builder.append(sudokuHard[i][j] + "");//append to the output string
                if (j < sudokuHard.length - 1)//if this is not the last row element
                {
                    builder.append(",");//then add comma (if you don't like commas you can use spaces)
                }
            }
            builder.append("\n");//append new line at the end of the row
        }
    }
    
    
}
   
    

