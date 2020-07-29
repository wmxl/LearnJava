package BiShiTi.HuanJuShiDai;


import java.util.*;
import java.lang.Math;

public class Main2 {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] strs = input.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int num = Integer.valueOf(strs[i]);
        }

        int lenghth = nums.length;
        int cnt = 0;
        ListNode head = new ListNode(nums[0]);
        ListNode rear = head;
        for(int i = 1; i < lenghth; i++ ){
            int num = nums[cnt++];
            rear.next = new ListNode(num);
            rear = rear.next;
        }
        rear.next = null;
        ListNode p = head;
        cnt  = 0;
        while(p != null){
            if(lenghth % 2 == 1){
                if(cnt == lenghth/2)
                    System.out.println(p.val);
            }
            if(lenghth % 2 == 0){
                if(cnt == lenghth/2-1)
                    System.out.println(p.val);
            }
            p = p.next;
            cnt++;
        }

//        if(nums.length % 2 == 1)
//            System.out.println(nums[nums.length/2]);
//        else
//            System.out.println(nums[nums.length/2-1]);
    }
}
/*
0 2 4 6 8 10 12 14 16
 */