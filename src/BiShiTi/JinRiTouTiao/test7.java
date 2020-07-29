package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:54:17 

* 类说明 
* 所有人数都关注的个数

*/
public class test7 {

	public static void update(int a,int b,int[][] array) {
		
		for(int i=0;i<array.length;i++) {
			if(array[a][i]==1 && array[b][i]!=1) {
				array[b][i]=1;
				update(b,i,array);
			}
		}
	}
	
	public int find(int [][]array) {
		int cnt = 0;
		for (int i = 0; i < array.length; i++)
		{
			int gz = 1;
			for (int j = 0; j < array.length; j++)
			{
				if (array[i][j]==0 && i != j){
					gz = 0;
					break;
				}
			}
			if (gz==1)
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated fatherMethod stub
		
		int[][] array = new int[3][3];		
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				array[i][j]=0;
			}
		}
		array[0][1]=1;
		array[1][0]=1;
		array[2][1]=1;
		test7 ts = new test7();
		update(1,0,array);
		update(0,1,array);
		update(1,2,array);
		System.out.println(ts.find(array));
		
	}

}
