// CIS 203 Computer Science II
// Author: L. Grabowski, based on S. Reges.
// Last update: 26 February 2019
//
// ListNode is a class for storing a single node of a linked
// list.  This node class is for a list of integer values.

public class ListNode {
    public int data;        // data stored in this node
    public ListNode next;   // link to next node in the list

    // Post: constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }
    
    // Parameter: data, the integer value to be stored
    // Post: constructs a node with given data and null link
    public ListNode(int data) {
        this(data, null);
    }

    // Parameters: data, the integer value to be stored,
    //             next, the link to set next to
    // Post: constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
