package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/contest/weekly-contest-94/problems/leaf-similar-trees/
 * 考虑一个二叉树的所有叶子。这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，给定一个如上图所示的树，其叶值序列为 (6, 7, 4, 9, 8) 。
 * 如果两个二叉树的叶值序列相同，我们就认为它们是 叶相似的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，返回 true；否则返回 false 。
 * 提示：
 * 给定的两个树会有 1 到 100 个结点。
 */

//done
public class n872 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] arr1 = new int[102];
        int[] arr2 = new int[102];
        int len1 = runWithTree(arr1, 0, root1);
        int len2 = runWithTree(arr2, 0, root2);
        if(len1!=len2)
            return false;
        boolean result = true;
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i])
                result = false;
        }
        return result;
    }

    public int runWithTree(int arr[], int index, TreeNode root) {
        if (root.left != null) {
            index = runWithTree(arr, index, root.left);
        }
        if (root.right != null) {
            index = runWithTree(arr, index, root.right);
        }
        if (root.left == null && root.right == null) {
            arr[index] = root.val;
            index++;
            return index;
        }
        return index;
    }

    @Test
    public void test() {

    }

}
