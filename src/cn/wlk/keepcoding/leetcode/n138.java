package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 * <p>
 * 提示：
 * <p>
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解法：
 * 简单解法：
 * 同n133题，多了一个null的判断
 * 进阶解法：
 * 不使用额外的map空间：
 */
public class n138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 进阶解法：降低空间复杂度
     * 在旧节点后新建新节点，，然后改变旧节点的next指针，使之指向新节点，，即翻倍链表长度
     * 然后再依次修改新节点的random指针
     * 最后再依次修改各个节点的next，使两个新旧链表剥离出来
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node p = head;
        while (p != null) {
            Node newn = new Node(p.val);
            newn.next = p.next;
            p.next = newn;
            p = newn.next;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random!=null?p.random.next:null;
            p = p.next.next;
        }

        p = head;
        Node t ;
        Node reuslt = p==null?null:p.next;
        while (p != null) {
            t = p.next;

            p.next = p.next!=null?p.next.next:null;
            p = t;
        }
        return reuslt;
    }

    /**
     * 简单解法
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> node2node = new HashMap<>();
        createDfs(head, visited, node2node);
        linkBfs(head, node2node);
        return node2node.get(head);

    }

    public void createDfs(Node node, HashSet<Node> visited, HashMap<Node, Node> node2node) {
        if (!visited.contains(node)) {
            visited.add(node);
            node2node.put(node, new Node(node.val));
            if (node.next != null) {
                createDfs(node.next, visited, node2node);
            }
            if (node.random != null) {
                createDfs(node.random, visited, node2node);
            }
        }

    }

    public void linkBfs(Node node, HashMap<Node, Node> node2node) {
        HashSet<Node> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            Node n = queue.poll();
            if (!visited.contains(n)) {
                if (n.next != null) {
                    queue.add(n.next);
                    node2node.get(n).next = node2node.get(n.next);
                }
                if (n.random != null) {
                    queue.add(n.random);
                    node2node.get(n).random = node2node.get(n.random);
                }
                visited.add(n);
            }
        }
    }

    @Test
    public void t(){
//[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node result = copyRandomList(n0);
        System.out.println(result);
    }

}
