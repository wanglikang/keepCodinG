package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2020/4/21 16:55
 * author:WLK
 *
 * 面试题 04.12. 求和路径
 *
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 *
 * 提示：
 *
 *     节点总数 <= 10000
 *
 *
 * 解法：设当前的路径，每次计算和的时候，，自底向上计算，和等于sum即计数一次，
 *          这样可以避免自上而下的时候重复计数
 *
 */

public class TP04P12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test() {
        TP04P12 t = new TP04P12();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;
        System.out.println(t.pathSum(n1,3));
    }
    public int pathSum(TreeNode root, int sum) {

        if(root==null){
            return 0;
        }else{
            int[] result = new int[]{0};
            int[] path = new int[10000];
            find(root,sum,0,path,result);
            return result[0];
        }

    }

    public int find(TreeNode root,int sum,int depth,int[] path,int[] result){
        if(root==null){
            return  0;
        }
        path[depth]=root.val;
        int s = 0;
        for(int i = depth;i>=0;i--){
            s+=path[i];
            if(s==sum){
                result[0]++;
            }
        }
        find(root.left,sum,depth+1,path,result);
        find(root.right,sum,depth+1,path,result);


        return 0;

    }

}
