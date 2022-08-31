package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

public class Practice20_BitonicSearch_3lgN {

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 4, -1, -2, -3 };
        int[] array2 = { 1, 5, 4, 3, 2, 0 };
        int[] array3 = { 2, 4, 8, 16, 32, 1 };
        int[] array4 = { 2, 4, 8, 16, 32 };
        int[] array5 = { 2, 1 };
        int[] array6 = { 9 };
        // Test
        // int indexOfTippingIndex_1 = findTippingPoint(array1, 0, array1.length - 1);
        // StdOut.println(indexOfTippingIndex_1 == 3);
        int indexOfElement1 = bitonicSearch(array1, -1);
        int indexOfElement2 = bitonicSearch(array2, 5);
        int indexOfElement3 = bitonicSearch(array3, 2);
        int indexOfElement4 = bitonicSearch(array3, 99);
        int indexOfElement5 = bitonicSearch(array4, 32);
        int indexOfElement6 = bitonicSearch(array5, 1);
        int indexOfElement7 = bitonicSearch(array6, 9);

        StdOut.println("Index of element: " + indexOfElement1 + " Expected: 4");
        StdOut.println("Index of element: " + indexOfElement2 + " Expected: 1");
        StdOut.println("Index of element: " + indexOfElement3 + " Expected: 0");
        StdOut.println("Index of element: " + indexOfElement4 + " Expected: -1");
        StdOut.println("Index of element: " + indexOfElement5 + " Expected: 4");
        StdOut.println("Index of element: " + indexOfElement6 + " Expected: 1");
        StdOut.println("Index of element: " + indexOfElement7 + " Expected: 0");
    }

    private static int bitonicSearch(int[] array, int value) {
        int tippingIndex = findTippingPoint(array, 0, array.length - 1);
        int resultOnTheLeftHalf = ascendingBinarySearch(array, value, 0, tippingIndex);
        int result = -1;
        if (resultOnTheLeftHalf != -1) {
            result = resultOnTheLeftHalf;
        } else {
            int resultOnTheRightHalf = descendingBinarySearch(array, value, tippingIndex, array.length - 1);
            if (resultOnTheRightHalf != -1) {
                result = resultOnTheRightHalf;
            }
        }
        return result;
    }

    private static int findTippingPoint(int[] array, int low, int high) {
        if (low == high) {
            // 递归结束，找到目标数据，返回下标
            return low;
        }

        int mid = (low + high) / 2;
        // 检查左边界
        if (mid == 0) {
            if (array[mid] < array[mid + 1]) {
                return findTippingPoint(array, mid + 1, high);
            } else {
                return 0;
            }
        }

        if (mid == array.length - 2) {
            if (array[mid] <= array[mid + 1]) {
                return mid + 1;
            } else {
                return mid;
            }
        }
        if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
            return mid;
        } else if (array[mid] < array[mid - 1]) {
            return findTippingPoint(array, low, mid - 1);
        } else {
            return findTippingPoint(array, mid + 1, high);
        }
    }

    private static int ascendingBinarySearch(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (mid == value) {
            return mid;
        } else if (mid > value) {
            return ascendingBinarySearch(arr, value, low, mid - 1);
        } else {
            return ascendingBinarySearch(arr, value, mid + 1, high);
        }
    }

    private static int descendingBinarySearch(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (mid == value) {
            return mid;
        } else if (mid > value) {
            return descendingBinarySearch(arr, value, mid + 1, high);
        } else {
            return descendingBinarySearch(arr, value, low, mid - 1);
        }
    }
}