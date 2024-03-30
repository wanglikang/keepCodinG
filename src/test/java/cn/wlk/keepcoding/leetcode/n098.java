package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */

//done

/***
 * 解题方法：
 *
 * 将二叉树中序遍历，若为二叉搜索树，则遍历结果应该为严格单调递增序列，
 * 对遍历后的数组依次判断即可
 */
public class n098 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int look(TreeNode root,int[] nums,int index){
        if(root==null)
            return index;

        if(root.left!=null){
            index = look(root.left,nums,index);
        }
        nums[index] = root.val;
        index++;
        if(root.right!=null){
            index = look(root.right,nums,index);
        }
        return index;


    }

    public boolean isValidBST(TreeNode root) {
        int[] nums = new int[100000];
        int index = 0;
        index = look(root,nums,index);
        for(int i = 0;i<index-1;i++){
            if(nums[i]>=nums[i+1])
                return false;
        }
        return true;

    }

    @Test
    public void test() {
        n098 t = new n098();
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(t.isValidBST(t1));
    }

}
