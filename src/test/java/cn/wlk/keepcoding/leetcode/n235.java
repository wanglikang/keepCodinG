package cn.wlk.keepcoding.leetcode;

import cn.wlk.keepcoding.SwordOffer.Solution61;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/12-9:25
 * author:WLK
 * <p>
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 见同级目录下的图n235-binarysearchtree_improved
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 解法：分别找出从root节点到p，q的路径，然后从路径头遍历，遇到第一个不相等的节点之前的那个节点就是答案。
 *      若路径有覆盖，则简单判断即可。
 */
public class n235 {
    //      Definition for a binary tree node.
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
        n235 t = new n235();
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        root.left = root2;
        root.right = root8;

        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);

        root2.left = root0;
        root2.right = root4;
        root8.left = root7;
        root8.right = root9;

        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root4.left = root3;
        root4.right = root5;

        TreeNode result = t.lowestCommonAncestor(root, root2, root4);
        System.out.println(result.val);

    }

    /**
     * 分别找出从root节点到p，q的路径，然后从路径头遍历，遇到第一个不相等的节点之前的那个节点就是答案。
     * 若路径有覆盖，则简单判断即可。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> queue1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> queue2 = new ArrayDeque<>();
        findNode(p, root, queue1);
        findNode(q, root, queue2);
        TreeNode last = null;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peekFirst() == queue2.peekFirst()) {
                last = queue1.pollFirst();
                    queue2.pollFirst();

            }else break;
        }

        if(!queue1.isEmpty() && !queue2.isEmpty()){
            return last;
        }else if(queue1.size()>0){
            return q;
        }else if(queue2.size()>0){
            return p;
        }else return root;

    }

    /**
     * 找出从根节点root到当前node节点的路径
     * @param node
     * @param root
     * @param queue
     */
    public void findNode(TreeNode node, TreeNode root, ArrayDeque<TreeNode> queue) {
        if (root == null) {
            return;
        }
        queue.add(root);
        if (node == root) {
            return;
        } else {
            findNode(node, root.left, queue);
            if (queue.peekLast() != node) {
                findNode(node, root.right, queue);
            }
            if(queue.peekLast()!=node){
                queue.pollLast();
            }
        }
    }

}