package JianZhiOffer.clockwisePrintMatrix;
import java.util.ArrayList;
public class Solution1 {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int h = matrix.length;
        int w = matrix[0].length;

        int x = 0, y = 0, dir = 0, nx, ny, cnt = 0;
        while(true){
            if(cnt == h*w)
                break;
            if(matrix[x][y] != -1111){
                arrayList.add(matrix[x][y]);
                cnt++;
            }
            matrix[x][y] = -1111;
            nx = x + dx[dir];
            ny = y + dy[dir];
            if(nx <= h -1 && ny <= w -1 && nx >= 0 && ny>=0 && matrix[nx][ny] != -1111) {
                x = nx;
                y = ny;
            }else{
                dir++;
                dir = dir % 4;
            }
        }
        return arrayList;
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
        System.out.println(new Solution1().printMatrix(intMat));
    }
}