package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

/**
 * 使用两个队列即可
 */

/**
 * 解法1：
 *  使用两个队列
 * 解法2：
 *  使用一个队列 + 长度遍历，来替代两个队列
 */
public class n102 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderV1(TreeNode root) {
        if(root==null)
            return new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();
        queue1.add(root);
        List<Integer> l1   = new ArrayList<>();
        l1.add(root.val);
        TreeNode t;
        while(!queue1.isEmpty()||!queue2.isEmpty()){

            ArrayList<Integer> tlist = new ArrayList<>();
            while(!queue1.isEmpty()){
                t = queue1.poll();
                tlist.add(t.val);
                if(t.left!=null)
                    queue2.add(t.left);
                if(t.right!=null)
                    queue2.add(t.right);

            }
            if(tlist.size()>0) {
                result.add(tlist);
                tlist = new ArrayList<>();
            }
            while(!queue2.isEmpty()){
                t = queue2.poll();
                tlist.add(t.val);
                if(t.left!=null)
                    queue1.add(t.left);
                if(t.right!=null)
                    queue1.add(t.right);

            }
            if(tlist.size()>0)
                result.add(tlist);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> subResult = new ArrayList<>();
            for(int i = 0;i<queueSize;i++){
                TreeNode poll = queue.poll();
                subResult.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            result.add(subResult);
        }
        return result;
    }

    @Test
    public void test() {
        n102 t = new n102();
        System.out.println();
    }

}
