package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
//done

/**
 * 解法：
 *      参考：https://blog.csdn.net/u014115273/article/details/51819209
 */
public class n095 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n==0){

            return result;
        }
        return dfs(1,n);
    }


    public TreeNode copyTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode n = new TreeNode(root.val);
        n.left = copyTree(root.left);
        n.right = copyTree(root.right);
        return n;
    }

    public List<TreeNode> dfs(int i,int j){
        if(i>j){
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        for(int mid = i;mid<=j;mid++){
            TreeNode m = new TreeNode(mid);
            List<TreeNode> left =  dfs(i,mid-1);
            List<TreeNode> right =  dfs(mid+1,j);
            if(left==null&&right==null){
                result.add(m);
            }else if(left==null){
                for(TreeNode ri:right){
                    m.right = ri;
                    result.add(copyTree(m));
                }

            }else if(right==null){
                for(TreeNode le:left){
                    m.left = le;
                    result.add(copyTree(m));
                }
            }else {
                for(TreeNode le:left){
                    for(TreeNode ri:right){
                        m.left = le;
                        m.right = ri;
                        result.add(copyTree(m));
                    }
                }
            }
        }
        return result;

    }

    @Test
    public void test() {
        n095 t = new n095();
        t.generateTrees(3);
        System.out.println();
    }

}
