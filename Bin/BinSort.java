/* Christopher Rose
Assignment 08 Bin Sort
Dr. Grabowski 

This assignment shows how to implement bin sort*/

import java.io.*;
import java.util.*;

public class BinSort {

    public static void main(String[] args)
	
	throws FileNotFoundException {

	// establishes the file refered to and uses scanner so it could be read
	String fileName = args[0];
	File f = new File(fileName + ".txt");
	Scanner sc = new Scanner(f);

	// Only happens if the file can be found
	if (f.exists()) {

	    // assigning max length and total values while storing values in the array
	    int digits = sc.nextInt();
	    int values = sc.nextInt();
	    int [] num = new int[values];
	    for (int i = 0; i < values; i++) {
		num[i] = sc.nextInt();
	    }
	    sorting(num, digits);
	    readarray(num);
	}
    }

    // reads the array
    public static void readarray(int [] a) {
	String s = "[" + a[0];
	for (int i = 1; i < a.length; i++) {
	    s = s + " ," + a[i];
	}
	System.out.println(s + "]");
    }
    
    // actually performing the Bin Sort
    public static void sorting(int [] a, int b) {

	// creates arraylist of arraylists and prints it empty
	ArrayList<Integer> [] bin = (ArrayList<Integer>[]) new ArrayList [10];
	for (int i = 0; i < bin.length; i++) {
	    bin[i] = new ArrayList<Integer>();
	}

	// changes power of ten
	int t = 10;
	for (int i = 0; i < b; i++) {
	    int index = 0;

	    // adds the number to its respective arraylist
	    for (int j = 0; j < a.length; j++) {
		if (a[j] > t / 10) {
		    int d = (a[j] % t) / (t / 10);
		    bin[d].add(a[j]);
		} else {
		    bin[0].add(a[j]);
		}
	    }

	    // removes them and put them into array
	    for (int j = 0; j < bin.length; j++) {
		while (isEmpty(bin[j]) == false) {
		    a[index] = bin[j].remove(0);
		    index++;
		}
	    }

	    // increases power of ten 
	    t = t * 10;
	}
    }

    // checks to see if arraylist is empty
    public static boolean isEmpty(ArrayList<Integer> a) {
	for (int i = 0; i < a.size(); i++) {
	    if (a.get(i) != 0) {
		return false;
	    }
	}
	return true;
    }
}
