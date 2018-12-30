
public class Client_AVL {

	public static void main(String[] args) {
		
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		int[] sa1 = {10, 20, 30, 50, 60, 70, 80};
		
		AVL avl = new AVL(sa);
		AVL avl1 = new AVL(sa1);
		
		avl.display();
		
		avl.add(10);
		avl.add(5);
		System.out.println("---------------");
		avl.display();
		
		avl.add(11);
		System.out.println("---------------");
		avl.display();
	}
}