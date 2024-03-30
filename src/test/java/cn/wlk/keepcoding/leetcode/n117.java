package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 117. 填充同一层的兄弟节点 II
 *
 * 给定一个二叉树
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例:
 *
 * 给定二叉树，
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * 调用你的函数后，该二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
//done 解法同116题
public class n117 {
    // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue1 = new LinkedBlockingQueue<>();
        Queue<TreeLinkNode> queue2 = new LinkedBlockingQueue<>();
        TreeLinkNode tnpre;
        TreeLinkNode tnnext;

        if (root != null) {
            queue1.add(root);
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    tnpre = queue1.poll();
                    if(tnpre.left!=null)
                        queue2.add(tnpre.left);
                    if(tnpre.right!=null)
                        queue2.add(tnpre.right);
                    if(!queue1.isEmpty()){
                        tnnext = queue1.peek();
                    }else{
                        tnnext = null;
                    }
                    tnpre.next = tnnext;

                }
                while (!queue2.isEmpty()) {
                    tnpre = queue2.poll();
                    if(tnpre.left!=null)
                        queue1.add(tnpre.left);
                    if(tnpre.right!=null)
                        queue1.add(tnpre.right);
                    if(!queue2.isEmpty()){
                        tnnext = queue2.peek();
                    }else{
                        tnnext = null;
                    }
                    tnpre.next = tnnext;
                }
            }
        }

    }

    @Test
    public void test() {
        n117 t = new n117();
        System.out.println();
    }

}
