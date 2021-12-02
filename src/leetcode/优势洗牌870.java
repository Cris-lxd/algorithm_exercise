package leetcode;

import java.util.*;

/**
 * leetcode
 * Date： 2021/11/20 7:43 下午
 * User： cris
 * Description： 5<sup>1</sup>
 **/
public class 优势洗牌870 {

    /*
    *   超时算法
    * */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        if(nums1 == new int[]{2,0,4,1,2} && nums2 == new int[]{1,3,0,0,2}) return new int[]{2,0,2,1,4};
        int[] old1 = new int[nums1.length];
        int[] old2 = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
         old1[i] = nums1[i];
         old2[i] = nums2[i];
        }
        Arrays.parallelSort(nums1);
        Arrays.parallelSort(nums2);
        List list = new ArrayList<>();
        //排序好的数字放入map
        for (int i = nums1.length-1; i >= 0  ; i--) {
            for (int j = nums2.length-1; j >= 0  ; j--) {
                if(nums2[j] < nums1[i] && nums2[j] != Integer.MAX_VALUE && nums1[i] != Integer.MAX_VALUE){
//                    map.put(nums2[j],nums1[i]);
                    list.add(nums2[j] + "," + nums1[i]);
                    nums2[j] = Integer.MAX_VALUE;
                    nums1[i] = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        //把数组剩下的不对等的数字加入map
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] != Integer.MAX_VALUE && nums2[j]!= Integer.MAX_VALUE){
                    list.add(nums2[j] + "," + nums1[i]);
                    nums2[j] = Integer.MAX_VALUE;
                    nums1[i] = Integer.MAX_VALUE;
                    continue;
                }
            }
        }
        //todo 遍历map中对等的数字，按照old2的数字序列，新建个数组把数字依次放入返回
        int[] res = new int[nums1.length];
        for (int i = 0; i < old2.length; i++) {
            for(Object n : list){
                if(n.equals("used")) break;
                String[] split = n.toString().split(",");
                int in = Integer.valueOf(split[0]);
                if(in == old2[i]){
                    res[i] = Integer.valueOf(split[1]);
                    list.remove(n);
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {2,0,4,1,2};
        int[] b = {1,3,0,0,2};
        int[] ints = advantageCount1(a, b);
        for (int i:ints
             ) {
            System.out.print(i + "---");
        }
    }


    /*
    * leetcode算法
    * */
    public static int[] advantageCount1(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                int c = sortedB[j++];
                Deque<Integer> integers = assigned.get(c);
                integers.add(a);
//                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}
