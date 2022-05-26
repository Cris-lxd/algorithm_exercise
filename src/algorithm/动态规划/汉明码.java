package algorithm.动态规划;

/**
 * algorithm.动态规划
 * Date： 2021/12/13:29 下午
 * User： cris
 * Description：
 **/
public class 汉明码 {
    public static int getNum(int[] array){
        int[] num = new int[100];
        num[0] = 1;
        int a = 0,b = 0,c = 0;
        for (int i = 1; i <= 6 ; i++) {
            num[i] = Math.min(array[0]*num[a],Math.min(array[1]*num[b],array[2]*num[c]));
            if(num[i] == array[0]*num[a]) a++;
            if(num[i] == array[1]*num[b]) b++;
            if(num[i] == array[2]*num[c]) c++;
        }
        return num[6];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,5};
        int num = getNum(a);
        System.out.println(num);

    }
}
