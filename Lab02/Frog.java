/* Chris Rose
Assignment 02
Mrs. Grabowski */
import java.util.*;

public class Frog implements Critter {
    int count = 0; // counter for steps
    Random r = new Random(); // creates random method
    int a = r.nextInt(4); // picks a random number from 0 - 3

    // returns initial F for frog
    public char getChar() {
	return 'F';
    }

    // moves 3 steps in a random direction
    public int getMove(CritterInfo Critter) {
	// resets the counter after 3 steps and picks a new direction
	if (count == 3) {
	a = r.nextInt(4);
	count = 0;
	}
	// adds a step to the counter
       	count++;
	// moves in the direction chosen
	if (a == 0) {
	    return NORTH;
	} else if (a == 1){
	    return SOUTH;
	} else if (a == 2) {
	    return WEST;
	} else {
	    return EAST;
	}
    }
}
