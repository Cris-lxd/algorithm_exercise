package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/17 12:40 下午
 * User： cris
 * Description： algorithm.选择排序
 **/
public class 选择排序 {

    public static void chooseSort(int[] a){
        int min = 0;        //记录最小数值
        int mark = 0;       //记录最小数的位置
        for (int i = 0; i < a.length; i++) {
            min = a[i];
            //找出a[i]之后最小的数
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < min){
                    min = a[j];
                    mark = j;
                }
            }
            //a[i]和a[i]之后最小的数做比较，如果后面更小则交换位置
            if(a[mark] < a[i]){
                a[mark] = a[i];
                a[i] = min;
            }
        }
        System.out.println("emnd");
    }

    public static void main(String[] args) {
        int a[] = {3,5,2,11,45,13,34,4};
        chooseSort(a);
    }
}
