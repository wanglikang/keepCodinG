package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/7-17:02
 * author:WLK
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。
 * 每一层输出一行。
 * 解法：使用队列即可
 */
public class Solution60 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    @Test
    public void test() {
        Solution60 t = new Solution60();
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();
        queue1.add(pRoot);
        TreeNode temp;
        while (!queue1.isEmpty()) {
            ArrayList<Integer> subresult = new ArrayList<>();
            while ((!queue1.isEmpty())) {
                temp = queue1.poll();
                if (temp.left != null)
                    queue2.add(temp.left);
                if (temp.right != null) {
                    queue2.add(temp.right);
                }
                subresult.add(temp.val);
            }
            Queue t = queue2;
            queue2 = queue1;
            queue1 = t;
            result.add(subresult);
        }
        return result;
    }

}