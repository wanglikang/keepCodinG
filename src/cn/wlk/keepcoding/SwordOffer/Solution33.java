package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/3 10:19
 * author:WLK
 * 丑数
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 解法：简单判断是会超时的
 *      需要判断每个*2，*3，*4的大小，
 */
public class Solution33 {
    @Test
    public void test() {
        Solution33 t = new Solution33();
        for(int i = 0;i<30;i++)
        System.out.println(t.GetUglyNumber_Solution(i));



    }
    public int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        int[] result = new int[index];
        result[0]=1;
        int curr = 1;
        int t2=0,t3=0,t5=0;//用于获取当前最小的三个丑数的下标
        while(curr<index){
            int c2 = result[t2]*2;
            int c3 = result[t3]*3;
            int c5 = result[t5]*5;
            int min = Math.min(c2,Math.min(c3,c5));//取最小的加入结果集
            result[curr++]=min;
            if(min==c2)t2++;
            if(min==c3)t3++;
            if(min==c5)t5++;
        }
        return result[index-1];
    }
}
