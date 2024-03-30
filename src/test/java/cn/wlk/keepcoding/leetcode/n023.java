package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2019/4/14-9:47
 * author:WLK
 * <p>
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 解法：循环遍历链表数组，知道全部处理完为止。时间复杂度应该为O(n)，空间复杂度为常数
 */
public class n023 {
    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public ListNode addNode(int n){
            ListNode newnode = new ListNode(n);
            this.next = newnode;
            return newnode;
        }
        public void addAll(String nums){
            List<Integer> num = Arrays.stream(nums.trim().split(" ")).filter(x->x.length()>0).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            ListNode node = this;
            for(int i = 0;i<num.size();i++){
                node = node.addNode(num.get(i));
            }
        }
    }


    @Test
    public void test() {
        n023 t = new n023();
        ListNode node1 = new ListNode(2);
        node1.addAll("1 4 5 6 7  10 23 24 123 234 345 456 ");
        ListNode node2 = new ListNode(2);
        node2.addAll("1 3 4  6 8 14 16 23 26 34 55 67 78 89");
        ListNode node3 = new ListNode(2);
        node3.addAll("34 54 56 67 78 89 ");
        ListNode node4 = new ListNode(2);
        node4.addAll("14 15 27 38 49 59 60 70 82 84 95");
        ListNode node5 = new ListNode(2);
        node5.addAll("1 2 3 4 5 34 364 45646 575788");

//        ListNode[] listNodes = {node1.next,node2.next,node3.next,node4.next,node5.next};
        ListNode[] listNodes = {};
        ListNode resut = t.mergeKLists(listNodes);
        while(resut!=null){
            System.out.println(resut.val);
            resut = resut.next;
        }


    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curr = new ListNode(-1);
        ListNode result = curr;
        int minIndex ;

        while((minIndex = findMin(lists) ) !=-1){
            curr.next =lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            curr = curr.next;
        }

        return result.next;
    }


    public int findMin(ListNode[] listNodes){
        int min = Integer.MAX_VALUE;
        int resultIndex = -1;
        for(int i = 0;i<listNodes.length;i++) {
            if (listNodes[i] !=null && min >= listNodes[i].val) {
                min = listNodes[i].val;
                resultIndex = i;
            }
        }
        return  resultIndex;
    }

}