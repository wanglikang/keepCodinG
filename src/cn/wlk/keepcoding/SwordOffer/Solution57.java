package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-15:12
 * author:WLK
 * 二叉树的下一个结点
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解法：对节点p,分情况1/有右子树，2/为父节点的坐左节点，3/为父节点的右节点
 */
public class Solution57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Solution57 t = new Solution57();
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode right;
        if (pNode.right != null) {//有右子树
            right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        if (pNode.next != null) {//有父节点
            if (pNode.next.left == pNode) {//是父节点的左子树
                return pNode.next;
            }

            TreeLinkNode parent=pNode;
            while(parent.next!=null && parent.next.right == parent){
                parent = parent.next;
            }
            if(parent.next == null){
                return null;
            }else return parent.next;
        }else return null;

    }


}