package 剑指Offer.clockwisePrintMatrix;

import java.util.ArrayList;
public class Solution {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static ArrayList<Integer> list = new ArrayList<Integer>();

    static class StopMsgException extends RuntimeException {//通过抛异常来强制跳出递归
    }

    static public void dfs(int x, int y, int [][] matrix, int w, int h, int now, int len){
        if(list.size() == w*h)
        {
            System.out.println("jump");
            throw new StopMsgException();
        }


        if(x >= h || y >= w || x < 0  || y < 0) return;
        System.out.print(x+ ",");
        System.out.println(y);
        if(matrix[x][y] == 123456789) return;

        list.add(matrix[x][y]);

        System.out.println(matrix[x][y]);
        matrix[x][y] = 123456789;
        for (int i = now; i < len; i++) {
//            System.out.println("now = " + now);
            dfs(x + dx[i%4],y + dy[i%4], matrix, w, h, i%4 ,len);
        }
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        list.clear();

        int h = matrix.length;
        int w = matrix[0].length;
        int len = h*w/2;

        System.out.println("w = " + w);
        System.out.println("h = " + h);

        try{
            dfs(0,0, matrix, w, h, 0,len);
        }catch (Exception e) {
            return list;
        }finally {
            return list;
        }

    }

    public static void main(String[] args) {
        int[][] intMat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        int[][] intMat2 = {
                {1,2},
                {3,4},
        };
        int[][] intMat3 = {
                {1},
                {2},
                {3}
        };

        System.out.println(new Solution().printMatrix(intMat));
    }
}