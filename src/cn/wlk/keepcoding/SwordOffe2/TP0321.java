package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/3/5 17:43
 * author:WLK
 *
 * 面试题32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 *
 * 提示：
 *
 *     节点总数 <= 1000
 *
 * 解法：用队列
 */

public class TP0321 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP0321 t = new TP0321();
    }
    public int[] levelOrder(TreeNode root) {


        if(root==null){
            return new int[]{};
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        List<Integer> resultList = new ArrayList();

        queue.add(root);

        TreeNode node ;
        while(queue.size()>0){
            node = queue.poll();
            resultList.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }

            if(node.right!=null){
                queue.add(node.right);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i =0;i<resultList.size();i++){
            result[i]=resultList.get(i);
        }


        return result;
    }

}
