package BinarySearch.basic;

import java.io.*;

public class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h){
            int m = (l + h) / 2;
            if(target < nums[m]){
                h = m -1;
            }else if(nums[m] < target){
                l = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static int erFenFind(int[] a, int e) {
        int low = 0, high = a.length - 1, ans;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (e < a[mid]) high = mid - 1;
            else if (a[mid] < e) low = mid + 1;
            else {
                System.out.println("ss");
                ans = mid;
                for (int i = mid + 1; i < a.length; i++) if (a[i] == a[i - 1]) ans++; else break;
                return ans;
            }
        }
        System.out.println(high);
        ans = high;
        for (int i = high + 1; i < a.length; i++) if (a[i] == a[i - 1]) ans++; else break;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] ss = s.split(" ");
        int len = ss.length;
        int[] input = new int[len - 1];
        for (int i = 0; i < len - 1; i++) input[i] = Integer.parseInt(ss[i]);
        int e = Integer.parseInt(ss[len - 1]);
        System.out.println(erFenFind(input, e));
    }


}
/*
3 4 5 7 7 8 8 8 10 9
3 4 5 7 7 8 8 10 10 9
3 4 5 7 7 8 8 10 10 5
3 4 5 7 7 8 8 10 10 3
3 4 5 7 7 8 8 10 10 10
 */