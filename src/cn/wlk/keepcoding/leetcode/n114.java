package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/29 10:29
 * author:WLK
 * <p>
 * 114. 二叉树展开为链表
 * <p>
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 * <p>
 * 将其展开为：
 * <p>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 解法：参考别人的代码，十分简洁的递归
 */
public class n114 {

    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        n114 t = new n114();
    }

    public void flatten(TreeNode root) {
        if(root==null)return;
        if(root.left!=null)   flatten(root.left);
        if(root.right!=null)  flatten(root.right);
        if(root.left!=null){
            TreeNode tmp=root.left;
            while(tmp.right!=null)tmp=tmp.right;
            tmp.right=root.right;
            root.right=root.left;
            root.left=null;
        }
    }
}