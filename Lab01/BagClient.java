public class BagClient {
   
    public static void main (String [] args) {

	// constructs a new Bag that can hold 15 integers
        System.out.println("Testing constructor Bag(), add(int n), printing");
	Bag b= new Bag();
	b.add(45);
	b.add(-7);
        System.out.println("b = " + b);

	Bag b2 = new Bag();
        System.out.println("b2 = " + b2);

        System.out.println("\nTesting size()");
	System.out.println("size of Bag b = " + b.size());
	System.out.println("size of Bag b2 = " + b2.size());

	System.out.println("\nTesting isEmpty()");
	if (b.isEmpty())
	    System.out.println("b is empty");
	else if (b2.isEmpty())
	    System.out.println("b2 is empty");
	else
	    System.out.println("Neither bag is empty");
	System.out.println("\nTesting add(Bag  b)");
	
	Bag b3 =  new Bag(20);
	// add 18 integers to Bag b3
	for (int  i  =  0;  i  <18;  i++)
	    b3.add(i*10);
	System.out.println("b3 = " +  b3);
	//  add  the  2  integers  from  Bag  b  to  Bag  b3
	b3.add(b);
	System.out.println("b3  =  "  +  b3);
	System.out.println("b  =  "  +  b);
	//  try  to  add  b  to  b3  AGAIN  (should  not  work)
	b3.add(b);
	System.out.println("b3  =  "  +  b3);

	System.out.println("\nTesting  remove(int  target)");
	Bag  b4  =  new  Bag(10);
	// add values
	b4.add(45);
	b4.add(-7);
	b4.add(8);
	b4.add(15);
	b4.add(-1);
	b4.add(14);
	b4.add(23);
	System.out.println("b4  =  "  +  b4);
	//  remove  15
	b4.remove(15);
	System.out.println("b4  =  "  +  b4);
	//  try  to  remove  something  that  is  not  in  Bag  b4
	b4.remove(999);
	System.out.println("b4  =  "  +  b4);

	System.out.println("\nTesting  equals(Bag  other)");
	Bag  b5  =  new  Bag(5);
	b5.add(12);
	b5.add(3);
	b5.add(7);
	b5.add(12);
	System.out.println("b5  =  "  +  b5);
	Bag  b6  =  new  Bag(5);
	b6.add(3);
	b6.add(7);
	b6.add(12);
	b6.add(12);
	System.out.println("b6  =  "  +  b6);
	System.out.println("b5  equal  to  b6?  "  +  b5.equals(b6));
	//  check  to  make  sure  b5  and  b6  are  unchanged
	System.out.println("b5  =  "  +  b5);
	System.out.println("b6  =  "  +  b6);
	System.out.println("b6  equal  to  b5?  "  +  b6.equals(b5));
	//  check  to  make  sure  b5  and  b6  are  unchanged
	System.out.println("b5  =  "  +  b5);
	System.out.println("b6  =  "  +  b6);
	//  add  something  to  b6
	b6.add(88);
	System.out.println("b5  =  "  +  b5);
	System.out.println("b6  =  "  +  b6);
	System.out.println("b5  equal  to  b6?  "  +  b5.equals(b6));
	System.out.println("b6  equal  to  b5?  "  +  b6.equals(b5));
	//  make  a  new  bag
	Bag b7  =  new  Bag(10);
	b7.add(7);
	b7.add(12);
	b7.add(12);
	b7.add(33);
	System.out.println("b5  =  "  +  b5);
	System.out.println("b7  =  "  +  b7);
	System.out.println("b5  equal  to  b7?  "  +  b5.equals(b7));
	System.out.println("b7  equal  to  b5?  "  +  b7.equals(b5));
	Bag  b8  =  new  Bag(10);
	b8.add(7);
	b8.add(12);
	b8.add(12);
	b8.add(3);
	b8.add(77);
	System.out.println("b5  =  "  +  b5);
	System.out.println("b8  =  "  +  b8);
	System.out.println("b5  equal  to  b8?  "  +  b5.equals(b8));
	System.out.println("b8  equal  to  b5?  "  +  b8.equals(b5));
    }
}
