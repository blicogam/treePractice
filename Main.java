public class Main {
	public static void main(String[]args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(38);
		bst.insert(12);
		bst.insert(90);
		bst.insert(42);
		bst.inorder(bst.head);
	}
}