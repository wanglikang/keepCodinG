package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/3/2 13:24
 * author:WLK
 *
 * 面试题09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *
 *     1 <= values <= 10000
 *     最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 *  解法：优化，针对多次插入，多次删除的情况，不每次插入都倒腾一遍
 */

public class TP008 {

    @Test
    public void test() {
        TP008 t = new TP008();
    }

    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size ;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            size = 0;
        }


        /**
         * 优化，针对多次插入，多次删除的情况
         * @param value
         */
        public void appendTail(int value) {
            stack1.push(value);
            size++;
        }

        public int deleteHead() {
            if(size==0) {
                return -1;
            }
            if(stack2.size()>0){
                size--;
                return stack2.pop();
            }
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            size--;
            return stack2.pop();
        }


        /**
         * 暴力解法：简单粗暴
         * @param value
         */
        public void appendTail2(int value) {
            stack1.push(value);
            size++;
        }
        public int deleteHead2() {
            if(size<1){
                return -1;
            }
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            int reuslt = stack2.pop();

            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }

            size--;
            return reuslt;

        }
    }


}
