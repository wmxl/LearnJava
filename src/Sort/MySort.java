package Sort;

import java.util.Arrays;

public class MySort {
    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void insertSort(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
            }
        }
    }

    static void bubbleSort_desc(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1])
                    swap(a, j, j + 1);
            }
        }
    }

    static void quickSort(int[] a, int left, int right) {
        if (left > right) return;
        int i = left, j = right, key = a[left];
        while (i != j) {
            while (a[j] >= key && i < j) j--;
            while (a[i] <= key && i < j) i++;
            if (i < j) swap(a, i, j);
        }
        a[left] = a[i];
        a[i] = key;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 9, 3, 2, 1, 7, 5, 8, 14};

        for (int i = 1; i < 5; i++) {
            int[] temp = a;
            switch (i) {
                case 1:
                    quickSort(temp, 0, a.length - 1);
                    System.out.println(Arrays.toString(temp));
                    break;
                case 2:
                    bubbleSort(temp);
                    System.out.println(Arrays.toString(temp));
                    break;
                case 3:
                    bubbleSort_desc(temp);
                    System.out.println(Arrays.toString(temp));
                    break;
                case 4:
                    insertSort(temp);
                    System.out.println(Arrays.toString(temp));
                    break;
            }
        }
    }
}
