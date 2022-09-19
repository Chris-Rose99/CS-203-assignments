import java.util.*;

public class TryThing {
    public static void main (String [] args) {

        Thing[] things = {new Thing(new Object()), new EndThing()};
        for (int i = 0; i < things.length; i++) {
	    System.out.println(things[i]);
	    System.out.println(things[i].isLast());
	    System.out.println();
	}
    }
}
