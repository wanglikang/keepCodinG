package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
//done

/**
 * 使用两个栈进行操作
 */
public class n103 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void left2right(Stack<TreeNode> queue1, Stack<TreeNode> queue2, List<List<Integer>> result) {
        List<Integer> re = new ArrayList<>();
        TreeNode node;
        while (!queue1.isEmpty()) {
            node = queue1.pop();
            re.add(node.val);
            if (node.left != null)
                queue2.add(node.left);
            if (node.right != null)
                queue2.add(node.right);

        }
        if(re.size()>0)
            result.add(re);

    }

    public void right2left(Stack<TreeNode> queue1, Stack<TreeNode> queue2, List<List<Integer>> result) {
        List<Integer> re = new ArrayList<>();
        TreeNode node;
        while (!queue1.isEmpty()) {
            node = queue1.pop();
            re.add(node.val);
            if (node.right != null)
                queue2.add(node.right);
            if (node.left != null)
                queue2.add(node.left);
        }
        if(re.size()>0)
            result.add(re);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> queue1 = new Stack<>();
        Stack<TreeNode> queue2 = new Stack<>();
        boolean b = true;
        if (root != null) {
            queue1.add(root);
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                left2right(queue1, queue2, result);
                right2left(queue2, queue1, result);
            }
        }

        return result;
    }

    @Test
    public void test() {
        n103 t = new n103();
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        List<List<Integer>> result = t.zigzagLevelOrder(t3);
        for (List<Integer> re : result) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

}
