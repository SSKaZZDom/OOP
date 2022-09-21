package ru.nsu.vlomakin;

/**
 * My heapsort algorithm realization
 */
public class Heapsort {
    /**
     * main class with one simple test
     */
    public static void main(String[] args) {
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] test = {3, 10, 7, 6, 9, 4, 1, 8, 2, 5};
        heapsort(test, 10);
        int flag = 0;
        for (int i = 0; i < 10; i++) {
            if (test[i] != result[i]) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Not bad.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    /**
     * This method applies heapsort to the array with n integer numbers
     * @param arr - array we need to sort
     * @param n - number of array elements
     */
    public static void heapsort(int[] arr, int n) {
        int swap;
        for (int i = (n + 1) / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        for (int j = n; j > 1; j--) {
            swap = arr[0];
            arr[0] = arr[j - 1];
            arr[j - 1] = swap;
            heapify(arr, 0, j - 1);
        }
    }

    static void heapify(int[] arr, int idx, int n) {
        int right = 2 * idx + 2;
        int left = 2 * idx + 1;
        int max = idx;
        int swap;

        if (right < n && arr[max] < arr[right]) {
            max = right;
        }
        if (left < n && arr[max] < arr[left]) {
            max = left;
        }
        if (max != idx) {
            swap = arr[max];
            arr[max] = arr[idx];
            arr[idx] = swap;
            heapify(arr, max, n);
        }
    }
}