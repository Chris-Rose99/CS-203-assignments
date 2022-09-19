/* Christopher Rose
Assignment Lab 4
Dr.Grabowski

This is to test LinkList. */

public class TestLinkList {

    public static void main(String[] args) {
	// creating a new list
	LinkList list = new LinkList();
	
	// checking to see that it's empty
	System.out.println("Is this List Empty?? " + list.isEmpty());
	System.out.println("So it's currently: " + list.toString());
	System.out.println();
	
	// adding some values and testing get method
	for (int i = 1; i < 5; i++) {
	    list.add(i);
	}
	System.out.println("I added some values: " + list.toString());
	System.out.println("Is it empty now??: " + list.isEmpty());
	System.out.println();
	System.out.print("From back to front: ");
	for (int i = list.size() - 1; i >= 0; i--) {
	    System.out.print(list.get(i));
	}
	System.out.println();
	
    	// adding digits into the middle of the list
	list.add(3, 9);
	list.add(1, 6);
	System.out.println("Now the list reads (after adding): " + list.toString());

	// removing half the list
	for (int i = 0; i <= list.size() / 2; i++) {
	    list.remove(0);
	}
	System.out.println("Now the list reads (after removing): " + list.toString());

	// just to make sure the rest does work
	System.out.println("The size is: " + list.size());
	System.out.println("Is it Empty: " + list.isEmpty());
	System.out.println("Whats the value at 2: " + list.get(2));
    }
}
