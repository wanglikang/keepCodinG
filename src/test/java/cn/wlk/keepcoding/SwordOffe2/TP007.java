package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/2 12:45
 * author:WLK
 *
 * 面试题07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：递归
 *
 */

public class TP007 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP007 t = new TP007();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,preorder.length-1);

    }

    public TreeNode build(int[] prenums,int[] innums,int preindex,int start,int end){
        if(end<start) {
            return null;
        }

        if(start==end){
            return new TreeNode(innums[start]);
        }

        int i;
        for(i = start;i<end;i++){
            if(innums[i]==prenums[preindex]){
                break;
            }
        }

        TreeNode result = new TreeNode(prenums[preindex]);


        result.left = build(prenums,innums,preindex+1,start,i-1);
        result.right = build(prenums,innums,preindex+(i-start)+1,i+1,end);

        return result;
    }


}
