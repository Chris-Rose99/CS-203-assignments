import java.util.*;

public class Bag {
    // array of integers in the bag
    private int [] items;
    // number of integers in the bag
    private int size;

    // constructor that creates items[] and size
    public Bag() {
	items = new int [20];
	int size = 0;
    }

    // constructs Bag while accepting parameters for capacity
    public Bag(int x) {
	items = new int [x];
	int size = 0;
    }
    

    // adds n to the array and increases size
    public void add(int n) {
	items[size] = n;
	size++;
    }

    // returns the number of integers in the bag
    public int size() {
	return size;
    }

    public String toString() {
	int realbag [] = new int [size];
	for (int i = 0; i < size; i++) {
	    realbag[i] = items[i];
	}
	return Arrays.toString(realbag);
    }
	

    //  tells if the bag if empty
    public boolean isEmpty() {
	if (size == 0) {
	    return true;
	}
	return false;
    }

     // adds contents of one bag to another bag
    public void add(Bag other) {
	if (other.size + size <= items.length) {
	    for (int i = 0; i < other.size; i++) {
	        add(other.items[i]); 
	    }
	}
    }

    // removes specified integers from the bag
    public void remove(int target) {
	for (int i = 0; i < items.length; i++) {
	    if (items[i] == target) {
		size--;
		for (int j = i; j < size - i; j++) {
		    items[j] = items[j + 1];
		}
	    }
	}
    }

    // determines if 2 bags contents are equal to each other
    public boolean equals(Bag other) {
	if (other.size != size) {
	    return false;
	}
	Bag temp = new Bag(size + other.size);
	temp.add(other);
	for (int i = 0; i < other.size; i++) {
	    temp.remove(other.items[i]);
	    temp.add(0);
	    temp.add(0);
	}
	temp.remove(0);
	return temp.isEmpty();
    }
}
