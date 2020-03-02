package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 2020/3/2 12:20
 * author:WLK
 *
 * 面试题06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：遍历反转、反转原链表等
 */

public class TP006 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    @Test
    public void test() {
        TP006 t = new TP006();
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> num = new LinkedList<>();
        while (head!=null){
            num.add(head.val);
            head = head.next;
        }
        int n = num.size();
        int[] result =new int[num.size()];
        for(int i = 0;i<n;i++){
            result[i]=num.get(n-1-i);
        }

        return result;

    }



}
