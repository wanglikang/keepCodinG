import java.util.Scanner;
import java.util.Stack;

/**
 * 2019/3/14 19:34
 * author:WLK
 */
public class PlusMinusBinTree {
    static class Step{
        int x;
        int op;

        public Step(int x, int op) {
            this.x = x;
            this.op = op;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getOp() {
            return op;
        }

        public void setOp(int op) {
            this.op = op;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n ,k;
        n = scanner.nextInt();//预期的数字
        k = scanner.nextInt();//预期的步数
        scanner.close();

        int[] dp=new int[k+1];
        Stack<Step> stepStack = new Stack<>();

        doing(1,n,k,0,stepStack);
    }
    static  void showStack(Stack<Step> stack){
        Stack<Step> temp = new Stack<>();
        while(!stack.empty()){
            temp.add(stack.pop());
        }
        while(!temp.empty()){
            Step s = temp.pop();
            System.out.println(s.x+" "+(s.op==1?"+":"-"));
            stack.add(s);
        }
    }

    /**
     *
     * @param nn 预期的数字n
     * @param kk 步数 k
     * @param stack
     * @return 返回还剩几没有凑够
     */
    static void doing(int num,int nn,int kk,int currN,Stack<Step> stack){
        if(kk<=0 ){
            return ;
        }
        if(nn==currN+num){
            stack.add(new Step(num,1));
            showStack(stack);
            stack.pop();

            return ;
        }else if(nn==currN-num){
            stack.add(new Step(num,-1));
            showStack(stack);
            stack.pop();
            return ;
        }else {
            stack.add(new Step(num,1));
            doing(num*2,nn,kk-1,currN+num,stack);//++
            doing(num*2+1,nn,kk-1,currN+num,stack);//++

            stack.pop();
            stack.add(new Step(num,-1));
            doing(num*2,nn,kk-1,currN-num,stack);//--
            doing(num*2+1,nn,kk-1,currN-num,stack);//--
            stack.pop();
        }
    }

}
