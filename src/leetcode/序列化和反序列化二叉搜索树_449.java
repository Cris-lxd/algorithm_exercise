package leetcode;

import javafx.scene.control.Alert;
import leetcode.剑指offer.两个链表的第一个公共节点_offer_52;

import java.util.ArrayList;
import java.util.List;

/**
 * date： 2022/5/11
 * time： 10:40
 * author： cris
 * remark：
 **/
public class 序列化和反序列化二叉搜索树_449 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        两个链表的第一个公共节点_offer_52.ListNode next;
        TreeNode(int x) { val = x; }
    }

    /**
     * 将tree序列化为字符串  decodes your tree to string
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        List list = new ArrayList();
        loop(list,root);
        StringBuilder s  = new StringBuilder("[");
        for (Object o : list) {
            s = s.append(o + ",");
        }
        s.replace(s.length()-1,s.length(),"]");
        return s.toString();
    }

    public static List loop(List list,TreeNode root){
        list.add(root.val);
        if(root.left != null) loop(list,root.left);
        if(root.right != null) loop(list,root.right);
        return list;
    }


    /**
     * 将字符串序列化为tree   decodes your string to tree
     * @param data
     * @return
     */
    public String deserialize(String data) {
        return null;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);
        String res = serialize(node1);
        System.out.println(res);
    }
}
