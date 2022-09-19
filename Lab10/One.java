public class One {

    public static void main (String [] args) {
        // a)
	ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next = new ListNode(3);
        printList(list);
        // b)
	list = new ListNode(1);
        list.next = new ListNode(2);
        list.next = new ListNode(3, list.next);
        printList(list);
        // c)
	list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list = new ListNode(4, list.next.next);
        printList(list);
        // d)
	list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.data = 7;
        printList(list);


    }

    public static void printList(ListNode current) {
	while (current != null) {
	    System.out.print(current.data + " ");
            current = current.next;
	}
        System.out.println();
    }
}
