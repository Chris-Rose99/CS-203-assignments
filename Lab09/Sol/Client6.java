public class Client6 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 3, 19, 7};
        ArrayIntList list = new ArrayIntList(10);
        for (int n : data) {
            list.add(n);
        }

        ArrayIntList list2 = new ArrayIntList(10);
        for (int n : data) {
            list2.add(n);
        }
 
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);

        System.out.println("list.equals(list2)? " + list.equals(list2));
        System.out.println("list2.equals(list)? " + list2.equals(list));

        list.remove(3);
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        System.out.println("list.equals(list2)? " + list.equals(list2));
        System.out.println("list2.equals(list)? " + list2.equals(list));

        list.add(99);
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        System.out.println("list.equals(list2)? " + list.equals(list2));
        System.out.println("list2.equals(list)? " + list2.equals(list));
    }
}
