package BiShiTi.JinRiTouTiao;
/** 

* @author 飘渺阿光: 

* @version 创建时间：2019年6月30日 上午11:48:01 

* 类说明 
* DFS探索岛屿最大面积，以及岛屿个数

*/
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[3];

		while (sc.hasNextLine()){
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			a[0] = Integer.valueOf(ss[0]);
			a[1] = Integer.valueOf(ss[1]);
			a[2] = Integer.valueOf(ss[2]);
			boolean flag = false;
			int cnt = 0;
			while (cnt < 100000){
				sort(a);
//				System.out.println(Arrays.toString(a));
				if(a[0] == a[1]-1 && a[0] == a[2]-2)
					break;

				if(a[0] == a[1] || a[1] == a[2]){
					flag = true;
					break;
				}else {
					a[2] -= 2;
					a[0]++;
					a[1]++;
				}
			}
			System.out.println(flag);
		}
	}
}
/*
2 3 17
19 20 6
*/
