package algorithm;

import java.util.*;

/**
 * PACKAGE_NAME
 * 2021/10/8 10:08 上午
 * cris
 * 紧凑格式求解方程（三角分解 + 紧凑求解）
 **/
public class SplitTriangle {

    /**
     * 矩阵三角分解
     * @param A
     * @return
     */
    public static Map triangle(double[][] A){
        Map<String, double[][]> map = new LinkedHashMap();
        try {
//            double[][] A = {{2, 2, 3}, {4, 7, 7}, {-2, 4, 5}};      //所求矩阵
            double[][] L = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};       //左矩阵
            double[][] U = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};       //右矩阵
            int n = A.length;       //几阶矩阵
            // 求第一行与第一列
            for (int j = 0; j < n; j++) {
                int i = j + 1;
                U[0][j] = A[0][j];
                if(i < n) {
                    L[i][0] = A[i][0] / U[0][0];
                }
            }

            //计算U的第r行，L的第r列
            for (int r = 1; r < n; r++) {
                for (int j = r; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k <= r - 1; k++) {
                        sum += L[r][k] * U[k][j];
                    }
                    U[r][j] = A[r][j] - sum;
                }

                for (int i = r + 1; i < n; i++) {
                    int sum = 0;
                    for (int k = 0; k <= r - 1; k++) {
                        sum += L[i][k]*U[k][r];
                    }
                    L[i][r] = (A[i][r] - sum)/U[r][r];
                }
            }
            map.put("A",A);
            map.put("L",L);
            map.put("U",U);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return map;
    }

    /**
     * 若A = LU ,则解方程组Ax = b 等价为 Ly = b， Ux = y ，x向量即为最终解
     * @return
     */
    public static double[] solution(){
        double[][] A = {{3,2,5},{-1,4,3},{1,-1,3}};
        Map triangle = triangle(A);
        double[][] L = (double[][])triangle.get("L");       //左矩阵
        double[][] U = (double[][])triangle.get("U");       //右矩阵
        double[] b = {6,5,1};
        double[] y = gety(L,b);       //Ly = b
        int n = L.length;
        //将U合并到L矩阵，变为紧凑格式
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                L[i][j] = U[i][j];
            }
        }
        //此时的L已经是紧凑格式
        double[] x = getx(U,y);      //Ux = y
        return x;
    }

    /**
     * 求解 矩阵*向量 = 向量   Ly = b
     * @param L
     * @param b
     * @return
     */
    public static double[] gety(double[][] L,double[] b){
        double[] y = {0,0,0};
        int n = L.length;
        y[0] = b[0];
        for (int i = 1; i < n; i++) {
            double sum = 0 ;
            for (int j = 0; j < i; j++) {
                double a = L[i][j];
                double c = b[j];
                sum += L[i][j] * y[j];
            }
            y[i] = b[i] - sum;
        }
        return y;
    }

    /**
     * 求解 矩阵*向量 = 向量   Ux = y
     * @param U
     * @param y
     * @return
     */
    public static double[] getx(double[][] U,double[] y){
        double[] x = {0,0,0};
        int n = U.length;
        x[n-1] = y[n-1]/U[n-1][n-1];      //得到第一个解
        for (int i = n-2; i >= 0 ; i--) {
            double sum = 0;
            for (int j = n-1; j > i ; j--) {
                sum += U[i][j] * x[j];
            }
            x[i] = (y[i] - sum)/U[i][i];
        }
        return x;
    }

    public static void main(String[] args) {
        double[] solution = solution();
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
}
