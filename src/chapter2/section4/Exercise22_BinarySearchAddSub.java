package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise22_BinarySearchAddSub {
    private int binarySearch(int[] array, int key) {
        int fibonacciN = 1;
        int fibonacciBeforeN = 0;
        int aux = 0;
        while (fibonacciN < array.length - 1) {
            aux = fibonacciN;
            fibonacciN = fibonacciN + fibonacciBeforeN;
            fibonacciBeforeN = aux;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            while (fibonacciN > 0 && fibonacciN > high - low) {
                aux = fibonacciBeforeN;
                fibonacciBeforeN = fibonacciN - fibonacciBeforeN;
                fibonacciN = aux;
            }
            int elementToCheck = low + fibonacciBeforeN;
            if (key < array[elementToCheck]) {
                high = elementToCheck - 1;
            } else if (key > array[elementToCheck]) {
                low = elementToCheck + 1;
            } else {
                return elementToCheck;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

        Exercise22_BinarySearchAddSub exercise22_binarySearchAddSub = new Exercise22_BinarySearchAddSub();
        int index1 = exercise22_binarySearchAddSub.binarySearch(array, 2);
        StdOut.println("Is element in the array: " + (index1 != -1) + " Expected: true");
    }
}
