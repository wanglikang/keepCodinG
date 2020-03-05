package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/3/5 17:52
 * author:WLK
 *
 * 面试题32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 *
 * 提示：
 *
 *     节点总数 <= 1000
 *
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 *
 * 解法：用两个队列即可。
 */

public class TP0322 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP0322 t = new TP0322();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }

        List<List<Integer>> result =  new ArrayList<>();
        Queue<TreeNode> nextQueue = new LinkedBlockingQueue();
        Queue<TreeNode> currQueue = new LinkedBlockingQueue();

        currQueue.add(root);
        TreeNode node ;
        while(nextQueue.size()>0 || currQueue.size()>0){
            List<Integer> subResult = new ArrayList();
            while(currQueue.size()>0){
                node = currQueue.poll();
                subResult.add(node.val);
                if(node.left!=null){
                    nextQueue.add(node.left);
                }
                if(node.right!=null){
                    nextQueue.add(node.right);
                }
            }
            result.add(subResult);
            Queue<TreeNode> t = currQueue;
            currQueue = nextQueue;
            nextQueue = t;
        }
        return result;



    }
}
