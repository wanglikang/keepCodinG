package test;

/**
 * 2020/4/5 21:34
 * author:WLK
 */

interface Alpha {
    void f();
}
class Beta implements Alpha {
    public void f() {
        System.out.println("Beta.f()");
    }
    public void g() {
        System.out.println("Beta.g()");
    }
}
public class ttt2 {
    public static void main(String[] args) {
            ttt2 nowcoder = new ttt2();
            int i = 0;
            nowcoder.inc(i);
            i = i++;
            System.out.println(i);

    }



    void inc(int i) {
        i++;
    }
}