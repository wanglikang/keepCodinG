package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.Stack;

/**
 * 2019/4/7-19:02
 * author:WLK
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 解法：中序遍历，递归调用，设置计数器，减到0则代表已经遍历到了，，后续直接返回
 */
public class Solution62 {
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
        Solution62 t = new Solution62();
        int[] nodes = {8,6,10,5,7,9,11};
        TreeNode root = t.array2Tree(nodes);
        TreeNode result = t.KthNode(root, 5);
        System.out.println(result.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        int[] count = {k};
        return mid(pRoot,count);
    }
    public TreeNode mid(TreeNode root ,int[] counter){
        if(root==null)
            return null;


        TreeNode subresult;
        if(root.left!=null)
            subresult = mid(root.left, counter);
        else subresult = null;
        if(subresult ==null) {
            counter[0]--;
            if(counter[0]==0){
                return root;
            }
            if(root.right!=null)
                subresult = mid(root.right, counter);
            else subresult = null;
            return subresult;
        }else return subresult;
    }

    public TreeNode array2Tree(int[] arr) {
        int len = arr.length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; i < len; i++) {
            if (2 * i + 1 < len) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if (2 * i + 2 < len) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }

}