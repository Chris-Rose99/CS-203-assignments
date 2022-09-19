import java.util.*;

public class Three {

    public static void main (String [] args) {

        ListNode list = generateRandom(15, 25);
	printList(list);
        addAtEnd(list, 999);
	printList(list);
        System.out.println();

        list = generateRandom(15, 25);
        printList(list);
        makeAll(list, 99);
        printList(list);
        System.out.println();

        list = generateRandom(4, 12);
        printList(list);
        setLast(list, 999);
        printList(list);
        System.out.println();

    }

    public static void setLast(ListNode current, int value) {
	while (current.next != null)
	    current = current.next;
        current.data = value;       
    }


    public static void makeAll(ListNode current, int value) {
	while (current != null) {
	    current.data = value;
            current = current.next;
	}
    }


    public static void addAtEnd(ListNode current, int value) {
	while (current.next != null)
	    current = current.next;
        current.next = new ListNode(value);
    }

    public static ListNode generateRandom(int first, int last) {

        Random rand = new Random();
        // generate a random length from first to last
        int listLength = rand.nextInt(last-first+1) + first;
        // make a linked list of this length filled with values 1 to listLength
        ListNode list = null;
        for (int i = listLength; i > 0; i--) {
	    list = new ListNode(i, list);
	}
        return list;
    }

    public static void printList(ListNode current) {
	while (current != null) {
	    System.out.print(current.data + " ");
            current = current.next;
	}
        System.out.println();
    }
}
