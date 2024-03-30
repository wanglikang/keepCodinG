package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/3 16:02
 * author:WLK
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 解法：子函数IsBalanced判断两个子树的高度即可，
 *          若高度小于0，则代表已经不平衡，直接返回负数，否则，判断高度差是否小于等于1。
 */
public class Solution39 {
    @Test
    public void test() {
        Solution39 t = new Solution39();
        TreeNode node1 = new TreeNode(1);

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(IsBalanced(root)>=0){
            return true;
        }else return false;
    }

    /**
     *
     * @param root
     * @return 若平衡，返回当前节点的最大深度，否则返回-2;
     */
    public int IsBalanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftdeep = IsBalanced(root.left);
        int rightddeep = IsBalanced(root.right);
        if(leftdeep>=0&&rightddeep>=0){
            if(Math.abs(leftdeep-rightddeep)<=1)
                return Math.max(leftdeep,rightddeep)+1;
            else return -2;
        }else return -2;
    }

}
