public class Client4 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 3, 19, 3, 3, 4, 18};
        ArrayIntList list = new ArrayIntList(6);
        for (int n : data) {
            list.add(n);
        }
        System.out.println("Before, list = " + list);
        list.removeAll(3);
        System.out.println("After removing all 3s,  list = " + list);

        list.clear();
        System.out.println("Before, list = " + list);
        list.removeAll(7);
        System.out.println("After removing all 7s, list = " + list);

    }
}
