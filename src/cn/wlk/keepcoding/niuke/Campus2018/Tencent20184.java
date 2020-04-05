package cn.wlk.keepcoding.niuke.Campus2018;

import org.junit.Test;

/**
 * 2020/3/8 10:49
 * author:WLK
 */

public class Tencent20184 {

    @Test
    public void test() {
        Tencent20184 t = new Tencent20184();
    }

    public static void main(String[] a){
//        int K = 5;
//        int A = 2;
//        int X = 3;
//        int B = 3;
//        int Y = 3;

//        int K = 989;
//        int A = 3;
//        int X = 17;
//        int B = 7;
//        int Y = 39;


//        int K = 17;
//        int A = 5;
//        int X = 79;
//        int B = 4;
//        int Y = 66;

        int K = 205;
        int A = 1;
        int X = 92;
        int B = 4;
        int Y = 92;

        long re = func(A, X, B, Y, K);
        System.out.println(re);

    }
    public static long func(int A,int X,int B,int Y,int K){

        long totalresult = 0;
        for(int i = 0;i<X;i++){
            for(int j = 0;j<Y;j++){
                if((i*A+j*B)==K){
                    System.out.println(i+"\t"+j);
                    if(i==69){
                        System.out.println("69");
                    }
                    long t1 = C(X,i);
                    long t2 = C(Y,j);
//                    System.out.println(t1+"\t"+t2);
                    totalresult+=t1*t2%1000000007;
                }
            }
        }
        return totalresult%1000000007;
   }

    /**
     * 求组合数，从n个元素中取m个组组合
     * @param n
     * @param m
     * @return
     */
    public static long C(int n,int m){
        if(m==1){
            return n;
        }
        long upSum  = n;
        for(int i = n-1;i>=n-m+1;i--){
            upSum=upSum*i;
        }
        return upSum/getMI(m);
    }

    static  long[] resultMI = new long[101];
    static {
        resultMI[0]=1;
        resultMI[1]=1;
        resultMI[2]=2;
    }


    public static long getMI(int n){
        if(resultMI[n]==0){
            resultMI[n]=getMI(n-1)*n;
        }
        return resultMI[n];
    }

}
