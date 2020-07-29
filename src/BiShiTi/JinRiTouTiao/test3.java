package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:05:04 

* 类说明 
* 个人积分相等，团队积分最大

*/
public class test3 {
	
	public int sort(int[][] array){
		int suma=0;
		int suma2=0;
		int sumb=0;
		int sumb2=0;
		int sum=0;
		int max=0;
		for(int k=0;k<array.length;k++) {
			suma=array[k][0];
			suma2=array[k][1];
			sumb=0;
			sumb2=0;
			for(int j=k+1;j<array.length;j++) {
				sumb=sumb+array[j][0];
				sumb2=sumb2+array[j][1];
				if(suma==sumb) {
					sum=suma2+sumb2;
					if(max<sum) {
						max=sum;
					}
					
				}
			}
		}
		suma=0;
		suma2=0;
		sumb=0;
		sumb2=0;
		sum=0;
		for(int i=0;i<array.length;i++) {
			suma=suma+array[i][0];
			suma2=suma2+array[i][1];
			sumb=0;
			sumb2=0;
			for(int j=i+1;j<array.length;j++) {
				sumb=sumb+array[j][0];
				sumb2=sumb2+array[j][1];
				if(suma==sumb) {
					sum=suma2+sumb2;
					if(max<sum) {
						max=sum;
					}
					
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated fatherMethod stub
		int[][] array = new int[4][2];
		
		array[0][0]=3;
		array[0][1]=1;
		array[1][0]=2;
		array[1][1]=2;
		array[2][0]=1;
		array[2][1]=4;
		array[3][0]=1;
		array[3][1]=4;
		
		test3 ts = new test3();
		System.out.println(ts.sort(array));
	}

}
