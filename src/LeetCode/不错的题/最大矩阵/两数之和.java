package LeetCode.不错的题.最大矩阵;
import java.util.*;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(target - nums[i]))
                return new int[]{i, hash.get(target - nums[i])};
            hash.put(nums[i], i);
        }
        return ans;
    }
}
