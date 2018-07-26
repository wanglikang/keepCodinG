package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
//done

/**
 * 解题方法：因为是已经排好序的数组，转换为平衡二叉树后的根节点必定为原数组的中间元素，
 *          然后递归处理即可
 */
public class n108 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode build(int[] nums, int start, int end) {
        int len = (end - start);
        int mid = start + (end - start) / 2;
        if (end < start)
            return null;
        TreeNode tree = new TreeNode(nums[mid]);

        tree.left = build(nums, start, mid - 1);

        tree.right = build(nums, mid + 1, end);
        return tree;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length - 1;
        return build(nums, 0, len);

    }

    @Test
    public void test() {
        n108 t = new n108();
        System.out.println();
    }

}
