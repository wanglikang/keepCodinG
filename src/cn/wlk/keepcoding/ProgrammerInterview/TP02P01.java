package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 2020/2/29 15:45
 * author:WLK
 *
 * 面试题 02.01. 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 提示：
 *
 *     链表长度在[0, 20000]范围内。
 *     链表元素在[0, 20000]范围内。
 *
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 解法：set去重
 *
 *
 */

public class TP02P01 {
  public class ListNode {
      int val;
      ListNode next;
     public ListNode(int x) { val = x; }
  }
    @Test
    public void test() {
        TP02P01 t = new TP02P01();
        ListNode head = (ListNode) Utils.createListByArray(TP02P01.class,t,ListNode.class, new int[]{1, 2, 3, 3, 2, 1});
        head = head.next;

        head = null;
        ListNode re = t.removeDuplicateNodes(head);
        while (re!=null){
            System.out.println(re.val);
            re = re.next;
        }

    }

    public ListNode removeDuplicateNodes(ListNode head) {
      Set<Integer> s = new HashSet<>();

      ListNode t = new ListNode(-1);
      t.next = head;
      while(t.next!=null){
          if(s.contains(t.next.val)){
              t.next = t.next.next;
          }else{
              s.add(t.next.val);
              t = t.next;
          }
      }

      return head;

    }

}
