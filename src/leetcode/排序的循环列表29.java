package leetcode;

/**
 * leetcode
 * Date： 2021/11/20 6:47 下午
 * User： cris
 * Description：
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4ueAj6
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class 排序的循环列表29 {

    public static Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node cur = head;
        Node next = head.next;
        while(cur.val < next.val){
            cur = cur.next;
            next = next.next;
            if(cur == next) break;
        }
        Node realNode = next;
        cur = next;     //这是真的头节点
        while(cur.val < insertVal){
            cur = cur.next;
            next = next.next;
            if(next == realNode) break;
        }
        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = next;
        return head;

    }

    public static void main(String[] args) {
        Node a = new Node(3);
        a.next = a;
        a.next.val = 1;
        insert(a,1);


    }

}


class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
