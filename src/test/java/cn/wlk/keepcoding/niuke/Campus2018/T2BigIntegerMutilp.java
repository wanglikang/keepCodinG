package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 大整数相乘
 *
 * 题目描述
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 * 输入描述:
 *
 * 空格分隔的两个字符串，代表输入的两个大整数
 *
 * 输出描述:
 *
 * 输入的乘积，用字符串表示
 *
 * 示例1
 * 输入
 *
 * 72106547548473106236 982161082972751393
 *
 * 输出
 *
 * 70820244829634538040848656466105986748
 *
 * 2019/3/17 8:46
 * author:WLK
 */
public class T2BigIntegerMutilp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split(" ");
        char[] arr1 = num[0].toCharArray();
        char[] arr2 = num[1].toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] resultNum = new int[len1+len2+1];
        StringBuilder sb = new StringBuilder();
        int totalIndex = resultNum.length-1;
        for(int i = len1-1;i>=0;i--){
            int addNum = 0;
            int totalAdd = 0;
            int tmp = 0;
            int index = totalIndex;
            for(int j  = len2-1;j>=0;j--){
                tmp = Integer.parseInt(arr1[i]+"")*Integer.parseInt(arr2[j]+"")+addNum;
                addNInStr(resultNum,tmp%10,index);
                addNum = tmp/10;
                index--;
            }
            if(addNum>0){
                addNInStr(resultNum,addNum,index);
            }
            totalIndex --;
        }

        int isZero=0;
        for(int i = 0;i<resultNum.length;i++){
            if(resultNum[i]==0 ){
                if(isZero==0){
                    continue;
                }else {
                    isZero=2;
                    sb.append(resultNum[i]+"");
                }
            }else {
                isZero=2;
                sb.append(resultNum[i]+"");
            }
        }
        System.out.println(sb.toString());
    }
    static void addNInStr(int[] num,int n ,int index){
        int add = n;
        int tmp = 0;
        for(int i = index;i>=0;i--){
            tmp = num[i]+add;
            add = tmp/10;
            num[i] = tmp%10;
            if(add<1){
                break;
            }
        }

    }
}
