package cn.wlk.keepcoding.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */

/**
 * 通过：
 * 解法：
 *  用两个队列，一个存在当前正在遍历的，另一个存放下一层需要遍历的。
 *  当前遍历的队列，只把最后一个元素加入到结果中
 */
public class n199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> needPrintQueue= new LinkedBlockingQueue<>() ;
        Queue<TreeNode> nextLevelQueue = new LinkedBlockingQueue<>();
        needPrintQueue.add(root);
        TreeNode lastNode = null;
        while (needPrintQueue.size() > 0) {
            while (needPrintQueue.size() > 0) {
                lastNode = needPrintQueue.poll();
                if (lastNode.left != null) {
                    nextLevelQueue.add(lastNode.left);
                }
                if (lastNode.right != null) {
                    nextLevelQueue.add(lastNode.right);
                }


            }
            result.add(lastNode.val);
            Queue<TreeNode> tmp = needPrintQueue;
            needPrintQueue = nextLevelQueue;
            nextLevelQueue = tmp;
        }
        return result;
    }
}
