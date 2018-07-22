package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 530. 二叉搜索树的最小绝对差
 */

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出:
 * 1
 * <p>
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 */

//done
public class n530 {

    // * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //中序遍历一下，在求最小值
    public int midgo(TreeNode root, int[] arr, int index) {
        if (root == null)
            return index;
        index = midgo(root.left, arr, index);
        arr[index++] = root.val;
        index = midgo(root.right,arr,index);
        return index;
    }

    public int getMinimumDifference(TreeNode root) {
        int[] arr = new int[100000];
        int count = midgo(root,arr,0);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<count-1;i++){
            int dif =Math.abs(arr[i]-arr[i+1]);
            if(dif>min){
                min =dif;
            }
        }
        return min;
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);

    }

}
