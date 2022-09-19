public class Client1 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 19, 0, 2, 4};
        ArrayIntList list = new ArrayIntList(5);
        for (int n : data) {
            list.add(n);
        }
        System.out.println("Before, list = " + list);
        ArrayIntList list2 = list.runningTotal();
        System.out.println("After, list = " + list);
        System.out.println("list2 = " + list2);

        list.clear();
        System.out.println("Before, list = " + list);
        list2 = list.runningTotal();
        System.out.println("After, list = " + list);
        System.out.println("list2 = " + list2);

    }
}
