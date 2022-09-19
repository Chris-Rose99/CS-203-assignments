/* Christopher Rose
Assignment 03
Dr.Grabowski */
import java.util.*;
import java.util.ArrayList.*;

public class LetterInventory extends TestLI {
    // ArrayList that keeps track of letter counts
    private ArrayList<Integer> LetterCount;
    // Size of the String given
    private int size;

    // Tests if two given Strings are anagrams
    public static boolean anagrams(String s1, String s2) {
	LetterInventory L1 = new LetterInventory (s1);
	LetterInventory L2 = new LetterInventory (s2);
	return L1.equals(L2);
    }

    // Constructs a letter inventory which contains an ArrayList and the size of the string 
    public LetterInventory(String data) {
	String check = "";
	for (int i = 97; i < 123; i++) {
	    check = String.valueOf(i);
	    for (int j = 1; j < data.length(); j++) {
		if (check.equalsIgnoreCase(data.substring(j - 1,j))) {
		    LetterCount.add(LetterCount.get(i) + 1);
		}
	    }
	}
	size = data.length();
    }

    // returns how many times a letter shows up in the word 
    public int get(char letter) {
	int letVal = letter - 'a';
	return LetterCount.get(letVal);
    }

    // replaces a given letter with a specific amount
    public void set(char letter, int value) {
	int letVal = 0;
	if (value < 0) {
	    throw new IllegalArgumentException();
	}
	if (letter >= 'a' && letter <= 'z') {
	    letVal = letter - 'a';
	    LetterCount.set(letVal, value);
	} else if (letter >= 'A' && letter <= 'Z') {
	    letVal = letter - 'A' + 'a';
	    LetterCount.set(letVal, value);
	} else {
	    throw new IllegalArgumentException();
	}
    }

    // returns the size of the word
    public int size() {
	int s = 0;
	for (int i = 0; i < 26; i++) {
	    s = s + LetterCount.get(i);
	}
	return s;
    }

    // checks to see if the ArrayList is empty
    public boolean isEmpty() {
	return LetterCount.isEmpty();
    } 

    // return arrayList in the form of a String
    public String toString() {
	String let = "";
        String all = "";
	for (int i = 97; i < 123; i++) {
	    let = String.valueOf(i);
	    for (int j = 0; j < LetterCount.get(i - 97); j++) {
		all = all + let;
	    }
	}
	return all;
    }

    // checks if an object is a Letter Inventory and if its equal to the previous one
    public boolean equals(Object obj) {
	if (obj instanceof LetterInventory) {
	    LetterInventory other = (LetterInventory) obj;
	    for (int i = 0; i < size; i++) {
		if (other.LetterCount.get(i) != LetterCount.get(i)) {
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    // combines two Letter Inventories
    public LetterInventory add(LetterInventory other) {
	LetterInventory LI = new LetterInventory("");
	for (int i = 0; i < 26; i++) {
	    LI.LetterCount.add(this.LetterCount.get(i) + other.LetterCount.get(i)); 
	}
	return LI;
    }

    // removes values from a Letter Inventory based on a given Inventory
    public LetterInventory subtract(LetterInventory other) {
	LetterInventory LI = new LetterInventory("");
	for (int i = 0; i < 26; i++) {
	    if (this.LetterCount.get(i) - other.LetterCount.get(i) < 0) {
		LI.LetterCount.add(0);
	    } else {
		LI.LetterCount.add(this.LetterCount.get(i) - other.LetterCount.get(i));
	    }
	}
	return LI;
    }
}
    
