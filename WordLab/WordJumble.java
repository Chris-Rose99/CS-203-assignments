/*  *************************************************************
    CIS 203 Assignment 1 Client: WordJumble.java
    Updated 1/8/2019 by L. Grabowski
    This is the client program for the Word JUMBLE assignment.
    NOTE: DO NOT alter this code. Your class must work with the given client code.
    *************************************************************
*/
import java.util.*;

public class WordJumble {

    public static void main (String [] args) {
        // prompt the user for the number of words in the JUMBLE
        System.out.print("How many words do you want in your JUMBLE? ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // get the words in an array
        System.out.println("Enter the words: ");
        String [] words = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("--> ");
            words[i] = sc.next();
        }
        
        // use the array of words to contruct a JUMBLE puzzle and
        // display the puzzle and its solution
        Jumble j = new Jumble(words);
        j.show();
        j.solve();
    }
}
