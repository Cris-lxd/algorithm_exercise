package leetcode;

/**
 * git
 * Date： 2021/11/7 3:16 下午
 * User： cris
 * Description： 598. 范围求和 II      给定一个初始元素全部为0，大小为 m*n 的矩阵M以及在M上的一系列更新操作。
 *
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整a 和 b 的数组表示，含义是将所有符合0 <= i < a 以及 0 <= j < b 的元素M[i][j]的值都增加 1。
 *
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class 范围求和 {

    //脑筋急转弯  最小的数乘最小的数
    public static int maxCount(int m, int n, int[][] ops) {
        if(ops.length > 0){
            int a = ops[0][0];
            int b = ops[0][1];
            for (int i = 0; i <ops.length; i++){

                a = ops[i][0] < a ? ops[i][0] : a;
                b = ops[i][1] < b ? ops[i][1] : b;
            }
            return a * b;
        }else{
            return m * n;
        }
    }

    //数组内存溢出
    public static int maxCount1(int m, int n, int[][] ops) {
        int sum = 0;
        int max = 0;
        int[][] M = new int[m][n];
        int a = 0;
        int b = 0;
        if(ops.length == 0){
            return m*n;
        }
        for(int i =0; i < ops.length; i++){
            a = ops[i][0];
            b = ops[i][1];
            if(a <=m && b <= m){
                for(int j =0; j < M.length; j++){
                    for(int k =0; k < M[j].length; k++){
                        if(j < a && k < b && j >= 0 && k >= 0){
                            M[j][k] += 1;
                        }
                    }
                }
            }
        }
        for(int i =0; i <M.length; i++){
            for(int j =0; j < M[i].length; j++){
                if(M[i][j] > max){
                    max = M[i][i];
                    sum = 1;
                }else if(M[i][j] == max){
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] ops = new int[][]{{2,2},{3,3}};
        maxCount(3,3,ops);
    }
}
