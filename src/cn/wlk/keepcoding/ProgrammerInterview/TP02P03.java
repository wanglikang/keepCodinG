package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/2/29 17:11
 * author:WLK
 *
 * 面试题 02.03. 删除中间节点
 *
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 *
 *
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法:由于只能访问被删节点，无法得知pre，所以只能改变节点内的内容了
 */

public class TP02P03 {
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    @Test
    public void test() {
        TP02P03 t = new TP02P03();
    }

    public void deleteNode(ListNode node) {
         node.val =node.next.val;;
         node.next = node.next.next;
    }


}
