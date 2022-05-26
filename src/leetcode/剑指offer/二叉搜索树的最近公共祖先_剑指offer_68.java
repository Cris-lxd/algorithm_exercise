package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * date： 2022/5/22
 * time： 17:18
 * author： cris
 * description：
 **/
public class 二叉搜索树的最近公共祖先_剑指offer_68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        List<TreeNode> path_p = getRoad(root, p.val);
        List<TreeNode> path_q = getRoad(root, q.val);
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static List<TreeNode> getRoad(TreeNode root, int num) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        while (node.val != num) {
            list.add(node);
            if (node.val > num) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        list.add(node);
        return list;
    }
}
