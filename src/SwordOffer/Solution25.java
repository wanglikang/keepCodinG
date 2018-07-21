package SwordOffer;

import java.util.*;

/******
 * 复杂链表的复制
 * 
 * 题目描述 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点）， 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author WLK
 *
 */
/****
 * 指向任意节点的random指针，，可以指向自己
 * @author WLK
 *
 */
public class Solution25 {
	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;//应该是可以指向自身

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;

		RandomListNode result = new RandomListNode(pHead.label);//返回的复制后的链表头结点
		HashSet<RandomListNode> lookedset = new HashSet<>();//用于判断是否访问过的，用是否在集合内表示
		HashMap<RandomListNode, RandomListNode> mirrormap = new HashMap<>();//新旧链表的对应关系
		Stack<RandomListNode> stack = new Stack<>();//使用栈进行深度优先访问
		stack.add(pHead);
		mirrormap.put(pHead, result);

		RandomListNode tempold, tempnew;

		while (!stack.isEmpty()) {
			tempold = stack.pop();
			lookedset.add(tempold);
			tempnew = mirrormap.get(tempold);

			if (tempold.next != null) {
				if(!mirrormap.containsKey(tempold.next)) {
					RandomListNode ne = new RandomListNode(tempold.next.label);
					mirrormap.put(tempold.next, ne);
				}
				tempnew.next = mirrormap.get(tempold.next);
				if(!lookedset.contains(tempold.next))
					stack.add(tempold.next);
			}
			if(tempold.random==tempold) {
				tempnew.random = tempnew;
			}else if (tempold.random != null&&tempold.random!=tempold) {
				if(!mirrormap.containsKey(tempold.random)) {
					RandomListNode ne = new RandomListNode(tempold.random.label);
					mirrormap.put(tempold.random, ne);
				}
				tempnew.random = mirrormap.get(tempold.random);
				if(!lookedset.contains(tempold.random))
					stack.add(tempold.random);
			
			}
		}
		return result;
	}
}
