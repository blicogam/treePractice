public class Main {
	public static void main(String[]args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(45);
		bst.insert(56);
		bst.insert(23);
		bst.insert(47);
		bst.insert(72);
		//bst.insert(78);
		bst.insert(48);
		bst.inorder(bst.head);
		System.out.println(bst.getNumNodes());
		bst.delete(56);
		bst.delete(23);
		System.out.println("new"); 
		bst.inorder(bst.head);
		System.out.println(bst.contains(45));
		System.out.println(bst.contains(19));
		System.out.println(bst.contains(72)); 
		System.out.println(bst.getNumNodes());
	}
}