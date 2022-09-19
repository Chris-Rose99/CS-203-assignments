/* Chris Rose
Assignment 02
Mrs. Grabowski */
import java.util.*;

public class Bird implements Critter {
    // returns initial B for bird
    public char getChar() {
	return 'B';
    }

    // moves one space in any direction
    public int getMove(CritterInfo info) {
	Random r = new Random();
	// picks a direction linked to values 0 - 3
	int a = r.nextInt(4); 
	if (a == 0) {
	    return NORTH;
	} else if (a == 1) {
	    return SOUTH;
	} else if (a == 2) {
	    return WEST;
	} else {
	    return EAST;
	}
    }
}
