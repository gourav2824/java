
public class Client_BST {

	public static void main(String[] args) {
		
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		int[] sa1 = {10, 20, 30, 50, 60, 70, 80};
		
		BST bst = new BST(sa);
		BST bst1 = new BST(sa1);
		
//		System.out.println(bst.max());
//		System.out.println(bst.min());
//		System.out.println(bst.find(62));
		
//		bst.printInRange(26, 80);
		
		bst1.replaceWithSumOfLargerNodes();
		bst1.display();
	}
}