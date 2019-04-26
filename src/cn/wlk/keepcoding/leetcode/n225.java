package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/26 10:58
 * author:WLK
 * <p>
 * 225. 用队列实现栈
 *
 * 解法：每次将主队列出的只剩一个元素，剩下的就是栈顶元素了
 */
public class n225 {
    @Test
    public void test() {
        n225 t = new n225();
        MyStack obj = new MyStack();

        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }


    class MyStack {
        private Queue<Integer> queue1 ;
        private Queue<Integer> queue2 ;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedBlockingQueue<>();
            queue2 = new LinkedBlockingQueue<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            int result = queue1.poll();
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }

            int result = queue1.poll();
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            queue1.add(result);
            return result;

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {

            return queue1.isEmpty();
        }
    }


}