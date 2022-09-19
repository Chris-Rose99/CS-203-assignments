public class Client5 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 3, 19, 7};
        ArrayIntList list = new ArrayIntList(4);
        for (int n : data) {
            list.add(n);
        }

        System.out.println("Before, list = " + list);
        list.stretch(4);
        System.out.println("After stretching by 4,  list = " + list);

        System.out.println("Before, list = " + list);
        list.stretch(0);
        System.out.println("After stretching by 0,  list = " + list);


    }
}
