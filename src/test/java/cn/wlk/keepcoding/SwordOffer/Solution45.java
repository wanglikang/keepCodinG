package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/4 11:04
 * author:WLK
 * 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * 解法：先排序，然后求0的个数，在然后遍历非0的数，若不是递增1的关系，则用0补，最后判断是否符合条件
 */
public class Solution45 {
    @Test
    public void test() {
        Solution45 t = new Solution45();
        System.out.println(t.isContinuous(new int[]{1, 2, 4, 0, 0}));
        System.out.println(t.isContinuous(new int[]{1, 2, 6, 0, 0}));
        System.out.println(t.isContinuous(new int[]{1, 4, 5, 0, 0}));
        System.out.println(t.isContinuous(new int[]{1, 3, 5, 6, 0}));
        System.out.println(t.isContinuous(new int[]{1, 3, 4, 5, 0}));
        System.out.println(t.isContinuous(new int[]{1, 0, 0, 0, 0}));
        System.out.println(t.isContinuous(new int[]{1, 4, 0, 0, 0}));
        System.out.println(t.isContinuous(new int[]{2, 3, 4, 1, 5}));


    }

    public boolean isContinuous(int[] numbers) {


        int len = numbers.length;
        if (len == 0)
            return false;
        Arrays.sort(numbers);
        int zeroCount = 0;
        int i;
        for (i = 0; i < len; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else break;
        }
        for (int t = i + 1; t < len; t++) {//如果有重复的非0数字，，则一定false
            if (numbers[t] == numbers[t - 1])
                return false;
        }
        int currnumber = numbers[i];
        for (int j = i + 1; j < len; ) {
            if (currnumber + 1 != numbers[j]) {
                if (zeroCount <= 0) {
                    return false;
                } else {
                    currnumber++;
                    zeroCount--;
                }
            } else {
                currnumber++;
                j++;
            }
        }
        if (currnumber >= numbers[len - 1])
            return true;
        else return false;
    }


}

