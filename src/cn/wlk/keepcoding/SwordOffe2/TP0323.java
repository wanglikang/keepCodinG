package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2020/3/5 17:59
 * author:WLK
 *
 * 面试题32 - III. 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 *
 * 提示：
 *
 *     节点总数 <= 1000
 *
 * 解法：得使用两个双端队列了
 *
 */

public class TP0323 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP0323 t = new TP0323();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }

        List<List<Integer>> result =  new ArrayList<>();
        LinkedBlockingDeque<TreeNode> nextQueue = new LinkedBlockingDeque();
        LinkedBlockingDeque<TreeNode> currQueue = new LinkedBlockingDeque();

        currQueue.add(root);
        TreeNode node ;
        boolean order =true;
        while(nextQueue.size()>0 || currQueue.size()>0){
            List<Integer> subResult = new ArrayList();
            while(currQueue.size()>0){
                // if(order) {
                node = currQueue.pollFirst();
                // }else{
                // node = currQueue.pollLast();
                // }
                subResult.add(node.val);
                if(order){
                    if(node.left!=null){
                        nextQueue.addFirst(node.left);
                    }
                    if(node.right!=null){
                        nextQueue.addFirst(node.right);
                    }
                }else{
                    if(node.right!=null){
                        nextQueue.addFirst(node.right);
                    }
                    if(node.left!=null){
                        nextQueue.addFirst(node.left);
                    }
                }
            }
            order = !order;
            result.add(subResult);
            LinkedBlockingDeque<TreeNode> t = currQueue;
            currQueue = nextQueue;
            nextQueue = t;
        }
        return result;

    }


}
