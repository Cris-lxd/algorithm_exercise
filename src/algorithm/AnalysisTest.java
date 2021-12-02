package algorithm;

/**
 * PACKAGE_NAME
 * 2021/10/8 10:08 上午
 * cris
 * 高斯消去法求解初等矩阵
 **/
public class AnalysisTest {
    public static void main(String[] args) {
        double[][] array = {{1,1,1,6},{12,-3,3,15},{-18,3,-1,-15}};
        caclulate(array);
    }

    /**
     * 计算行列式
     * @param array
     */
    public static void caclulate(double[][] array){
        int flag = 0;       //代表进行第几次化简
        for (int i = 0; i < array.length-1; i++) {
            double times1 = 0;      //定义倍数关系
            for (int j = array.length - 1; j > i; j--) {
                if(i == flag){
                    times1 = array[j][i]/new Double(array[flag][i]);
                }
                //进行化简
                for (int k = i; k < array[0].length; k++) {
                    array[j][k] -= array[flag][k]*times1;
                }
            }
            flag++;
        }
        //计算x1～xn
        Double[] x = {0D,0D,0D};      //定义一个全为0的一维数组
        int col = array[0].length;
        int row = array.length;
        for(int i = row-1 ; i >= 0; i--) {
            double res = array[i][col-1];
            //依次减去项系数 * 该项
            for (int k = 0; k < x.length; k++) {
                res -= x[k] * array[i][k];
            }
            //上述求的得结果 / 所求项
            x[i] = Math.floor(res/array[i][i]);
            System.out.println("x" + (i+1) + "值为:" + x[i].intValue());
        }
    }
}
