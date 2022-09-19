// Class ArrayIntList can be used to store a list of integers.

import java.util.*;

public class ArrayIntList {

    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 10;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // CHECKPOINT 1-2:
    // pre: capacity >=0
    // returns: new ArrayIntList that is the running total of this list
    public ArrayIntList runningTotal () {
	ArrayIntList result = new ArrayIntList(elementData.length);
        if (size > 0)
	   result.add(get(0));
        for (int i =1; i< size; i++)
	    result.add(result.get(i-1) + get(i));
        return result;
    }


    // CHECKPOINT 3
    // parameter: n the number of elements to remove
    // post: the first n elements have been removed from this list
    //       the list is cleared if n >= than the list size.
    public void removeFront(int n) {
	if (n >= size()) {
	    clear();
            return;
	}
        for (int i = 0; i < n ; i++)
	    remove(0);
    }

    // CHECKPOINT 4
    // post: the elements in the list have doubled. new elements are the old
    //       elements in reverse order
    public void mirror() {
        for (int i = size-1; i >=0; i--)
	    add(get(i));
    }

    // CHECKPOINT 5
    // parameter: n - a value to remove all occurrences of 
    // post: all occurrences of n have been removed from the list
    public void removeAll(int n) {
        int i = indexOf(n);
	while (i >= 0) {
	    remove(i);
            i = indexOf(n);
	}
    }

    // CHECKPOINT 6
    // parameter: n - number of copies to have of each element in this list
    // post: all occurrences of n have had (n-1) copies added next to them
    //       if n <= 0 the list is empty
    /*    public void stretch(int n) {
	if (n <=0) {
	    clear();
            return;
	}
        int currentSize = size;
        for (int i =0; i < currentSize; i++) {
            int value = get (n*i);
            for (int j = 0; j < n-1; j++)
                add(n*i, value);
	}
	}*/
    public void stretch (int n) {
	if (n <=0) {
	    clear();
            return;
	}
	for (int i = size-1; i >= 0; i--) {
	    for (int j = 1; j <= n-1; j++)
		this.add(i, this.get(i));
	}
    }

    // CHECKPOINT 7
    // parameter: other - another ArrayIntList that will be compared to this 
    //                    list
    // returns: true if the two lists have the same elements in the same order
    //          and are the same size, false otherwise
    public boolean equals(ArrayIntList other) {
	if (size != other.size)
	    return false;
        for (int i = 0; i < size; i++)
            if (get(i) != other.get(i))
		return false;
        return true;
    }

    // CHECKPOINT 8
    // returns: an array of ints version of this ArrayIntList, the length
    //          of the array should  be equal to the size of the list
    public int [] toArray() {
        int [] result = new int[size];
        for (int i =0; i < size; i++)
	    result[i] = get(i);
        return result;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: returns an iterator for this list
    public ArrayIntListIterator iterator() {
        return new ArrayIntListIterator(this);
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity <= elementData.length)
	    return;
        // we don't have room
        int newCapacity = elementData.length * 2 + 1;
        if (capacity > newCapacity)
                newCapacity = capacity;
        int [] temp = new int[newCapacity];
        for (int i = 0; i < size; i++)
	    temp[i] = elementData[i];
        elementData = temp;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
