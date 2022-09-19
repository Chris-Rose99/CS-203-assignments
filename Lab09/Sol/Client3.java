public class Client3 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 19, 0, 2, 4, 18};
        ArrayIntList list = new ArrayIntList(6);
        for (int n : data) {
            list.add(n);
        }
        System.out.println("Before, list = " + list);
        list.mirror();
        System.out.println("After mirror, list = " + list);

        list.clear();
        System.out.println("Before, list = " + list);
        list.mirror();
        System.out.println("After mirror, list = " + list);

    }
}
