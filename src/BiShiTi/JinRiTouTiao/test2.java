package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:49:45 

* 类说明 
区间合并
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 		test2 {

	public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
			return intervals;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		ArrayList<int[]> res = new ArrayList<>();
		int len = intervals.length;
		for(int i = 0 ; i < len  ; i ++) {
			int[] temp = new int[2];
			temp[0] = intervals[i][0];
			temp[1] = intervals[i][1];
			while(i < len - 1 &&temp[1] >= intervals[i + 1][0]) {//寻找本区间的可合并区间，有的话就合并
				temp[1] = Math.max(temp[1],intervals[i + 1][1]);
				i++;//标记到下一个待确认区间
			}
			res.add(temp);
		}
        int[][] arr = new int[res.size()][2];
        res.toArray(arr);
        return arr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated fatherMethod stub


		int[][] array = new int[7][2];
		int a[][];
		
		array[0][0]=1;
		array[0][1]=10;
		array[1][0]=32;
		array[1][1]=45;
		array[2][0]=78;
		array[2][1]=94;
		array[3][0]=5;
		array[3][1]=16;
		array[4][0]=80;
		array[4][1]=100;
		array[5][0]=200;
		array[5][1]=220;
		array[6][0]=16;
		array[6][1]=32;
		
		
		test2 ts2=new test2();
		a = ts2.merge(array);

		for(int x=0;x<a.length;x++) {
			if(x<a.length-1)
			{
				System.out.print(a[x][0]);
				System.out.print(",");
				System.out.print(a[x][1]);
				System.out.print(";");
			}else {
				System.out.print(a[x][0]);
				System.out.print(",");
				System.out.println(a[x][1]);
			}
			
		}
	}

}
