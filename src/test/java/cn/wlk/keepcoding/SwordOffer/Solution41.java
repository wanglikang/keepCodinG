package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 2019/4/4 9:16
 * author:WLK
 * 和为S的连续正数序列
 * <p>
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 解法：假设结果的长度为len，则若len为偶数且sum%len==len/2，则能构成结果数组
 *                  若len为奇数且sum % len == 0，则也能构成结果数组
 *      len从大到小递减，结果集就符合排序的要求，
 *
 */
public class Solution41 {
    @Test
    public void test() {
        Solution41 t = new Solution41();
        ArrayList<ArrayList<Integer>> result = t.FindContinuousSequence(15);
        result.stream().forEach(x->{
            x.forEach(y->{
                System.out.print(y+" ");
            });
            System.out.println();
        });

    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //9,10,11,12,13,14,15,16
        //25,25,25,25
        //18,19,20,21,22
        int len = sum/2+1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        while(len>=2) {
            if (sum % len == 0&& len%2==1) {//18,19,20,21,22
                int i = sum/len-len/2;
                if(i>0) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    for (; i <= sum / len + len / 2; i++)
                        arr.add(i);
                    result.add(arr);
                }
            }else if(len%2==0 && sum%len==len/2){//能凑成9,10,11,12,13,14,15,16的形势

                int i = sum/len-len/2+1;
                if(i>0) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    for(;i<sum/len+len/2+1;i++) {
                        arr.add(i);
                    }
                    result.add(arr);
                }
            }
            len--;
        }
        return result;
    }

}
