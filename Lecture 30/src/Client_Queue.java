
public class Client_Queue {

	public static void main(String[] args) {
		
		Queue qu = new Dynamic_Queue(5);
		
		qu.enqueue(10);
		qu.enqueue(20);
		qu.enqueue(30);
		qu.enqueue(40);
		
		qu.dequeue();
		qu.dequeue();
		
		qu.enqueue(50);
		qu.enqueue(60);
		qu.enqueue(70);
		qu.enqueue(80);
		
		qu.display();
	}
}