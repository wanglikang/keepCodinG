package cn.wlk.keepcoding.SwordOffer;

/*******用两个栈实现队列 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 *  队列中的元素为int类型。
 * 
 * @author WLK
 *
 */
import java.util.Stack;
public class Solution5 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.add(node);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
    
        return result;
    }

    /**
     * 之前的pop函数会有不必要的操作
     */
    public int pop2(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
