public class Client7 {

    public static void main(String[] args) {

        // construct and print list
	int[] data = {5, 3, 19, 7};
        ArrayIntList list = new ArrayIntList(10);
        for (int n : data) {
            list.add(n);
        }

        int [] array = list.toArray();
        System.out.println("list = " + list);
        System.out.println("list size = " + list.size());        
        System.out.print("array = " );
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        System.out.println("array.length = " + array.length);
    }
}
