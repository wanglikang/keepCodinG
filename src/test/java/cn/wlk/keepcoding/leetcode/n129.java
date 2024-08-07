package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/29 10:48
 * author:WLK
 *
 * 129. 求根到叶子节点数字之和
 *
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 解法1 :
 *  深度优先搜索
 * 解法2：
 *  广度优先搜索，需要使用两个队列
 *
 */
public class n129 {
    //      Definition for a binary tree node.
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
        n129 t = new n129();
    }
    public int sumNumbers(TreeNode root) {
        int[] result = new int[]{0};
        if(root==null)
            return  0;
        dfs(root,0,result);
        return result[0];

    }

    public void dfs(TreeNode root,int currNum,int[] result){
        int temp = currNum*10+root.val;
        if(root.left==null && root.right== null){
            result[0]+=temp;
            return ;
        }
        if(root.left!=null){
            dfs(root.left,temp,result);
        }
        if(root.right!=null){
            dfs(root.right,temp,result);
        }
    }


}