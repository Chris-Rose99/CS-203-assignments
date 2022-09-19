import java.util.*;

public class Four {

    public static void main (String [] args) {

	//        testDeleteBack();
	//        testLastIndexOf();

    }


    public static LinkedIntList generateRandom(int first, int last) {

        Random rand = new Random();
        LinkedIntList list = new LinkedIntList();
        // generate a random length from first to last
        int listLength = rand.nextInt(last-first+1) + first;
        // make a linked list of this length filled with values 1 to listLength
        for (int i = 1; i <= listLength; i++) {
	    list.add(i);
	}
        return list;
    }

    /*
    public static void testDeleteBack() {
        LinkedIntList list = generateRandom(10, 15);
        // testing deleteBack
        System.out.println("TESTING deleteBack()...");
        System.out.println("list = " + list);
        System.out.println("last element = " + list.deleteBack());
        System.out.println("list = " + list);
        list = new LinkedIntList();
        list.add(99);
        System.out.println("list = " + list);
        System.out.println("last element = " + list.deleteBack());
        System.out.println("list = " + list);
        try {
	    list.deleteBack();
	} catch (NoSuchElementException e) {
            System.out.println(e);
	}
        System.out.println();
    }
    */
    /*
    public static void testLastIndexOf() {
        System.out.println("TESTING lastIndexOf()...");
        int [] a = {12, 18, 4, 18, 18, 27};
        LinkedIntList list = new LinkedIntList();
        for (int elt : a) {
	    list.add(elt);
	}
        System.out.println("list = " + list);  
        System.out.println("list.lastIndexOf(18) = " + list.lastIndexOf(18));
        System.out.println("list.lastIndexOf(12) = " + list.lastIndexOf(12));
        System.out.println("list.lastIndexOf(27) = " + list.lastIndexOf(27));
        System.out.println("list.lastIndexOf(49) = " + list.lastIndexOf(49));
        list = new LinkedIntList();
        list.add(44);
        System.out.println("list = " + list);  
        System.out.println("list.lastIndexOf(44) = " + list.lastIndexOf(44));
        System.out.println("list.lastIndexOf(49) = " + list.lastIndexOf(49));
        list = new LinkedIntList();
        System.out.println("list = " + list);  
        System.out.println("list.lastIndexOf(49) = " + list.lastIndexOf(49));
        System.out.println();
    }
    */
}
