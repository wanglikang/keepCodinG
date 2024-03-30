package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/4/29 9:43
 * author:WLK
 * <p>
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * 解法：方法一：遍历链表，将其放到数组里，在递归建树
 */
public class n109 {

    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        ListNode build(int x){
            this.next = new ListNode(x);
            return this.next;
        }
        ListNode buildAll(int... arg){
            ListNode root = new ListNode(-1);
            ListNode t = root;
            for(int i = 0;i<arg.length;i++){
                t = t.build(arg[i]);
            }
            return root.next;
        }
    }

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
        n109 t = new n109();
        ListNode root = new ListNode(-1);
        ListNode data = root.buildAll(-10, -3, 0, 5, 9);
        TreeNode result = t.sortedListToBST(data);

    }


    /**
     * 方法一：遍历链表，将其放到数组里，在递归建树
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode root = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (root != null) {
            arr.add(root.val);
            root = root.next;
        }
        TreeNode resultRoot =null;
        if(arr.size()>0){
            resultRoot  = buildTree(arr, 0, arr.size()-1);
        }
        return resultRoot;

    }

    public TreeNode buildTree(ArrayList<Integer> arr, int start, int end) {
        TreeNode root =null;

        if (end == start) {//只有一个元素
            root = new TreeNode(arr.get(end));
        } else if (end - start == 1) {//只有两个元素的情况
            root = new TreeNode(arr.get(start));
            root.right = new TreeNode(arr.get(end));
        } else if (end - start == 2) {//只有三个元素的情况
            root = new TreeNode(arr.get(start+1));
            root.left = new TreeNode(arr.get(start));
            root.right = new TreeNode(arr.get(end));
        }else {
            root = new TreeNode(arr.get(start+(end-start)/2));
            root.left = buildTree(arr,start,start+(end-start)/2-1);
            root.right = buildTree(arr,start+(end-start)/2+1,end);

        }
        return root;
    }


}