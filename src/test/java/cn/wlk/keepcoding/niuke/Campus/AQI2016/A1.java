package cn.wlk.keepcoding.niuke.Campus.AQI2016;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * 2020/3/27 11:34
 * author:WLK
 */

public class A1 {

    @Test
    public void test() {
        A1 t = new A1();
        System.out.println(func("abaccdeff"));
        System.out.println(func("testonline"));
    }
    public static void main(String[] argc){
//        Scanner scanner = new Scanner(System.in);
        StreamTokenizer st =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        try {
            st.nextToken();
            int nn = (int)st.nval;
           for (int i = 0; i < nn; i++) {
               st.nextToken();
               String l = st.sval;
                String result = func(l);
                System.out.println(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        int T = 0;
        // InputStreamReader 是字节流通向字符流的桥梁;
        // 为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。例如：
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            T = Integer.parseInt(bufferedReader.readLine());
            for(int i=0; i<T; i++){
                String str = bufferedReader.readLine();
                System.out.println(func(str));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String func(String line){
        int[] hasUsed = new int[256];
        int[] lastIndex = new int[256];
        int n = line.length();
        char c;
        int lastCount = 0;
        for(int i = 0;i<n;i++){
            c = line.charAt(i);
            if(hasUsed[c]==0){
                hasUsed[c]=1;
                lastIndex[c]=lastCount++;
            }else{
                hasUsed[c]++;
                lastIndex[c]=0;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        char resultchar =0;
        for(int i = 0;i<256;i++){
            if(hasUsed[i]==1 && lastIndex[i]!=0 && lastIndex[i]<minIndex){
                minIndex = lastIndex[i];
                resultchar = (char)i;
            }
        }

        return resultchar+"";

    }

}
