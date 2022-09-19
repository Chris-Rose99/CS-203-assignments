/* Christopher Rose
203 Assignment 10
Dr. Grabowski */

import java.io.*;
import java.util.*;

public class Decode {

    public static void main(String[] args)
	
	throws FileNotFoundException {

	// establishes the file refered to and uses scanner so it could be read
	String fileName = args[0];
	File f = new File(fileName + ".txt");
	Scanner sc = new Scanner(f);
	ArrayList<String> list = new ArrayList<String>();

	// Only happens if the file can be found
	if (f.exists()) {

	    // each word is taken letter by letter and added to the array
	    while (sc.hasNext()) {
		String full = sc.next();		
		String s = "";
		for (int i = 0; i < full.length(); i++) {
		    if (full.charAt(i) == '-' || full.charAt(i) == '.') {
			s = s + full.charAt(i);
		    } else if (full.charAt(i) == '|') {
			list.add(s);
			s = "";
		    } else {
			list.add(s);
			String symbol = Character.toString(full.charAt(i));
			list.add(symbol);
			s = "";
		    }
		}
		list.add(s);
		list.add(" ");
	    }

	    // adds each letter to a string which gets printed once finished 
	    String fin = "";
	    for (int i = 0; i < list.size(); i++) {
		if (list.get(i).contains("-") || list.get(i).contains(".")){
		    fin = fin + MorseCode.getLetter(list.get(i));
		} else if (list.get(i) == null) {
		    fin = fin + " ";
		} else {
		    fin = fin + list.get(i);
		}
	    }
	    System.out.println(fin);
	}
    }
}
