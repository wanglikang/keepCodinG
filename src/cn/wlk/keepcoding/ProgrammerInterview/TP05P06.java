package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/4/21 22:12
 * author:WLK
 */

public class TP05P06 {

    @Test
    public void test() {
        TP05P06 t = new TP05P06();
        System.out.println(t.convertInteger(29,15));
    }
    public int convertInteger(int A, int B) {
        int t  = A^B;
        int n =0;
        for(int i = 0;i<32;i++){
            if((t&1<<i)!=0){
                n++;
            }
        }

        return n;
    }

}
