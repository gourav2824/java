
public class Client_Queue {

	public static void main(String[] args) {
		
		Queue qu = new Queue(5);
		
		qu.enqueue(10);
		qu.display();
		
		qu.enqueue(20);
		qu.display();
		
		qu.enqueue(30);
		qu.display();
		
		qu.enqueue(40);
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		qu.enqueue(50);
		qu.display();
		
		qu.enqueue(60);
		qu.display();
		
		qu.enqueue(70);
		qu.display();
		
		qu.enqueue(80);
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
		
		System.out.println(qu.front() + " " + qu.dequeue());
		qu.display();
	}
}