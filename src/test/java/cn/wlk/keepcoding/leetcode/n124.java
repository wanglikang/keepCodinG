package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/4/14-10:26
 * author:WLK
 * <p>
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 * 解法：模拟数组的最大连续区间求法，，sub函数返回的是以root结点结尾的之前数组的和最大值
 *      然后sub函数的maxresult参数保存的全局的最大值
 */
public class n124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        /**
         * 0,1,1
         * 2,-1,-2
         * -3,2
         * 2.-1
         * -3
         *
         */
        n124 t = new n124();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(-1);
        root.left = node1;
        TreeNode node2 = new TreeNode(-2);
        root.right = node2;
        System.out.println(t.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        sub(root, result);
        return result[0];

    }

    /**
     * 模拟数组的最大连续区间，，sub函数返回的是以root结点结尾的之前数组的和最大值
     * @param root
     * @param maxresult 全局的最大值
     * @return
     */
    public int sub(TreeNode root, int[] maxresult) {
        if (root == null)
            return 0;
        int leftrightsum , returnmax;
        int left = sub(root.left, maxresult);
        int right = sub(root.right, maxresult);
        returnmax = Math.max(root.val, Math.max(left, right) + root.val);

//        求当连接当前节点的左右子树时候的情况
        leftrightsum = Math.max(left + right + root.val, returnmax);
        if (leftrightsum > maxresult[0]) {
            maxresult[0] = leftrightsum;
        }
        return returnmax;
    }



//
//    /**
//     * 想多了，，，，废弃代码
//     * @param root
//     * @return
//     */
//    public int maxPathSum2(TreeNode root) {
//        Map<TreeNode, int[]> map = new HashMap<>();
//        findMax(root, map);
//        int[] res = map.get(root);
//        return Math.max(Math.max(res[0], res[1]), Math.max(res[2], res[3]));
//
//    }
//
//    public void findMax(TreeNode root, Map<TreeNode, int[]> map) {
//        if (root == null) {
//            return;
//        }
//
////        int leftvalue1 = 0, rightvalue1 = 0, leftvalue0 = 0, rightvalue0 = 0;
//        int leftvalue0 = Integer.MIN_VALUE, leftvalue1 = Integer.MIN_VALUE, leftvalue2 = Integer.MIN_VALUE, leftvalue3 = Integer.MIN_VALUE;
//        int rightvalue0 = Integer.MIN_VALUE, rightvalue1 = Integer.MIN_VALUE, rightvalue2 = Integer.MIN_VALUE, rightvalue3 = Integer.MIN_VALUE;
//        int maxleft = 0, maxright = 0;
//        if (root.left != null) {
//            findMax(root.left, map);
//            leftvalue0 = map.get(root.left)[0];
//            leftvalue1 = map.get(root.left)[1];
//            leftvalue2 = map.get(root.left)[2];
//            leftvalue3 = map.get(root.left)[3];
//            maxleft = Math.max(leftvalue0, Math.max(leftvalue1, leftvalue2));
//        }
//
//        if (root.right != null) {
//            findMax(root.right, map);
//            rightvalue0 = map.get(root.right)[0];
//            rightvalue1 = map.get(root.right)[1];
//            rightvalue2 = map.get(root.right)[2];
//            rightvalue3 = map.get(root.right)[3];
//            maxright = Math.max(rightvalue0, Math.max(rightvalue1, rightvalue2));
//        }
//
//
//        int[] res = new int[]{0, 0, 0, 0};//只选当前节点，选当前节点以及左子树，选当前节点以及右子树，选当前节点左右子树即左右联通
//
//        res[0] = root.val;
//
//        res[1] = root.val + maxleft;
//        res[2] = root.val + maxright;
//        res[3] = root.val + maxleft + maxright;
//
//        map.put(root, res);
//    }
//

}