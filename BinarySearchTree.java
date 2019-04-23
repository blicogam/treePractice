public class BinarySearchTree implements Tree {

	Node head;
	int height = 0;

	BinarySearchTree () {
		head = null;
	}

	Node insert(Node current, int value) {
		if(current == null) {
			Node newNode = new Node(value);
			return newNode;
		}
		if(current.value == value) {
			System.out.println("Duplicate Value");
			return current;
		}
		else if(current.value > value) {
			current.left = insert(current.left, value);
			return current;
		}
		else {
			current.right = insert(current.right, value);
			return current;
		}
	}

	public void insert(int val) {
		head = insert(head, val);
	}

	public void delete(int val) {
		if(head == null) {
			return;
		}
		Node temp = head, prev;
		while(temp != null) {
			if(temp.value > value) {
				prev = temp;
				temp = temp.left;
			}
			else if(temp.value < value) {
				prev = templ
				temp = temp.right;
			}
			else {
				break;
			}
		}

		if(temp == null) {
			System.out.println("Couldn't find value");
			return;
		}

		if(!temp.left && !temp.right) {
			if(prev.value > value) {
				prev.left = null;
			}
			else {
				prev.right = null;
			}
		}
		else if(!temp.left) {
			if(prev.value > value) {
				prev.left = temp.right;
			}
			else {
				prev.right = temp.right;
			}
		}
		else if(!temp.right) {
			if(prev.value > value) {
				prev.left = temp.left;
			}
			else {
				prev.right = temp.left;
			}
		}
		// Has two children
		else {
			// Replace with the min element in the right most subtreee of node to be removed
		}
	}

	public boolean contains(int val) {
		return false;
	}

	public int getHeight() {
		return this.height;
	}

	void inorder(Node current) {
		if(current == null) {
			return;
		}
		inorder(current.left);
		System.out.println(current.value);
		inorder(current.right);
	}

}