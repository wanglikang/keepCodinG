package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 133. 克隆图
 * <p>
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clone-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：先dfs一遍建立新节点，并建立新旧节点的映射
 *       再一次bfs遍历，将通过旧节点的边关系建立新节点间的边映射
 */
public class n133 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> node2node = new HashMap<>();
        createDfs(node, visited, node2node);
        visited = new HashSet<>();
        linkBfs(node, node2node);
        return node2node.get(node);
    }

    public void createDfs(Node node, HashSet<Node> visited, HashMap<Node, Node> node2node) {
        if (!visited.contains(node)) {
            visited.add(node);
            node2node.put(node, new Node(node.val, new LinkedList<Node>()));
            for (Node n : node.neighbors) {
                createDfs(n, visited, node2node);
            }
        }
    }

    public void linkBfs(Node oldNode, HashMap<Node, Node> node2node) {
        HashSet<Node> visited = new HashSet<>();
        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(oldNode);
        while (queue.size() > 0) {
            Node n = queue.poll();
            if (!visited.contains(n)) {
                for (Node on : n.neighbors) {
                    node2node.get(n).neighbors.add(node2node.get(on));
                    queue.add(on);
                }
                visited.add(n);
            }
        }
    }

    @Test
    public void t() {
        Node n1 = new Node(1, new LinkedList<>());
        Node n2 = new Node(2, new LinkedList<>());
        Node n3 = new Node(3, new LinkedList<>());
        Node n4 = new Node(4, new LinkedList<>());
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        n133 n = new n133();
        Node result = n.cloneGraph(n1);
        System.out.println(result);

    }
}
