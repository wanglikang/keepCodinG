package cn.wlk.keepcoding.niuke.Y2020.ByteDance;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/4/24 16:14
 * author:WLK
 *
 *
 */

public class B2 {

    @Test
    public void test() {
        B2 t = new B2();
        System.out.println(func("d3[a2[c]]"));
        System.out.println(func("abc3[ef2[df]4[ss]]10[a]"));
        System.out.println(func("abc3[sd]ff"));
    }


    public static String func(String str){
        Stack<String> stackword = new Stack<>();
        Stack<Integer> stacknum = new Stack<>();
        char[] chars = str.toCharArray();
        int n = chars.length;
        int tmpnum = 0;
        String tmpStr = "";
        int state = 0;//-1：初始状态，0：读取字符，1：读入数字
        for(int i = 0;i<n;i++){
            char ch = chars[i];
            if(ch>='0' && ch<='9'){
                if(state==0){
                    stackword.add(tmpStr);
                }else if(state==-1){
                    tmpnum = 0;
                    state= 1;
                }

                tmpnum=tmpnum*10+ch-'0';

            }else{
                if(ch=='['){
                    stacknum.add(tmpnum);
                    tmpnum=0;
                    tmpStr="";
                    stackword.add(tmpStr);

                }else if(ch==']'){
                    stackword.add(tmpStr);
                    tmpStr="";
                    int k = stacknum.pop();

                    String tstr = stackword.pop();
                    String prestr = stackword.pop();

                    StringBuffer sb = new StringBuffer();
                    for(int ii = 0;ii<k;ii++){
                        sb.append(prestr+tstr);
                    }
                    String pre = stackword.pop();
                    pre+=sb.toString();
                    stackword.add(pre);


                    state=-1;
                }else{
                    tmpStr+=ch;
                }
            }
        }
        if(tmpStr.length()>0){
            stackword.add(tmpStr);
        }

        int stackLen = stackword.size();
        String result = "";

        while(stackLen-->0){
            result=stackword.pop()+result;
        }
        return result.toString();
    }
}
