
public class Client_BST {

	public static void main(String[] args) {
		
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		
		BST bst = new BST(sa);
		
		System.out.println(bst.max());
		System.out.println(bst.min());
		System.out.println(bst.find(62));
		
	}

}
