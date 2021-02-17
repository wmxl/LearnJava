package 矩形问题.柱状图中最大的矩形;

import java.util.Stack;

public class Solution {
    //左右延伸法：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84zhu-zhuang-tu-zhong-zui-da-de-ju-xing-v1pv8/
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        int area, max = 0, last = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] == last) continue;
            area = 0;
            for (int j = i; j < len; j++) {
                if (heights[j] >= heights[i]) {
                    area += heights[i];
                } else break;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    area += heights[i];
                } else break;
            }
            max = Math.max(max, area);
            last = heights[i];
        }
        return max;
    }

    //固定高度，宽度不断增加法
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int area, max = 0, height, width;
        int h = 9999999;
        for (int i = 0; i < len; i++) {
            if (heights[i] < h) h = heights[i];
        }
        for (int i = 0; i < len; i++) {
            width = 0;
            height = 99999;
            for (int j = i; j < len; j++) {
                if (heights[j] == h) {
                    area = h * len;
                    max = Math.max(max, area);
                    break;
                }
                height = Math.min(height, heights[j]);
                width++;
                area = height * width;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    //单调栈
    public int largestRectangleArea(int[] heights1) {
        int len = heights1.length;
        int[] heights = new int[len+2];
        heights[0] = 0;
        heights[len+1] = 0;
        for (int i = 0; i < len; i++) {
            heights[i+1] = heights1[i];
        }

        int[] left = new int[len+1];
        int[] right = new int[len+1];
        Stack<Integer> stack = new Stack<>();
        int max = 0, last = 0;
        for (int i = 1; i <= len + 1; i++) {
            if(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    right[stack.pop()] = i;
                }
            }
            stack.add(i);
        }
        for (int i = len; i >= 0; i--) {
            if(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    left[stack.pop()] = i;
                }
            }
            stack.add(i);
        }
        for (int i = 1; i <= len; i++) {
            if(heights[i] == heights[last]) continue;
            int area = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(max, area);
            last = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 5, 6, 5, 2, 3};
        int[] a1 = {1,2,2};
        int[] a2 = {2,4};
        int[] a3 = {2, 1, 5, 6, 2, 3};
        int[] a4 = {2, 1, 2};
        System.out.println(new Solution().largestRectangleArea(a1));
    }
}