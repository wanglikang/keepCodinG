package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/7-17:08
 * author:WLK
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 解法：序列化使用中序遍历，反序列化逆操作
 * 序列号的结果示例：1,2,4,5,#,#,4,#,#,5,3,#,#,2,#,#,3,6,1,#,#,#,7,#,#
 * #为占位符，表示null节点
 */
public class Solution61 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    @Test
    public void test() {
        Solution61 t = new Solution61();
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 2, 1};
//        int[] nodes = {1};

        TreeNode root = t.array2Tree(nodes);
//        TreeNode root = null;
        String serialize = t.Serialize(root);
        System.out.println(serialize);
        TreeNode deroot = t.Deserialize(serialize);
        System.out.println("-----------------");
        t.showMid(deroot);
    }

    public void showMid(TreeNode root) {
        if (root == null)
            return;
        showMid(root.left);
        System.out.print(root.val + " ");
        showMid(root.right);

    }

    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        showTree(root, sb);
        if (sb.toString().length() > 0)
            sb.delete(sb.length() - 1, sb.length());
        else return "";
        return sb.toString();
    }

    public void showTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("");
            return;
        }
        sb.append(root.val + ",");

        if (root.left != null) {
            showTree(root.left, sb);
        } else sb.append("#,");

        if (root.right != null) {
            showTree(root.right, sb);
        } else sb.append("#,");
    }

    public TreeNode Deserialize(String str) {
        if (str.length() < 1) {
            return null;
        }
        String[] values = str.split(",");

        TreeNode root = new TreeNode(-1);
        decode(root, values, 0);
        return root;
    }

    //应该确保root不为null
    int decode(TreeNode root, String[] values, int index) {
        if (index >= values.length) {
            return -1;
        }

        if (values[index].equals("#")) {
            root.left = null;
            return index + 1;
        } else {
            root.val = Integer.parseInt(values[index]);
            int left = index + 1;
            int right = index + 2;
            int end = index + 3;
            if (values[left].equals("#")) {
                root.left = null;
                right = index + 2;
            } else {
                TreeNode leftnode = new TreeNode(-1);
                right = decode(leftnode, values, left);
                root.left = leftnode;
            }

            if (values[right].equals("#")) {
                root.right = null;
                return right + 1;
            } else {
                TreeNode rightnode = new TreeNode(-1);
                end = decode(rightnode, values, right);
                root.right = rightnode;
            }
            return end;
        }
    }

    public TreeNode array2Tree(int[] arr) {
        int len = arr.length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; i < len; i++) {
            if (2 * i + 1 < len) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if (2 * i + 2 < len) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }
}