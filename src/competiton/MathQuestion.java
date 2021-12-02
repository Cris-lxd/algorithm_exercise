package competiton;

/**
 * competiton
 * Date： 2021/10/19 6:04 下午
 * User： cris
 * Description：  已知f1 = 1，f2 = 1，fn = af(n-1) + bf(n-2),求从begin相加到end，C排列组合的和，c上标为upSign，下标为fn
 **/
public class MathQuestion {
    public static int getFi(int n,int a,int b){
        if( n == 1 ){
            return 1;
        }
        if( n == 2){
            return 1;
        }
        return a*getFi(n-1,a,b) + b * getFi(n-2,a,b);
    }

    public static void calculate(int begin,int end,int a,int b,int upSign){
        Double sum = 0d;
        double downNum = 1;
        double upNum = 1;
        for (int i = begin; i <= end; i++) {
            int fi = getFi(i,a,b);
            for (int j = 1; j <= upSign; j++) {
                downNum *= j;
                upNum *= fi;
                fi --;
            }
            sum += upNum/downNum;
        }
        System.out.println(sum.intValue());
    }

    public static void main(String[] args) {
        calculate(5,30,1,1,1);
        System.out.println("end");
    }
}
