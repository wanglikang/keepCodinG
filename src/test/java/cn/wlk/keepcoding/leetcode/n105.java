package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
//done
public class n105 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findIndex(int[] arr, int key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public TreeNode dealwith(int[] pre, int[] mid,
                             int preleft, int preright,
                             int midleft, int midright) {

        if (preright < preleft)
            return null;
        TreeNode result = new TreeNode(pre[preleft]);
        int index = findIndex(mid, pre[preleft], midleft, midright);
        int leftlen = index - midleft;
        int rightlen = midright - index;
        if (leftlen > 0)
            result.left = dealwith(pre, mid,
                    preleft + 1, preleft + leftlen,
                    midleft, index - 1);
        else result.left = null;
        if (rightlen > 0)
            result.right = dealwith(pre, mid,
                    preleft + leftlen + 1, preright,
                    index + 1, midright);
        else result.right = null;

        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        TreeNode result = dealwith(preorder, inorder, 0, len-1, 0, len-1);
        return result;
    }

    @Test
    public void test() {
        n105 t = new n105();
        int[] pre = {3, 9, 20, 15, 7};
        int[] mid = {9, 3, 15, 20, 7};
        TreeNode result = t.buildTree(pre, mid);
        showTree(result);
    }

    public void showTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            showTree(root.left);
            showTree(root.right);
        }
    }

}
