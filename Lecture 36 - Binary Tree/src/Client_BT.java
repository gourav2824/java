
public class Client_BT {

	public static void main(String[] args) {
		
		int[] arr = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};
		int[] arr1 = {50, 25, 12, 10, -1, 20, -1, -1, -1, 75, 62, 60, -1, -1, 87, -1, -1, -1};
		
		Binary_Tree bt = new Binary_Tree(arr);
		Binary_Tree bt1 = new Binary_Tree(arr1);
		
//		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.min());
//		System.out.println(bt.height());
//		System.out.println(bt.find(62));
		
//		bt1.printSingleChild();
		bt.display();
		System.out.println("------------------");
		bt.removeLeaf();
		bt.display();
	}
}