package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/13 6:47 下午
 * User： cris
 * Description： algorithm.快速排序（最好n，最差n^2，平均logn）
 **/
public class 快速排序 {

    public static void quickSort(int[] a,int begin,int end){
        int i = begin;
        int j = end;
        if(begin < end) {
            int mark = a[begin];
            while (i < j) {
                while (a[j] >= mark && j > i) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (a[i] < mark && j > i) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
                a[i] = mark;
            }
            quickSort(a, begin, i - 1);     //这里i位置所在的数字前面的比他小，后面的比他大，已经没必要动他了，所以不许将i进行排序
            quickSort(a, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {4,7,2,3,5};
        quickSort(a,0,a.length -1);
        System.out.println(a);
    }
}
