package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/4/21 15:40
 * author:WLK
 *
 * 面试题 04.06. 后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 *
 * 解法:用栈，非递归
 */

public class TP04P06 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    @Test
    public void test() {
        TP04P06 t = new TP04P06();
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(stack.peek().val != p.val){
            TreeNode top = stack.peek();
            if(top.left!=null && top.val>p.val){
                stack.add(top.left);
            }else if(top.right!=null && top.val < p.val){
                stack.add(top.right);
            }
        }
        TreeNode top  = stack.peek();
        if(top.right!=null){
            TreeNode result = top.right;
            while(result.left!=null){
                result = result.left;
            }
            return result;
        }

        TreeNode curr = stack.pop();
        while(!stack.isEmpty()){
            TreeNode pre = stack.pop();
            if(pre.left == curr){
                return pre;
            }
            curr = pre;
        }
        return null;
    }


}
