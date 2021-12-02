package algorithm;

/**
 * PACKAGE_NAME
 * 2021/10/13 6:14 下午
 * cris
 * algorithm.插入排序，时间复杂度O（n^2）
 **/
public class 插入排序 {

    public static int[] insertionSort(int[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {           //n
            if(a[i] < a[i-1]){
                for (int j = 0; j < i; j++) {           //n
                    if(a[j] > a[i]){
                        int 暂时存值 = a[i];
                        a[i] = a[j];
                        a[j] = 暂时存值;
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {6,4,1,8,5};
        int[] ints = insertionSort(a);
        System.out.println(ints.toString());
    }
}
