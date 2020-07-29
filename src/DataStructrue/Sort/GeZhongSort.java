package DataStructrue.Sort;

import java.util.Arrays;

public class GeZhongSort {
    public void swap(int[]arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }
    //选择排序
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // 记录最小元素位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j; // 更换最小元素位置
                }
            }

            if (min != i) {
                //swap(arr, i, min); // 与第i个位置进行交换
            }
        }
    }
    /**
     * 直接插入排序
     * @date 2018-10-18
     * @param arr
     */
    public static void sort1(int arr[]){
        int temp;
        int j;
        for(int i = 1;i<arr.length;i++){
            temp = arr[i];
            for(j = i;j > 0 && temp <arr[j-1];j--){
                arr[j] = arr[j-1];	//前一个较大的元素换到 j 下标位置
            }
            arr[j] = temp;	//上述条件不满足时的 j 下标位置就是temp适合的位置，temp保存元素插入到此
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void sheelSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//分组
                for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                    int k=j-len;//k为有序序列最后一位的位数
                    int temp=a[j];//要插入的元素

                    while(k>=0&&temp<a[k]){//从后往前遍历
                        a[k+len]=a[k];
                        k-=len;//向后移动len位
                    }
                    a[k+len]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序
     * @date 2018-10-18
     * @param arr
     */
    public static void sort3(int arr[]){
        int len=arr.length;
        for(int i=0;i<len;i++){//循环次数
            int min=arr[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(arr[j]<min){
                    min=arr[j];
                    position=j;
                }
            }
            arr[position]=arr[i];//进行交换
            arr[i]=min;
        }
    }

    /**
     * 冒泡排序
     * @date 2018-10-18
     * @param arr
     */
    public static void sort2(int arr[]){
        int temp;
        int j;
        for(int i = 0;i<arr.length-1;i++){	//n个数要循环n-1趟
            for(j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j + 1]){	//比后一个元素大，就交换两数位置
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //下面是快速排序，分两部分
    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low,int high)
    {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high)
        {
            while(low < high && numbers[high] > temp)
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }

    /**
     *
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }

    }



    public static void main(String[] args) {
        int[] arr = {8, 3, 19, 0, -99, 4, 6, 24, 92, 9, -18, 33};

        quickSort(arr, 0, 11);
        System.out.println(Arrays.toString(arr));

    }
}
