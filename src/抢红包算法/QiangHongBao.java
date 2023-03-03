package 抢红包算法;

public class QiangHongBao {
    /*
    total为红包总量(分)，n为抢红包人数
    返回int类型数组，单位为分
     */
    public int[] groupRedPack(int total, int n){
        int remainder = total;
        int[] redPackGroup = new int[n];
        for (int i = 0; i < n - 1; i++) {
            redPackGroup[i] = random(0, remainder); //随机从大于0且小于剩余量之间
            remainder = total - redPackGroup[i];
        }
        redPackGroup[n-1] = remainder;
        return redPackGroup;
    }

    public int random(int a, int b){
        //some detail
        return 0;
    }

    /*
    红包存在一个int数组中，表示多少分。当发红包的人点击发红包之后，就执行分红包的算法,生成红包数组。然后第i个抢红包的人得到redPack[i-1]里的数额。

    存储红包设计两个表：红包表和红包分组表
    红包表包括：id，发红包人userId，红包总量
    红包分组表包括：红包id，组号，抢红包人userId，金额。红包id相同的所有记录的金额加起来应该等于红包表id相同的那条记录的红包总量
    分红包算法执行完后，就将红包分组信息存入DB，开始时，抢红包人的userId为null，等有人来抢的时候，就更新红包分组表，把抢红包的人的userId代替null。如果超时没有人领剩余红包，
    就把发红包的人的userId更新上去，代表钱会退回发红包的人账号里。

    需要注意的点：
    1 抢红包的时候是多线程并发，要保证线程安全，可以把红包分组这个资源上锁来保证线程安全。
    2 目前的抢红包算法是比较粗的，没有考虑如果前面的分组金额过大，导致后面没钱可分的状态，如一共100分钱，分3个人，第一次就分了99分，后面两个人分1分钱没法分。
    具体解决办法可以设定一个上限，这个上限保证后面的人不会出现无钱可分的情况，一种方法是假设最后一个人分1分钱，倒数第二个人分2分钱，依次推到第一个人，看他最多可以分多少钱，后面的类似
     */
}
