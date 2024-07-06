package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
//done

/**
 * 解法：
 *      序列化：使用后序遍历树，以[节点值，左子树索引，右子树索引]#[,,]#[,,]的形式进行存储
 *      反序列化：对序列化进行逆操作即可，
 *      注意判断输入树为空的情况(null)
 */
public class n297 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class node {
        public int val;
        public int left;
        public int right;

        public node(int val) {
            this.val = val;
            this.left = -1;
            this.right = -1;
        }

        @Override
        public String toString() {
            return "[" + this.val + "," + this.left + "," + this.right + "]";
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        List<node> list = new ArrayList<>();

        int rootindex = encode(root, list, 0);
        for (node n : list) {
            sb.append(n.toString() + "#");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public int encode(TreeNode root, List<node> list, int index) {
        if (root == null)
            return -1;
        int len = list.size();
        node n = new node(root.val);
        int nextIndex = index;
        if (root.left != null) {
            nextIndex = encode(root.left, list, nextIndex);
            n.left = nextIndex;
            nextIndex++;
        }
        if (root.right != null) {
            nextIndex = encode(root.right, list, nextIndex);
            n.right = nextIndex;
            nextIndex++;
        }
        list.add(n);
        return nextIndex;
    }

    public TreeNode decode(String[] nodes, int last) {
        if (nodes.length == 0)
            return null;
        if (last < 0)
            return null;
        //   System.out.println(nodes[last] + ":" + nodes[last].substring(1, nodes[last].length() - 1));
        String strs[] = nodes[last].substring(1, nodes[last].length() - 1).split(",");
//        System.out.println(strs[0] + " " + strs[1] + " " + strs[2]);
        int val = Integer.parseInt(strs[0]);
        int leftIndex = Integer.parseInt(strs[1]);
        int rightIndex = Integer.parseInt(strs[2]);
        TreeNode node = new TreeNode(val);
        node.left = decode(nodes, leftIndex);
        node.right = decode(nodes, rightIndex);
        return node;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        System.out.println("deserialize.data:"+data);
        if (data.length() == 0)
            return null;
        String[] nodes = data.split("#");
//        for (String s : nodes)
//            System.out.println(s);
//        System.out.println("*************");
        int len = nodes.length;
        return decode(nodes, len - 1);
    }

    @Test
    public void test() {
        n297 t = new n297();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;
        String result = t.serialize(t1);
        System.out.println(result);
        System.out.println("----------");

        TreeNode root = t.deserialize(result);
        t.showTree(root);
    }

    public void showTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            showTree(root.left);
        System.out.print(root.val + " ");
        if (root.right != null)
            showTree(root.right);
    }

}
