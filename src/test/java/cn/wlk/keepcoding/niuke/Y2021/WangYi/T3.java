package cn.wlk.keepcoding.niuke.Y2021.WangYi;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/8/8 15:55
 * author:WLK
 */

public class T3 {
    public static void main(String[] args) {

        String a = "1234";

        final char[] chars = a.toCharArray();
        chars[1]='a';
        final String s = new String(chars);
        System.out.println(s);

    }
    public static void main2(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0;i<T;i++){
            int n = scanner.nextInt();
            List<Integer> oddArr = new ArrayList<>();
            long sum = 0;
            int tt;
            for(int j = 0;j<n;j++){
                tt =scanner.nextInt();
                if(tt%2!=0){
                    oddArr.add(tt);
                }
                sum+=tt;

            }

            oddArr.sort(Integer::compare);
            int tmpSum = 0;
            boolean hasFound = false;
            for(int j = 0;j<oddArr.size();j++){
                tmpSum=0;
                for(int k = 0;k<=j;k++){
                    tmpSum+=oddArr.get(k);
                }
                if((sum+tmpSum)%2==0){
                    System.out.println(tmpSum);
                    hasFound = true;
                    break;
                }
            }
            if(!hasFound){
                System.out.println(sum);
            }

        }
    }
}
