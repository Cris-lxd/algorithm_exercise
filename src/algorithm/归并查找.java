package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/17 1:56 下午
 * User： cris
 * Description： 归并查找一个序列中的最大元素
 **/
public class 归并查找 {

    //分割
    public static void sort(int[] a,int low, int high) {
        if(low == high){
            return;
        }
        int mid = (high + low)/2 == 0 ? (high + low)/2 : (high + low)/2+1;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,low,mid,high);
    }


    //对已排序好的左右数组进行合并
    public static void merge(int[] a,int low,int mid,int high) {
        int i = low;
        int j = mid;
        int k = 0;
        int[] end = new int[a.length];
        while (i < mid && j < high) {
            if (a[i] <= a[j]) {
                end[k] = a[i];
                i++;
                k++;
            } else {
                end[k] = a[j];
                j++;
                k++;
            }
        }
        //把最后某个数组剩下的数字直接填放到数组中
        while(i <mid) end[k++] = a[i++];
        while (j<high) end[k++] = a[j++];
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,10,2,4,6,8,9,11};
        merge(a,0,5,a.length);
    }
}
