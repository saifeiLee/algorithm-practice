package chapter1.section4;

public class Practice_1_4_18 {
    private static int NOT_FOUND = -1;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = localMinimum(arr);
        if (index == NOT_FOUND) {
            System.out.println("Not found");
        } else {
            System.out.println("Found local minimum value: " + index);
        }
    }
    private static int localMinimum(int[] array) {
        int low = 0;
        int high = array.length - 1;

        // N = 1
        if (array.length == 1) {
            return array[0];
        }

        // N = 2
        if (array.length == 2) {
            if (array[0] < array[1]) {
                return array[0];
            } else {
                return array[1];
            }
        }

        while (low <= high) {
            int middle = low + (high - low) / 2;

            // Corner case
            if (middle == 0) {
                if (array[middle] < array[middle+1]) {
                    return array[middle];
                } else {
                    return NOT_FOUND;
                }
            }

            // Corner case
            if (middle == array.length - 1) {
                if (array[middle] < array[middle - 1]) {
                    return array[middle];
                } else {
                    return NOT_FOUND;
                }
            }

            if (array[middle - 1] > array[middle] && array[middle + 1] > array[middle]) {
                return array[middle];
            } else if (array[middle - 1] < array[middle]) {
                high = middle - 1;
            } else if (array[middle + 1] < array[middle]) {
                low = middle + 1;
            }
        }
        return NOT_FOUND;
    }
}
