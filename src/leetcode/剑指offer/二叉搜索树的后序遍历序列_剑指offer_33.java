package leetcode.剑指offer;

/**
 * date： 2022/5/12
 * time： 13:28
 * author： cris
 * description：二叉搜索树 ： 1.右节点最大，左节点最小，根节点中等,即根节点左面的字节点都比他小，右边的都比他大
 **/
public class 二叉搜索树的后序遍历序列_剑指offer_33 {
    public static boolean verifyPostorder(int[] postorder) {
        boolean res =  getLoop(0,postorder.length-1,postorder);
        return res;
    }

    public static boolean getLoop(int begin,int end,int[] a){
        if(end <= begin) return true;
        int mid = begin;
        while(a[mid] < a[end])   mid++;
        int p = mid;
        while(a[p] > a[end])    p++;
        return p==end && getLoop(begin,mid-1,a) && getLoop(mid,p-1,a);
    }

    public static void main(String[] args) {
        boolean b = verifyPostorder(new int[]{1,6,3,2,5});
        System.out.println(b);
    }
}
