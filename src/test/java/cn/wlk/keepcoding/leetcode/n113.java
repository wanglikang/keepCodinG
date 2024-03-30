package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2019/4/29 10:05
 * author:WLK
 *
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
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
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 解法：dfs即可
 */
public class n113 {

//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    @Test
    public void test() {
        n113 t = new n113();
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        root5.left = root4;
        root5.right = root8;
        TreeNode root11 = new TreeNode(11);
        root4.left =root11;
        TreeNode root13 = new TreeNode(13);
        TreeNode root44 = new TreeNode(4);
        root8.left = root13;
        root8.right = root44;
        TreeNode root7 = new TreeNode(7);
        TreeNode root2 = new TreeNode(2);
        root11.left= root7;
        root11.right = root2;
        TreeNode root55 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        root44.left= root55;
        root44.right = root11;
        List<List<Integer>> result = t.pathSum(root5, 22);
        result.stream().forEach(x->{
            x.stream().forEach(y->{
                System.out.print(y+" ");
            });
            System.out.println();

        });



    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> stack = new ArrayList<>();
        List<List<Integer>> result  = new ArrayList<>();
        if(root==null){
            return result;
        }

        dfs(root,result,sum,stack);
        return result;
    }

    public void dfs(TreeNode root,List<List<Integer>> result,int target,ArrayList<Integer> stack){
          if(root.left==null && root.right == null && root.val == target){//root是叶子节点，且刚好满足条件，则入结果集

              List<Integer> subresult = new ArrayList<>();
              for(int i =0;i<stack.size();i++){
                  subresult.add(stack.get(i));
              }
              subresult.add(root.val);
              result.add(subresult);
              return ;
          }
          stack.add(root.val);
          if(root.left!=null) {
              dfs(root.left, result, target - root.val, stack);
          }
          if(root.right!=null){
              dfs(root.right,result,target-root.val,stack);
          }
          stack.remove(stack.size()-1);
    }


}