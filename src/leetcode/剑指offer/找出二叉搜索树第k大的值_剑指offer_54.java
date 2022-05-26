package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * date： 2022/5/13
 * time： 16:08
 * author： cris
 * description：
 **/
public class 找出二叉搜索树第k大的值_剑指offer_54 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }


    public int kthLargest(TreeNode root, int k) {
        List list = getList(root, new ArrayList<>());
        Collections.sort(list);
        return (int)list.get(list.size()-k+1);

    }

    public static List getList(TreeNode root,List list){
        list.add(root.val);
        if(root.left != null) getList(root.left,list);
        if(root.right != null) getList(root.right,list);
        return list;
    }

}
