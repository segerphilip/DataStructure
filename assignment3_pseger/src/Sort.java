/**
 * Created by Philip and Jason on 2/15/16
 * Paragraph description:
 *      sortArray goes through the array arrayA.
 *      Starting from the last value, it checks the previous
 *      value to see if it is greater. If so, the new value
 *      is set as the max, and the two swap positions based
 *      on index in the array. The output is an array where
 *      the values are in ascending order (i.e. 1, 1, 3, 3, 9)
 *
 *      swap takes the array arrayA and the index to switch,
 *      then creates a temp array with the switched values in
 *      it, which is then saved.
 */

public class Sort {

    /*
    * sorts the integers in the input array in increasing order
    */
    public static void sortArray (int[] arrayA) {
        int maxNum;    // maximum integer so far
        int maxIndex;  // index of maximum integer
        int i, j;
        for (j = arrayA.length - 1; j > 0; j--) {
            maxIndex = 0;
            maxNum = arrayA[0];
            for (i = 1; i <= j; i++)
                if (arrayA[i] > maxNum) {
                    maxNum = arrayA[i];
                    maxIndex = i;
                }
            swap(arrayA, maxIndex, j);
        }
    }

    /**
     * exchanges the contents of locations i and j in the input array
     */
    private static void swap (int[] arrayA, int i, int j) {
        int temp = arrayA[i];
        arrayA[i] = arrayA[j];
        arrayA[j] = temp;
    }

}

