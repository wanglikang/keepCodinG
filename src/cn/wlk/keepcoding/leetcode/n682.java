package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2019/4/26-9:42
 * author:WLK
 * <p>
 * 682. 棒球比赛
 * <p>
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * <p>
 * 注意：
 * <p>
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 *
 * 解法：使用栈，栈里是放历史得分，每次遇到数字先累加且入栈，然后遇到操作符的话按照其语义进行操作即可。
 */
public class n682 {
    @Test
    public void test() {
        n682 t = new n682();
//        String[] ops = {"5", "2", "C", "D", "+"};
//        String[] ops = {"5","-2","4","C","D","9","+","+"};
String[] ops = {"57","D","-3","-58","D","77","+","C","+","+","38","78","-6","24","-46","+","31","20","D","-81"};

        System.out.println(t.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<String> stack = new Stack<>();//栈存的是历史得分
        int a, b,score=0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    score = a+b;
                    sum+=score;
                    stack.push(b+"");
                    stack.push(a+"");
                    stack.push(score+"");
                    break;
                case "D":
                    a = Integer.parseInt(stack.pop());
                    score  = 2*a;
                    sum+=score;
                    stack.push(a+"");
                    stack.push(score+"");
                    break;
                case "C":
                    sum-=Integer.parseInt(stack.pop());
                    break;
                default:
                    stack.push(ops[i]);
                    sum+=Integer.parseInt(ops[i]);
                    break;
            }
        }
        return sum;
    }

}