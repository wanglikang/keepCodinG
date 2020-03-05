package cn.wlk.keepcoding.SwordOffe2;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/3/5 15:11
 * author:WLK
 *
 * 面试题26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 解法：递归判断是不是子树
 *
 */

public class TP026 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP026 t = new TP026();
//        TreeNode root = (TreeNode) Utils.createListByArray(TP026.class, t, TreeNode.class, new int[]{1, 0, 1, -4, -3});
//
//        TreeNode target = (TreeNode)Utils.createListByArray(TP026.class,t,TP026.TreeNode.class,new int[]{1,-4});
//        boolean re = t.isSubStructure(root, target);
//        System.out.println(re);

        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        TreeNode t44 = new TreeNode(1);
        boolean re = t.isSubStructure(t1, t44);
        System.out.println(re);
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        return isSub(A,B);
    }

    public boolean isSub(TreeNode root,TreeNode target){
        if(root==null){
            return false;
        }
        if(isInSub(root,target)){
            return true;
        }else{
            return isSub(root.left,target) || isSub(root.right,target);
        }
    }

    public boolean isInSub(TreeNode root,TreeNode target){
        if(target!=null && root==null){
            return false;
        }

        if(target==null || root==null){
            return true;
        }

        if(root.val==target.val){
            return isInSub(root.left,target.left) && isInSub(root.right,target.right);
        }else{
            return false;
        }
    }


}
