/*  *************************************************************
 CIS 203 Assignment 1 Testing Client: JString.java
 Updated 1/8/2019 by L. Grabowski
 This is a testing program for the JString class used in the
 Word JUMBLE assignment.
 NOTE: DO NOT alter this code. Your class must work with the given client code.
 *************************************************************
 */
public class JStringTester {
    public static void main (String [] args) {
    /* args is a String array that contains all the words entered AFTER
       java JStringTester. For example,
            java JStringTester cow horse goat
       would result in args = {"cow", "horse", "goat"}
    */
        
	// for each word entered
	for (int i =0; i < args.length; i++) {
	    // construct a JString
            JString js = new JString(args[i]);
	    // print the JString
	    System.out.println("Three permutations of \""+ js + "\":");
	    // and print out 3 permutations of each JString
            for (int j = 0; j < 3; j++) 
	        System.out.println("   " + js.permute());
	    System.out.println();
	}

    }
}
