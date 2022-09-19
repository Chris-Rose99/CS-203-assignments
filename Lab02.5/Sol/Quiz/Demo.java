import java.util.*;

public class Demo {
    public static void main (String [] args) {

        testAddAndIsEmpty();
        testSize();
	testToString();
        testRemove();

    }

    public static void testAddAndIsEmpty() {
	System.out.println("*** Testing add() and isEmpty()....");
	System.out.println("Constructing empty list.");
        ThingList list = new ThingList(5);
        System.out.println("Is list empty? " + list.isEmpty());
	System.out.println("Adding 1 Object to list.");
        list.add(new Object());
        System.out.println("Is list empty now? " + list.isEmpty());
	System.out.println("Adding 7 Objects to list.");
	for (int i =0; i < 7; i++)
            list.add(new Object());
        System.out.println("Is list empty now? " + list.isEmpty());
	System.out.println();
    }

    public static void testSize() {
	System.out.println("*** Testing size()....");
	System.out.println("Constructing empty list.");
        ThingList list = new ThingList(5);
        System.out.println("Size of this list? " + list.size());
        System.out.println("Adding 1 thing to this ThingList....");
	list.add(new Object());
        System.out.println("Size of this list? " + list.size());
        int n = new Random().nextInt(10)+1;
        System.out.println("Adding " + n + " more things to this ThingList...");
        for (int i = 0; i < n; i++)
	    list.add(new Object());
        System.out.println("Size of this list now? " + list.size());
	System.out.println();
    }

    public static void testToString() {
	System.out.println("*** Testing toString()....");
	System.out.println("Constructing empty list.");
        ThingList list = new ThingList(5);
        System.out.println("list =  " + list);
        System.out.println("Adding 1 thing to this ThingList....");
	list.add(new Object());
        System.out.println("list =  " + list);
        int n = new Random().nextInt(10)+1;
        System.out.println("Adding " + n + " more things to this ThingList...");
        for (int i = 0; i < n; i++)
	    list.add(new Object());
        System.out.println("list =  " + list);
	System.out.println();


    }

    public static void testRemove() {
	System.out.println("*** Testing remove()....");
	System.out.println("Constructing empty list.");
        ThingList list = new ThingList(5);
        try {
	    list.remove();
	} catch (IllegalStateException e) {
            System.out.println(e + " thrown and caught here");
	}
        System.out.println("Adding 1 thing to this ThingList....");
	list.add(new Object());
        System.out.println("list =  " + list);
        System.out.println("Removing this one thing...");
        System.out.println("Thing removed is " + list.remove());
        System.out.println("list =  " + list);
        int n = new Random().nextInt(8)+3;
        System.out.println("Adding " + n + " things to this ThingList...");
        for (int i = 0; i < n; i++)
	    list.add(new Object());
        System.out.println("list =  " + list);
        System.out.println("Removing one list thing...");
        System.out.println("Thing removed is " + list.remove());
        System.out.println("list =  " + list);
        System.out.println("Removing rest of list things one at a time and printing...");
        while (!list.isEmpty())
	    System.out.println(list.remove());
        System.out.println("list =  " + list);
	System.out.println();


    }


}
















