/* Chris Rose
203 Assignment 1.0
Dr. Grabowski */
import java.util.*;

public class JString {
    // word currently being examined
    private String s;
    // array of chars
    private char [] c;

    // stores String as an array of chars
    public JString(String s) {
	c = new char [s.length()];
	for (int i = 0; i < s.length(); i++) {
	    c[i] = Character.toUpperCase(s.charAt(i));
	}	
    }

    // capitalizes chars stored in array
    public String toString() {
	return Arrays.toString(c);
    }

    // randomly rearranges the array
    public String permute() {
        Random r = new Random();
	for (int i = 0; i < c.length; i++) {
	    int j = r.nextInt(c.length);
	    char temp = c[i];
	    c[i] = c[j];
	    c[j] = temp;
	}
	String x = new String(c);
	return x;
    }
}
