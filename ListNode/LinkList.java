/* Christopher Rose
Assignment Lab 4
Dr.Grabowski

This assignment is to utilize all the basic functions of a Linked List */
import java.util.*;

public class LinkList extends TestLinkList{

    // reference to the front of the list
    private ListNode front;

    // creates new linked list with null in the front
    public LinkList() {
        front = null;
    }

    // adds the given value to the end of the list
    public void add(int value) {
	if (front == null) {
	    front = new ListNode(value);
	} else {
	    ListNode current = front;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new ListNode(value);
	}
    }

    // adds the value to a specific index
    public void add(int index, int value) {
	if (index == 0) {
	    front = new ListNode(value, front);
	} else {
	    ListNode current = front;
	    for (int i = 0; i < index - 1; i++) {
		current = current.next;
	    }
	    current.next = new ListNode(value, current.next);
	}
    }

    // gives the size of the list
    public int size() {
	int s = 0;
	ListNode current = front;
	while (current != null) {
	    s++;
	    current = current.next;
	}
	return s;
    }

    // returns true if the list is empty
    public boolean isEmpty() {
	if (front == null) {
	    return true;
	}
	return false;
    }

    // returns the contents of the list
    public String toString() {
	String s = "";
	ListNode current = front;
	while (current != null) {
	    s = s + current.data;
	    current = current.next;
	}
	return s;
    }

    // returns the data at the given index
    public int get(int index) {
	ListNode current = front;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}
	return current.data;
    }

    // removes the value at the given index
    public void remove(int index) {
	if (index == 0) {
	    front = front.next;
	} else {
	    ListNode current = front;
	    for (int i = 0; i < index - 1; i++) {
		current = current.next;
	    }
	    current.next = current.next.next;
	}
    }
}
