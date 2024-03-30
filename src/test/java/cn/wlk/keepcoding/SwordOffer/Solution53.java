package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-11:10
 * author:WLK
 * 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 解法：使用有限状态自动机
 *      图示见Solution53.jpg
 */
public class Solution53 {
    @Test
    public void test() {

        Solution53 t = new Solution53();
        char[] chars = "-.123".toCharArray();
        System.out.println(t.isNumeric(chars));
    }

    /**
     * 牛客的测试点：
     * <p>
     * 用例:
     * "-.123"
     * <p>
     * 对应输出应该为:
     * <p>
     * true
     *
     * ？？？？？？？？？？？？
     *
     *
     * 用例:
     * "12e"
     *
     * 对应输出应该为:
     *
     * false
     * ？？？？？？？？/
     *
     * 使用 有限状态自动机算法
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        final int STATE_0 = 0;
        final int STATE_1 = 1;
        final int STATE_2 = 2;
        final int STATE_3 = 3;
        final int STATE_4 = 4;
        final int STATE_5 = 5;
        final int STATE_6 = 6;
        final int STATE_7 = 7;
        final int STATE_8 = 8;

        final int STATE_ERROR = -1;
        int state = STATE_0;
        int index = 0;
        while (index < str.length && state != STATE_ERROR) {
            if (Character.isDigit(str[index])) {
                switch (state) {
                    case STATE_0: state=STATE_2;break;
                    case STATE_1: state=STATE_2; break;
                    case STATE_2: break;//不变
                    case STATE_3: state=STATE_4;break;//不变
                    case STATE_4: break;//不变
                    case STATE_5: state=STATE_7;break;
                    case STATE_6: state=STATE_7;break;//不变
                    case STATE_7: break;//不变
                    default:state=STATE_ERROR;
                }
            } else if (str[index] == '+' || str[index] == '-') {
                switch (state) {
                    case STATE_0: state=STATE_1;break;
                    case STATE_5: state=STATE_6;break;
                    default:state=STATE_ERROR;
                }
            } else if (str[index] == 'e' || str[index] == 'E') {
                switch (state) {
                    case STATE_2: state=STATE_5; break;
                    case STATE_4: state=STATE_5;break;
                    default:state=STATE_ERROR;
                }
            } else if (str[index] == '.') {
                switch (state) {
                    case STATE_1:state=STATE_3; break;
                    case STATE_2:state=STATE_3; break;
                    default:state=STATE_ERROR;
                }
            } else {
                state = STATE_ERROR;
            }
            index++;
        }

        if (state != STATE_ERROR &&
                (state==STATE_2 || state==STATE_4 || state==STATE_7)) {
            return true;
        } else return false;
    }

}