package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
//done
public class n155 {

    /**
     * 当前类中的minstack是排好序的最小栈，虽然符合题意，但是太耗费时间
     */
    class MinStack2 {

        Stack<Integer> stack;
        Stack<Integer> minstack;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            int bigcount = 0;
            if (minstack.size() > 0) {
                if (minstack.peek() < x) {
                    while (!minstack.isEmpty()&&minstack.peek() < x) {
                        stack.push(minstack.pop());
                        bigcount++;
                    }
                    minstack.push(x);
                    while (bigcount > 0) {
                        minstack.push(stack.pop());
                        bigcount--;
                    }
                } else minstack.push(x);
            }else minstack.push(x);

        }

        public void pop() {
            int count = 0;
            int stackpop = stack.pop();
            while (!minstack.isEmpty()&&minstack.peek() < stackpop) {
                stack.push(minstack.pop());
                count++;
            }
            minstack.pop();
            while (count > 0) {
                minstack.push(stack.pop());
                count--;
            }

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minstack.peek();
        }
    }


    /**
     * 当前的MinStack类符合题意，，时间复杂度低，
     * minstack栈并没有存放全部元素，而只是存放了某一时刻比stack栈顶小的最小的元素
     */
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minstack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minstack.empty() || minstack.peek() >= x)
                minstack.push(x);

        }

        public void pop() {
            if (stack.peek().equals(minstack.peek()) )
                minstack.pop();
            stack.pop();

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minstack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    @Test
    public void test() {
        n155 t = new n155();
        n155.MinStack stack = new n155.MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println();
    }

}
