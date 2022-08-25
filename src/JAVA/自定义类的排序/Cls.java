package JAVA.自定义类的排序;

import java.util.Arrays;

class Cls implements Comparable<Cls> {
    double a;
    double b;
    int index;

    //假设a是分子，b是分母，按照分数大小排序
    public Cls(int index, double a, double b) {
        this.a = a;
        this.b = b;
        this.index = index;
    }

    //只要实现了这个接口，就可以用Arrays.sort()来排序
    @Override
    public int compareTo(Cls cls) {
        double a  = this.b / this.a - cls.b / cls.a;
        // 小于号就是按从小到大排序，大于号就是从大到小
        return a < 0? 1 : -1;
    }

    @Override
    public String toString() {
        return  a + "/" + b ;
    }

    public static void main(String[] args) {
        Cls[] cls = new Cls[3];
        cls[0] = new Cls(0, 3, 5);
        cls[1] = new Cls(0, 1, 2);
        cls[2] = new Cls(0, 2, 2);

        System.out.println(Arrays.toString(cls));
        Arrays.sort(cls);
        System.out.println(Arrays.toString(cls));
    }
}