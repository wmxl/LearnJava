package LeetCode.不错的题.最大矩阵;

public class CanJump {

    /**
     * 方法1：dfs记忆化搜索
     */
    boolean ans = false;
    boolean[] vis;
    public boolean canJump1(int[] nums) {
        vis = new boolean[nums.length];
        jump(nums, 0);
        return ans;
    }
    void jump(int[] nums, int i) {
        if (ans || vis[i]) return;
        if (i >= nums.length - 1) {
            ans = true;
            return;
        }
        vis[i] = true;
        for (int j = 1; j <= nums[i]; j++) {
            jump(nums, i + j);
        }
    }


    /**
     * 方法2：贪心
     */
    public boolean canJump(int[] nums) {
        int max = 0;//能跳到的最远index
        for (int i = 0; i < nums.length; i++) {
            if(i > max) return false; //如果当前下标大于目前能到达的最远的下标，说明止步于此了
            max = Math.max(max, i + nums[i]); //更新能跳的最远下标
        }
        return true; //循环结束代表最后一个下标也达到了
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 0, 4};
        System.out.println(new CanJump().canJump(a));
    }


}
