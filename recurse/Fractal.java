/* Christopher Rose
Assignment 06
Dr. Grabowski */

public class Fractal {
    
    public static void main (String [] args) {
	figure(Integer.parseInt(args[0]), 0);
	System.out.println();
    }

    public static void figure(int level, int pad) {

	//this is our base case
	if (level ==  0) {
	    for (int i = 1; i <= pad; i++) {
	    	System.out.print(" ");
	    }
	    System.out.print("*");
	    
	} else { 


	    // prints out the top half of the whole image
	    for (int i = 0; i < pad; i++) {
		System.out.print(" ");
	    }
	    figure(level - 1, pad);
	    System.out.println();
	    
	    // prints out the center of each level
	    for (int i = 0; i < pad * 2; i++) {
		System.out.print(" ");
	    }
	    
	    for (int i = 0; i < Math.pow(2, level) ; i++) {
		figure(0, 0);
	    }
	    System.out.println();
	    

	    // prints out the bottom half of the whole image
	    for (int i = 0; i < pad; i++) {
	    	System.out.print(" ");
	    }	    
	    figure(level - 1, (pad + (int)Math.pow(2, level - 1)) - (level - 1));
	}
    }
}
	    
	    
