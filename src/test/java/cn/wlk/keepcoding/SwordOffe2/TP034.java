package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2020/2/27 17:44
 * author:WLK
 *
 * 面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 *
 * 提示：
 *
 *     节点总数 <= 10000
 *
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 解法：递归
 *
 */

public class TP034 {

  public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }


    @Test
    public void test() {
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        root5.left = root4;
        root5.right = root8;
        TreeNode root11 = new TreeNode(11);
        root4.left =root11;
        TreeNode root13 = new TreeNode(13);
        TreeNode root44 = new TreeNode(4);
        root8.left = root13;
        root8.right = root44;
        TreeNode root7 = new TreeNode(7);
        TreeNode root2 = new TreeNode(2);
        root11.left= root7;
        root11.right = root2;
        TreeNode root55 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        root44.left= root55;
        root44.right = root11;
        TP034 t = new TP034();
        t.pathSum(root5,22).stream().forEach(v->{
            v.forEach(vv->{
                System.out.print(vv+ " ");
            });
            System.out.println();
        });
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(-2);
        TreeNode root2 = new TreeNode(-3);
        root.right = root2;

        TP034 t = new TP034();
        t.pathSum(root,-5).stream().forEach(v->{
            System.out.print("[");
            v.forEach(vv->{
                System.out.print(vv+ " ");
            });
            System.out.println("]");
        });
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> result = new ArrayList<>();
      if(root==null){
          return result;
      }
      Stack<Integer> path = new Stack<>();
      dfs(root,sum,result,path);
      return result;
    }


    public void dfs(TreeNode root, int target, List<List<Integer>> result, Stack<Integer> path) {
        path.push(root.val);

        if (target == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            path.pop();
            return;
        }
        if (root.left != null) {
            dfs(root.left, target - root.val, result, path);

        }
        if (root.right != null) {
            dfs(root.right, target - root.val, result, path);
        }

        path.pop();
    }

}
