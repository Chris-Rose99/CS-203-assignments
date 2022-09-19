// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList {

    // first value in the list
    private ListNode front; 
    // size of list
    private int size;

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
	return size;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        // if the list is empty
        if (front == null) {
            return "[]";
        } 
        // otherwise
        String result = "[" + front.data;
        ListNode current = front.next;
        while (current != null) {
               result += ", " + current.data;
               current = current.next;
        }
        result += "]";
        return result;
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        size++;
        // if this is the only node in this list
        if (front == null) {
            front = new ListNode(value);
            return;
        } 
        // otherwise, we need to put the new node at the end of the list
        ListNode current = front;
        while (current.next != null) {
               current = current.next;
        }
        current.next = new ListNode(value);
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        size++;
        if (index == 0) {
            // put the new node at the front
            front = new ListNode(value, front);
        } else {
            // get the node just this node will link to
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        size--;
        // if we are removing the front ndoe
        if (index == 0) {
            front = front.next;
        } else {
            // get the node that the node we are removing is linked to
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
