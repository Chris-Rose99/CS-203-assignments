/* Chris Rose
Assignment 02
Mrs.Grabowski */
import java.util.*;

public class Mouse implements Critter {
    int count = 0; // counter for steps

    // returns initial M for Mouse
    public char getChar() {
	return 'M';
    }
    
    // zigzags NorthWest
    public int getMove(CritterInfo Info) {
	// 1 step west
	if (count == 0) {
	    count = 1;
	    return WEST;
	} else {
	 // 1 step up and sets counter back to 0
	    count = 0;
	    return NORTH;
	}
    }
}
