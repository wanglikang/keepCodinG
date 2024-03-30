
public class testThreadLocal {
	public static void main(String[] args) {
		Thread t = new Thread(new myThread());
		t.start();
	}
	

}
class myThread implements Runnable{

	ThreadLocal<Integer> localVarble = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return 23243;
		}
		
	};
	public void run() {
		System.out.println(localVarble.get());
		
	}
}

