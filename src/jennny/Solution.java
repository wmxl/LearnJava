package jennny;

class Solution {
    int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        System.out.println("result = " + result);
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {//和前一个比
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }

            if (i < n - 1) {//和后一个比
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            System.out.println("count = " + count);
            r = Math.max(r, count);
        }
        return result + r;
    }

    public static void main(String[] args) {
        int[] a = {1,1,0,1,0,0};
        int[] a1 = {1,1,1,0,0};
        int[] a2 = {1,1,1,0,0};
        int[] a3 = {1,1,1,1,1};
        Solution s = new Solution();
        int ans = s.solution(a3);
        System.out.println(ans);
    }
}
