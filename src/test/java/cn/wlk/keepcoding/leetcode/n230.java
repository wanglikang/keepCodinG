package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
//done

/**
 * 解法：也就是中序遍历，求第k个遍历的元素
 */
public class n230 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void lookTree(TreeNode root, int expect, List<Integer> result) {
        if( root.left != null)
            lookTree(root.left, expect, result);

        if (result.size() < expect )
            result.add(root.val);
        if (result.size() < expect && root.right != null)
            lookTree(root.right, expect, result);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        lookTree(root, k,result);
//        for(int i :result){
//            System.out.print(i+" ");
//        }
        return result.get(k-1);
    }

    @Test
    public void test() {
        n230 t = new n230();

//        String rootStr = "[5,3,6,2,4,null,null,1]";
//        TreeNode root = t.array2BinaryTree(rootStr  );
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t1 = new TreeNode(1);
        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;

        System.out.println(t.kthSmallest(t5, 4));
    }

    public void showTree(TreeNode root) {
        System.out.print(root.val);
        if (root.left != null)
            showTree(root.left);
        if (root.right != null)
            showTree(root.right);
    }

    public TreeNode array2BinaryTree(String arr) {
        int len = arr.length();
        System.out.println(arr.substring(1, len - 1));
        String[] ss = arr.substring(1, len - 1).split(",");
        int treeCount = ss.length;
        TreeNode[] trees = new TreeNode[treeCount + 1];
        for (int i = 0; i < treeCount; i++) {
            if (!ss[i].equals("null")) {
                trees[i + 1] = new TreeNode(Integer.parseInt(ss[i]));
            } else {
                trees[i + 1] = null;
            }
        }
        int left, right;
        for (int i = 1; i <= treeCount; i++) {
            left = i * 2;
            right = i * 2 + 1;
            if (left <= treeCount) {
                trees[i].left = trees[left];
            }
            if (right <= treeCount) {
                trees[i].right = trees[right];
            }
        }
        return trees[1];
    }


}
