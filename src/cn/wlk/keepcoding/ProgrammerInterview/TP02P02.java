package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 2020/2/29 16:57
 * author:WLK
 *
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：简单题；不使用额外空间的->使用双指针
 *
 *
 */

public class TP02P02 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    @Test
    public void test() {
        TP02P02 t = new TP02P02();
    }

    /**
     * 使用了额外空间
     * @param head
     * @param k
     * @return
     */
    public int kthToLast2(ListNode head, int k) {
        ArrayList<Integer> arrs = new ArrayList<>();
        while(head!=null){
            arrs.add(head.val);
            head = head.next;
        }

        return arrs.get(arrs.size()-k);

    }

    /**
     * 不适用额外空间,使用双指针
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode p1 = head;
        int c = 0;
        while (c<k){
            p1 = p1.next;
            c++;
        }
        ListNode p2 = head;
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.val;
    }
}
