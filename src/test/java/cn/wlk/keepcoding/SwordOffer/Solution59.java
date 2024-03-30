package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2019/4/7-15:49
 * author:WLK
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 解法：想复杂了，，，使用两个双端队列，都往队尾放，都从队尾取；
 *      不过每次的放入次序不一样，先left再right。。。。or  先right再left
 *
 *       其实用两个栈就可以了
 *
 *
 */
public class Solution59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode array2Tree(int[] arr) {
        int len = arr.length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; i < len; i++) {
            if (2 * i+1 < len) {
                nodes[i].left = nodes[2 * i+1];
            }
            if (2 * i+2 < len) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }

    @Test
    public void test() {
        Solution59 t = new Solution59();
        int[] arr = {8, 6, 10, 5, 7, 9, 11,4,3,23,543,442,23432,12,435,999};
        TreeNode root = t.array2Tree(arr);
        t.Print(root).stream().forEach(y -> {
            y.stream().forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> PrintDeque(TreeNode pRoot) {
        Deque<TreeNode> queue1 = new LinkedBlockingDeque<>();
        Deque<TreeNode> queue2 = new LinkedBlockingDeque<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null)
            return result;
        queue1.add(pRoot);
        int flag = 1;
        TreeNode temp;

        while (!queue1.isEmpty()) {
            ArrayList<Integer> subResult = new ArrayList<>();
            if (flag == 1) {
                while (!queue1.isEmpty()) {
                    temp = queue1.pollLast();
                    if(temp.left!=null)
                        queue2.addLast(temp.left);
                    if(temp.right!=null)
                    queue2.addLast(temp.right);
                    subResult.add(temp.val);
                }
            } else {
                while (!queue1.isEmpty()) {
                    temp = queue1.pollLast();
                    if(temp.right!=null)
                        queue2.addLast(temp.right);
                    if(temp.left!=null)
                        queue2.addLast(temp.left);
                    subResult.add(temp.val);
                }
            }
            flag = -1 * flag;
            Deque t = queue1;
            queue1 = queue2;
            queue2 = t;
            result.add(subResult);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> queue1 = new Stack<>();
        Stack<TreeNode> queue2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null)
            return result;
        queue1.add(pRoot);
        int flag = 1;
        TreeNode temp;

        while (!queue1.isEmpty()) {
            ArrayList<Integer> subResult = new ArrayList<>();
            if (flag == 1) {
                while (!queue1.isEmpty()) {
                    temp = queue1.pop();
                    if(temp.left!=null)
                        queue2.add(temp.left);
                    if(temp.right!=null)
                        queue2.add(temp.right);
                    subResult.add(temp.val);
                }
            } else {
                while (!queue1.isEmpty()) {
                    temp = queue1.pop();
                    if(temp.right!=null)
                        queue2.add(temp.right);
                    if(temp.left!=null)
                        queue2.add(temp.left);
                    subResult.add(temp.val);
                }
            }
            flag = -1 * flag;
            Stack<TreeNode> t = queue1;
            queue1 = queue2;
            queue2 = t;
            result.add(subResult);
        }
        return result;
    }

}