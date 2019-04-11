package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/11-9:43
 * author:WLK
 * 292. Nim游戏
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 *
 *
 *  解法：判断n是不是4的倍数，是则一定输掉，否则一定可以是当前的n变成4的倍数，使后手输掉从而赢得
 *
 *  引申：bash博弈问题
 */
public class n292 {
    @Test
    public void test() {
        n292 t = new n292();
        System.out.println(t.canWinNim(5));
    }
    public boolean canWinNim(int n) {
        if(n%4==0)
            return false;
        else return true;

    }
    public boolean canWinNim2(int n) {

        return first(n);
    }
    public boolean first(int n){
        if(n<=3){
            return true;
        }
        return last(n-1)&&last(n-2)&&last(n-3);

    }
    public boolean last(int n ){
        if(n<=3){
            return false;
        }
        return first(n-1)||first(n-2)|first(n-3);
    }
}