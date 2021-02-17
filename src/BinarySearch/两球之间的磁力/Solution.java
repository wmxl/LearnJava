package BinarySearch.两球之间的磁力;

import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, h = 1000_000_000, ans = 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (check(position, m, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int m, int mid) {
        int last = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[last] >= mid) {
                last = i;
                m--;
                if (m == 1) return true;
            }
        }
        return false;
    }
}