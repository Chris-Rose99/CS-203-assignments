public class QuickInsertSort implements Sorter {

    // field
    public static final int THRESHOLD = 1000;
    private int [] a;
    int comps = 0;
    int moves = 0;

    public QuickInsertSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the mergesort algorithm.
    public  void sort() {
	quickSort(0, a.length);
        System.out.println("Comparisons: " + comps +
                           " Data moves: " + moves);
    }
    
    // Parameters: first - first position to start sorting at
    //             n - number of values to sort starting from "first"
    public void quickSort(int first, int n) {
        // if we are sorting one or fewer places, it's sorted!!!!
        comps++;
        if (n <= THRESHOLD) {
	    insertionSort(first, n);
	    return;
	}

        // partition the n items around the item in a[first] (the pivot)
        // and return where a[first] is now located
        int pivotIndex = partition(first, n);
 
        // get the size of the pieces on either side of the pivot
        int n1 = pivotIndex - first;
        int n2 = n - n1 - 1;

        // and quicksort the two pieces on either side of the pivot
        quickSort(first, n1);
        quickSort(pivotIndex+1, n2);
    }

    // Parameters: first - first position  in the position (also the pivot)
    //             n - number of values to partition
    // Postcondition: a[first]-a[pivotIndex-1] <= a[pivotIndex] 
    //                a[pivotIndex] < a[pivotIndex+1]-a[first + n]
   private  int partition(int first, int n)  {
       int pivotIndex = first;
       int last = first + n - 1;
       int pivotValue = a[first++];
       while (first <= last) {
	   while (first <= last && a[first] <= pivotValue) {
                first++;
                comps+=2;
	   }
           comps+=2;
	   while (last >= first && a[last] > pivotValue) {
               last--;
                comps+=2;
	   }
           comps+=2;
           if (first < last)  {
	       swap(first, last);
               moves += 3;
	   }
       }
       swap(pivotIndex, last);
       moves += 3;
       return last;
   }

    public  void swap(int i, int j) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }


    public  void insertionSort(int first, int n) {
        for (int i = first+1; i < first + n; i++) {
            // find where to insert a[i] in the first i-1 sorted values
            // while shifting other values right to make space for a[i]
            moves++;
            int temp = a[i];
            int insertPosition = findPosition(temp, i, first);
            a[insertPosition] = temp;
            moves++;
	}
    }
    
    // Parameters: value - to insert
    //             n - number of values in the sorted part of the array
    //             
    // returns position to insert value in the first n sorted values
    public int findPosition (int value, int n, int first){
	for (int i = n-1; i >= first; i--) {
            comps++;
            if (a[i] <= value) {
		return i+1;
	    }
            a[i+1] = a[i]; moves++;
	}
        return first;
    }

}
