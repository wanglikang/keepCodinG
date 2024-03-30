package cn.wlk.keepcoding.leetcode.tencent;

import org.junit.Test;

import java.util.*;

/**
 * 2020/3/8 16:00
 * author:WLK
 */

public class T1 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            val = v;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    @Test
    public void test() {
        T1 t = new T1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right=t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t.func(t1);
    }


    public void func(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,Integer> status = new HashMap<>();

        stack.add(root);
        status.put(root,0);
        while(!stack.empty()){
            TreeNode t = stack.peek();

            if(status.get(t)==0){
                if(t.left!=null) {
                    stack.add(t.left);
                    status.put(t.left,0);
                }
                status.put(t,1);//访问过了左子树
            }else if(status.get(t)==1){
                if(t.right!=null){
                    stack.add(t.right);
                    status.put(t.right,0);
                }
                status.put(t,2);//访问了右子树

            }else {
                System.out.println(t.val);
                stack.pop();//当前节点后序遍历完毕，，弹出栈
            }

        }


    }


}
