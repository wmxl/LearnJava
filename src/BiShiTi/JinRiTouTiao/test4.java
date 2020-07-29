package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:51:00 

* 类说明 
a区间最大<b区间最小，输出满足条件的个数
*/
public class test4 {

	public int compare(int[][] array) {
		int count=0;
		int max;int min;
		for(int i=0;i<array.length;i++) {
			max=array[i][0];
			min=array[i][1];
			for(int j=i;j<array.length;j++) {
				if(array[i][0]<array[j][0]) {
					max=array[j][0];
				}
				if(array[i][1]>array[j][1]) {
					min=array[j][1];
				}
				if(max<min) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated fatherMethod stub
		int[][] array = new int[3][2];
		
		array[0][0]=3;
		array[0][1]=3;
		array[1][0]=2;
		array[1][1]=3;
		array[2][0]=1;
		array[2][1]=3;
		
		test4 ts = new test4();
		System.out.println(ts.compare(array));
	}

}
