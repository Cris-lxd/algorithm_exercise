package leetcode;/**
  * leetcode
  * Date： 2021/12/2 2:57 下午
  * User： cris
  * Description： https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 **/
public class 三维形体的表面积_892 {

    public static int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int hide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j] == 0 ? 0 : grid[i][j]*4+2;      //求的总面积
                if(i > 0){      //前
                    if(grid[i-1][j] > 0){
                        hide += grid[i-1][j] > grid[i][j] ? grid[i][j] : grid[i-1][j];
                    }
                }
                if(i < m - 1){      //后
                    if(grid[i+1][j] > 0){
                        hide += grid[i+1][j] > grid[i][j] ? grid[i][j] : grid[i+1][j];
                    }
                }
                if(j > 0){      //左
                    if(grid[i][j-1] > 0){
                        hide += grid[i][j-1] > grid[i][j] ? grid[i][j] : grid[i][j-1];
                    }
                }
                if(j < n - 1){      //右
                    if(grid[i][j+1] > 0){
                        hide += grid[i][j+1] > grid[i][j] ? grid[i][j] : grid[i][j+1];
                    }
                }
            }
        }
        sum -= hide;
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        int sum = surfaceArea(a);
        System.out.println(sum);
    }
}
