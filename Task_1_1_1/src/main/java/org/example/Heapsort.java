package org.example;

public class Heapsort {
    public static void heapsort (int arr[], int n){
        // Первая сортировка - вынос максимального элемента в arr[0]
        int swap;
        for (int i = (n+1)/2 - 1; i >=0; i--){
            heapify(arr, i, n);
        }
        // Наибольший элемент перемещается на последнее не зафиксированное место и фиксируется
        // После чего просеивается элемент, который оказался в arr[0]
        for (int j = n; j>1; j--) {
            swap = arr[0];
            arr[0] = arr[j-1];
            arr[j-1] = swap;
            heapify(arr,0,j-1);
        }
    }
    //Просеивание элемента лежащего в arr[idx] вниз
    static void heapify (int arr[], int idx, int n){
        int right = 2*idx+2;
        int left = 2*idx+1;
        int max = idx, swap;

        if (right < n && arr[max] < arr[right]) {
            max = right;
        }
        if (left < n && arr[max] < arr[left]) {
            max = left;
        }
        if (max != idx){
            swap = arr[max];
            arr[max] = arr[idx];
            arr[idx] = swap;
            heapify(arr, max,n);
        }
    }
}