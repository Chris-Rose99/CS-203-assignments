/* Chris Rose
Assignment 02
Mrs. Grabowski */

public class Turtle implements Critter {
    int c = 0; // counter for steps

    // returns initial T for turtle
    public char getChar() {
	return 'T';
    }

    // moves turtle in a clockwise box
    public int getMove(CritterInfo Critter) {
	// 5 steps down
	if (c < 5 && c >= 0) {
	    c++;
	    return SOUTH;
	// 5 steps west 
	} else if (c < 10 && c >= 5) {
	    c++;
	    return WEST;
	// 5 steps up
	} else if (c < 15 && c >= 10) {
	    c++;
	    return NORTH;
	// 5 steps east
	} else if (c < 20 && c >= 15) {
	    c++;
	    return EAST;
	}
	// resets counter while starting to move down
	c = 1;
	return SOUTH;
    }
}
	    
