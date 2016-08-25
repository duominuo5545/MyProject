package com.rich.quickSort;

/**
 * Created by rich on 16/8/18.
 */
public class QuickSortTest {
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

    private static int partition(int a[], int low, int high) {
        int privotKey = a[low];                             //基准元素
        while (low < high) {                                   //从表的两端交替地向中间扫描
            while (low < high && a[high] >= privotKey) {
                --high;
            }//从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
            swap(a, low, high);
            while (low < high && a[low] <= privotKey) {
                ++low;
            }
            swap(a, low, high);
        }
        print(a, 10);
        System.out.println(low);
        return low;
    }


    private static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int privotLoc = partition(a, low, high);  //将表一分为二
            quickSort(a, low, privotLoc - 1);          //递归对低子表递归排序
            quickSort(a, privotLoc + 1, high);        //递归对高子表递归排序
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        quickSort(a, 0, 9);
        print(a, 10);
    }


    private static int my(int a[], int low, int high) {
        int initIndex = a[low];
        while (low < high) {
            if (low < high && initIndex <= a[high]) {
                high--;
            }
            swap(a, low, high);
            if (low < high && initIndex >= a[low]) {
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }
}
