package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/3/1 15:05
 * author:WLK
 *
 * 面试题 02.04. 分割链表
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：一遍遍历找到链表尾，再次遍历，将大于x的插入到链表尾之后即可
 *
 */

public class TP02P04 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    @Test
    public void test() {
        TP02P04 t = new TP02P04();
    }

    public ListNode partition(ListNode head, int x) {
      if(head==null){
          return head;
       }
      ListNode curr = new ListNode(-1);
      curr.next = head;
      ListNode first = curr;

      ListNode tail =null;
      ListNode pre = first;

      //一遍遍历，找到链表尾
        while (curr.next!=null){
            curr = curr.next;
        }
        tail = curr;
        curr = head;

        //再次遍历。将大于x的插入到tail之后
        while(curr!=tail){
            if(curr.val>=x){
                pre.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
                curr = pre.next;
            }else{
                pre = pre.next;
                curr = curr.next;
            }
        }

        return first.next;
    }

}
