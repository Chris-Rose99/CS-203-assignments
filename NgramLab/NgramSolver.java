/* Christopher Rose 
Assignment 07
Dr. Grabowski */

import java.util.*;

public class NgramSolver {

    // An arraylist to store possible starts of sentences in 
    private ArrayList<String> starts = new ArrayList<String>();

    // constructs a map to store ngrams from a sample text
    Map<String, String> map = new TreeMap<String, String>();
    
    
    public NgramSolver (int n, String text) {

	// puts values and keys into map
	for (int i = 0; i < text.length() - 1; i+=n) {
	    String k = text.substring(i, i + n);
	    if (i + n <= text.length()) {
		if (map.containsKey(k)) {
		    String v = map.get(k) + Character.toString(text.charAt(i + n));
		    map.put(k, v);
		} else {	     
		    String v = Character.toString(text.charAt(i + n));
		    map.put(k, v);
		}
	    }
	}

	// fills arraylist with starts
	for (int i = 1; i < text.length() - 1; i++) {
	    String s = text.substring(i - 1, i + 1);
	    if (s == "? " || s == ". " || s == "! ") {
		starts.add(text.substring(i + 1, i + n + 1));
	    }
	}
	starts.add(text.substring(0, n));
    }

    // checks if a specific substring is in the text
    public boolean contains(String ngram) {
	return map.containsKey(ngram);
    }

    // selects one of the possible characters that could follow the ngram
    public char randomChar (String ngram) {
	if (map.containsKey(ngram) == false) {
	    throw new IllegalArgumentException();
	} else {
	    Random rand = new Random();
	    String val = map.get(ngram);
	    int n = rand.nextInt(val.length());
	    return val.charAt(n);
	}
    }

    public String randomStart() {
	Random rand = new Random();
	int n = rand.nextInt(starts.size());
	return starts.get(n);
    }
}	
