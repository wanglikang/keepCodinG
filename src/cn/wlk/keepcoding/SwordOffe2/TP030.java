package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/3/5 16:37
 * author:WLK
 *
 * 面试题30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 *
 * 提示：
 *
 *     各函数的调用总次数不超过 20000 次
 *
 *
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 *
 * 解法:用两个stack即可
 */

public class TP030 {

    @Test
    public void test() {
        TP030 t = new TP030();
    }

    class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack();
            stack2 = new Stack();

        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.size()==0){
                stack2.push(x);
            }else{
                if(stack2.peek()>=x){
                    stack2.push(x);
                }
            }

        }

        public void pop() {
            int ele = stack1.pop();
            if(stack2.peek()==ele){
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();

        }

        public int min() {
            return stack2.peek();
        }
    }
}
