public class Demo {
   
    public static void main (String [] args) {
        Bag b = new Bag(10);
        for (int i = 0; i < 20; i++)
	    b.add(i);

        System.out.println("b = " + b);
	System.out.println("grabbing from b: " + b.grab());
        System.out.println("b = " + b);

    }
}
