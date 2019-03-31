package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/31 18:29
 * author:WLK
 */

/**题目描述 数字字符
 * 在十进制表示中，任意一个正整数都可以用字符’0’-‘9’表示出来。但是当’0’-‘9’这些字符每种字符的数量有限时，可能有些正整数就无法表示出来了。比如你有两个‘1’，一个‘2’，那么你能表示出11，12，121等等，但是无法表示出10，122，200等数。
 * 现在你手上拥有一些字符，它们都是’0’-‘9’的字符。你可以选出其中一些字符然后将它们组合成一个数字，那么你所无法组成的最小的正整数是多少？
 * 输入描述:
 *
 * 第一行包含一个由字符’0’-‘9’组成的字符串，表示你可以使用的字符。
 * 1 ≤字符串长度≤ 1000
 *
 * 输出描述:
 *
 * 输出你所无法组成的最小正整数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 55
 *
 * 输出
 * 复制
 *
 * 1
 *
 * 说明
 *
 * 示例2
 * 输入
 * 复制
 *
 * 123456789
 *
 * 输出
 * 复制
 *
 * 10
 *
 * 解法: 统计各个字符出现的频率，并判断是不是0出现的次数最少
 *          若0出现的次数最少，则还需要判断和第二少的次数之间的关系
 *                          若和第二少的次数相等，则为第二少的数字重复次数加1个的“iiiiiiiii”的形式
 *                          否则为i00000000的形式
 *          若其他字符出现的次数最少，则若出现了0次，则答案为这字符
 *                                  否则答案为这个字符重复出现次数加1次。
 *
 */
public class numberCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars= str.toCharArray();
        int[] nums = new int[10];
//        nums[0]=1;
        for(int i = 0;i<str.length();i++){
            nums[chars[i]-'0']++;
        }
        int min = Integer.MAX_VALUE;
        int index =10;
        int lastIndex=9;
        for(int i = 9;i>=0;i--){
            if(nums[i]<=min){
                min = nums[i];
                lastIndex = index;
                index = i;
            }
        }
        //出现次数最少的是0 ,k次                          :第二小的i0000（k+1)次
        //出现次数最少的不是0
            //有多个相同的出现次数最少数字，都出现了k次     :最小的那个iiii（k+1)次
            //只有一个数字i是k最少的，出现了k次。          :iiiiiii(k+1)个
        //
        StringBuilder sb = new StringBuilder();
        if(index==0){//0出现的次数最少
            if(nums[index]==nums[lastIndex]){//输出的形式为："iiiiiiiii"
                for(int i = 0;i<=nums[lastIndex];i++){
                    sb.append(lastIndex+"");
                }
            }else {//出现了大于1次，，输出的形式为"k00000"
                sb.append(lastIndex);
                for(int i = 0;i<=nums[0];i++) {
                    sb.append("0");
                }
            }
        }else {//1-9中某个出现的次数最少
            if(nums[index]==0){//最少的出现了0次//输出的形式为："i"
                sb.append(index+"");
            }else{//最少的出现了大于0次//输出的形式为："iiiiiii"
                for(int i = 0;i<=nums[index];i++) {
                    sb.append(index+"");
                }
            }
        }
        System.out.println(sb.toString());
    }


}
