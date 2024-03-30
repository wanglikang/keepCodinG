package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
//done

/**
 * 解法：使用迭代算法来模拟递归的函数调用，
 * 设两个栈，
 * 一个栈存储当前要处理的树节点，
 * 另一个栈存储对应当前树节点的处理状态，作用等同于函数的上下文
 */
public class n094 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackStatus = new Stack<>();
        TreeNode node;
        if (root != null) {
            stack.add(root);
            stackStatus.add(0);
            while (!stack.isEmpty()) {
                node = stack.peek();

                if (stackStatus.peek() == 0) {
                    stackStatus.pop();
                    stackStatus.add(1);

                    if (node.left != null) {
                        stack.add(node.left);
                        stackStatus.add(0);
                    }
                } else if (stackStatus.peek() == 1) {
                    result.add(node.val);
                    stackStatus.pop();
                    stackStatus.add(2);

                } else if (stackStatus.peek() == 2) {
                    stackStatus.pop();
                    stackStatus.add(3);

                    if (node.right != null) {
                        stack.add(node.right);
                        stackStatus.add(0);

                    } else {
                        stack.pop();
                        stackStatus.pop();
                    }
                } else if (stackStatus.peek() == 3) {
                    stack.pop();
                    stackStatus.pop();
                }

            }

        }
        return result;
    }

    @Test
    public void test() {
        n094 t = new n094();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        List<Integer> result = t.inorderTraversal(t1);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
