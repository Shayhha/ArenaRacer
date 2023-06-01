package designPatterns;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import java.awt.*;

import GUI.*;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.arenas.land.LandArena;
import game.racers.Racer;

public class Builder {
    // Arena Instance, this is the arena that the user is going to build
    private Arena arena = null; 
    private final static int DEFAULT_LENGTH=1000; // the default arena length
    private final static int MAX_RACERS = 8; // the default max racers allowed

    // Create new instance for the arena factory 
    private Factory arenaFactory = new Factory(); 

    public int[] serialNumList;

    public Builder(int numOfRacers) {
        arena = arenaFactory.MakeArena("land", DEFAULT_LENGTH, numOfRacers);

        // if (numOfRacers > MAX_RACERS) // If the given number of racers is larger than the default number
        //     // Creating an arena with the given number of racers
        //     arena = arenaFactory.MakeArena("land", DEFAULT_LENGTH, numOfRacers);
        // else 
        //     // Creating an arena with the default number of max racers
        //     arena = arenaFactory.MakeArena("land", DEFAULT_LENGTH, MAX_RACERS);
        
        serialNumList = new int[numOfRacers];
        // create all of the racers using prototype
        for (int i = 0; i < numOfRacers; i++) {
            Racer racer = Prototype.getRacerClone("Car", i, utilities.EnumContainer.Color.BLUE);
            try {
                this.arena.addRacer(racer);
                serialNumList[i] = racer.getSerialNumber();
                racer.introduce();

                // making an image obj using the image located in the given path, setting the size of the image to the default size declaed at the top
                Image image = new ImageIcon("icons/CarBlue.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                JLabel racerImage = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the image to a label to be visible on screen
                racerImage.setBounds(5, 5, 60, 60); // adding some border to each racer's icon and setting the default size

                MainWindow.racersList.put(racer.getSerialNumber(),racerImage);
                MainWindow.moveRacer(racer.getSerialNumber(), 0, (i)*60 + (int)this.arena.getMIN_Y_GAP());

            } catch (RacerLimitException e) {
                e.printStackTrace();
            } catch (RacerTypeException e) {
                e.printStackTrace();
            }
        }
    }

    public Arena getArena() {
        return this.arena;
    }
}
