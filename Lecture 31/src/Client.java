
public class Client {

	public static void main(String[] args) {
		
		Linked_List list = new Linked_List();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
//		list.display();
		list.addFirst(5);
//		list.display();
		list.addLast(40);
		list.display();
		
//		System.out.println(list.getAt(2));
		
		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
	}
}