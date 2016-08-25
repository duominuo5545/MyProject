package com.rich.quickSort;

import java.util.Arrays;

/**
 * Created by rich on 16/8/18.
 */
public class QuickSort2 {
    private static void print(int a[], int n) {
        for (int j = 0; j < n; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("end");
    }

    private static void swap(int[] a, int low, int high) {
        int tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int location = getLocation(a, low, high);
            quickSort(a, location + 1, high);
            quickSort(a, low, location - 1);
        }
    }

    private static int getLocation(int[] a, int low, int high) {
        int initValue = a[low];
        while (low < high) {
            while (low < high && initValue <= a[high]) {
                high--;
            }
            swap(a, low, high);
            while (low < high && initValue >= a[low]) {
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        quickSort(a, 0, 9);
        Arrays.stream(a).forEach((x)->{
            System.out.println(x+" ");
        });
        //print(a, 10);
    }
}