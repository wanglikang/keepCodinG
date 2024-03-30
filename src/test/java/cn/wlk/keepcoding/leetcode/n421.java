package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/23-9:39
 * author:WLK
 *
 * 421. 数组中两个数的最大异或值
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 * 解法：前缀树+贪心，建立一个数字二进位的前缀树即可，然后从高位到低位，对每一位尽量取反，每次求异或，求异或的全局最大即可
 *      参考：https://blog.csdn.net/qq_41855420/article/details/88756998
 */
public class n421 {
    class Tree{
        int value;
        Tree left;
        Tree right;
        Tree(int x){
            this.value = x;
            left = null;
            right =  null;
        }
        public void buildTree(int[] nums,Tree root){
            Tree currNode =null;
            for(int i = 0;i<nums.length;i++){
                currNode = root;
                int n = nums[i];
                for(int j = 31;j>=0;j--){
                    if((n&(1<<j))==0){//最高为是0
                        if(currNode.left==null){
                            currNode.left = new Tree(0);
                        }
                        currNode = currNode.left;
                    }else {
                        if(currNode.right==null){
                            currNode.right = new Tree(1);
                        }
                        currNode = currNode.right;
                    }
                }
                currNode.left = new Tree(n);
            }

        }
    }
    @Test
    public void test() {
        n421 t = new n421();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(t.findMaximumXOR(nums));
    }
    public int findMaximumXOR(int[] nums) {
        Tree root = new Tree(-1);
        root.buildTree(nums, root);
//        System.out.println("build done .");
        int max = 0;
        Tree currNode =null;
        int tempX ;
        int tempY ;
        for(int i = 0;i<nums.length;i++){
            currNode = root;
            tempX = nums[i];
            for(int j = 31;j>=0;j--){
                if((tempX&(1<<j))==0){
                    if(currNode.right!=null){
                        currNode = currNode.right;
                    }else currNode = currNode.left;
                }else {
                    if(currNode.left!=null){
                        currNode = currNode.left;
                    }else currNode = currNode.right;
                }
            }
            tempY = currNode.left.value;
            max = Math.max(max, tempX^tempY);
        }
        return max;

    }

}