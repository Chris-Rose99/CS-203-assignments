/* Chris Rose
Assignment 02
Mrs. Grabowski */

public class Wolf implements Critter {
    int c = 0; // counter for steps

    // return initial W for wolf 
    public char getChar() {
	return 'W';
    }
    
    // slithers up in a pattern 3 steps each direction
    // then drops down
    public int getMove(CritterInfo Critter) {
	// 3 steps up
	if (c < 3 && c >= 0) {
	    c++;
	    return NORTH;
	// 3 steps west
	} else if (c < 6 && c >= 3) {
	    c++;
	    return WEST;
	// 3 steps up
	} else if (c < 9 && c >= 6) {
	    c++;
	    return NORTH;
	// 3 steps east
	} else if (c < 12 && c >= 9) {
	    c++;
	    return EAST;
	// 3 steps down
	} else if (c < 20 && c >= 12) {
	    c++;
	    return SOUTH;
	}
	// resets counter while still moving down 1 step
	c = 0;
	return SOUTH;
    }
}
