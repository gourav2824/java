
public class Client {

	public static void main(String[] args) {
		
		Linked_List list = new Linked_List();
		
//		list.addLast(10);
//		list.addLast(20);
//		list.addLast(30);
//		list.display();
//		list.addFirst(5);
//		list.display();
//		list.addLast(40);
//		list.display();
//		
//		System.out.println(list.getAt(2));
//		
//		System.out.println(list.removeFirst());
//		list.display();
//		System.out.println(list.removeLast());
//		list.display();
//		
//		list.addAt(25, 2);
//		list.display();
//		list.removeAt(1);
//		list.display();
		
		list.addFirst(10);
		list.display();
		list.addLast(20);
		list.display();
		list.addLast(30);
		list.display();
		list.addFirst(40);
		list.display();
		
		list.addAt(2, 100);
		list.display();
		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		while(!list.isEmpty()) {
//			System.out.println(list.removeLast());
//			list.display();
//		}
		
		list.reverseDI();
		list.display();
		
		list.reversePI();
		list.display();
		
		list.addFirst(20);
		list.addFirst(30);
		list.removeAt(2);
		list.removeAt(2);
		list.display();
		
		System.out.println(list.IsPalindrome());
	}
}