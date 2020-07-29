package Array;

import java.util.Arrays;

public class Solution {
    //使用辅助数组
    public static void mergeArray(int a[], int first, int mid, int last) {
        int[] temp = new int[a.length];
        int i = first, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= mid)
            temp[k++] = a[i++];
        while (j <= last)
            temp[k++] = a[j++];
        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //空间复杂度O(1)
    public static void mergeArray2(int a[], int first, int mid, int last) {
        int temp;
        int i = first, j = mid + 1;
        while (i <= mid && j <= last) {
            if (a[i] <= a[j]) i++;
            else {
                swap(a, i, j);   //交换位置
                for (int k = j - 1; k > i; k--) {
                    swap(a, k, k + 1);
                }
                i++;
                j++;
            }
        }
        Arrays.sort(a, mid, last+1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = {1, 3, 5, 2, 4, 6};
//        sol.mergeArray(a, 0, 2, a.length - 1);
        sol.mergeArray2(a, 0, 2, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
