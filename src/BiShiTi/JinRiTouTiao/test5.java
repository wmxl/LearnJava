package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:53:34 

* 类说明 
* 去除多少个区间，保证没有重复区间

*/
import java.util.Arrays;

public class test5 {

	public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (b1,b2)->b1[0]-b2[0]);
        
        // greedy
        int count = 0;
        int end =  intervals[0][1];;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            }
            else end = Math.max(end, intervals[i][1]);
            
        }
        
        return intervals.length-count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated fatherMethod stub
		
		int[][] array = new int[3][2];
		
		array[0][0]=0;
		array[0][1]=5;
		array[1][0]=2;
		array[1][1]=7;
		array[2][0]=6;
		array[2][1]=9;
		
		test5 ts = new test5();
		System.out.println(ts.eraseOverlapIntervals(array));
	}

}
