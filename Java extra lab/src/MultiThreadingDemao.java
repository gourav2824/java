class ChildThread extends Thread{
	ChildThread(){
		super("Child Thread1");
		System.out.println("Child Thread "+ this);
		start();
	}
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("child thread "+i);
				Thread.sleep(380);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}
public class MultiThreadingDemao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildThread t1= new ChildThread();
		try {
			for(int i=0;i<5;i++) {
				System.out.println("Main thread "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Main child over");
		}
		System.out.println("Main child over");
	}
}

//PART B


