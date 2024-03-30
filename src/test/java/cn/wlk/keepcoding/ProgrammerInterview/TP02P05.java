package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/3/1 15:29
 * author:WLK
 *
 * 面试题 02.05. 链表求和
 *
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解法：简单题，直接用链表依次相加即可
 */

public class TP02P05 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    @Test
    public void test() {
        TP02P05 t = new TP02P05();
    }


    /**
     * 逆序的链表的情况，以此相加即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        int add = 0;
        int t ;
        while(l1!=null && l2!=null){
            t = l1.val+l2.val+add;
            add =t/10;
            ListNode newn = new ListNode(t%10);
            curr.next = newn;
            curr = newn;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            t = l1.val+add;
            add = t/10;
            ListNode newn = new ListNode(t%10);
            curr.next = newn;
            curr = newn;
            l1 = l1.next;
        }
        while(l2!=null){
            t = l2.val+add;
            add = t/10;
            ListNode newn = new ListNode(t%10);
            curr.next = newn;
            curr = newn;
            l2 = l2.next;
        }
        if(add>0){
            t = add;
            ListNode newn = new ListNode(t);
            curr.next = newn;
            curr = newn;
        }

        return result.next;
    }
}
