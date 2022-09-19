public class Client2 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 19, 0, 2, 4, 18};
        ArrayIntList list = new ArrayIntList(3);
        for (int n : data) {
            list.add(n);
        }
        System.out.println("Before, list = " + list);
        list.removeFront(4);
        System.out.println("After removing front 4, list = " + list);

        list.removeFront(3);
        System.out.println("After removing front 3, list = " + list);


    }
}
