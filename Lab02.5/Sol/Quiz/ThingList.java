public class ThingList {
  
    // fields
    Thing[] items;

    // Constructor
    public ThingList (int capacity) {
        items = new Thing[capacity+1];
        items[0] = new EndThing();
    }
  
    // Parameter: obj - object to add to this list
    // Postcondition: obj appended to the end of this list
    public void add (Object obj) {
        ensureCapacity();
	Thing t = new Thing(obj);
        // FINISH ADD() HERE FOR THIS CHECKPOINT
        int i = 0; 
        while (!items[i].isLast())
	    i++;
        items[i+1] = items[i];
        items[i] = t;
    }    

    // WRITE ISEMTPY() HERE FOR THIS CHECKPOINT
    // Returns: true if this list is empty, false o/w
    public boolean isEmpty() {
	return items[0].isLast();
    }

    // WRITE SIZE() HERE FOR THIS CHECKPOINT
    // Returns: number of items in this list
    public int size() {
	if (isEmpty())
	    return 0;
	int count = 1;
        while (!items[count].isLast())
	    count++;
	return count;
    }



    // WRITE TOSTRING() HERE FOR THIS CHECKPOINT
    // Returns: A String representation of the ThingList
    public String toString() {
        if (this.isEmpty())
	    return "[]";
	String result = "["+items[0];
        int i = 1;
        while (!items[i].isLast()) {
	    result += ", "+ items[i];
	    i++;
	}
	result +="]";
	return result;
    }

    // WRITE REMOVE() HERE FOR THIS CHECKPOINT
    // Returns: The last item of this list after is have been removed
    // Postcondition: List has one less item. Item removed is the last one.
    // Throws: IllegalStateException if remove() is called on an empty list.
    public Thing remove() {
	if (this.isEmpty())
	    throw new IllegalStateException();
	int i = 0;
        while (!items[i].isLast())
	    i++;
	Thing result = items[i-1];
	items[i-1] = items[i];
	return result;
    }



    // Postcondition: capacity of ThingList has doubled if there is no
    //                more room to add elements
    private void ensureCapacity() {
        if (items[items.length-1] == null)
	    return;
	Thing[] temp = new Thing[items.length*2 -1];
        for (int i =0; i < items.length; i++)
	    temp[i] = items[i];
	items = temp;
    }
    
}
