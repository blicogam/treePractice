public class BinarySearchTree implements Tree {

	Node head;
	int numNodes = 0;

	BinarySearchTree () {
		head = null;
	}

	Node insert(Node current, int value) {
		if(current == null) {
			Node newNode = new Node(value);
			numNodes++;
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

	public void delete(int value) {
		if(head == null) {
			return;
		}
		Node temp = head, prev = null;
		while(temp != null) {
			if(temp.value > value) {
				prev = temp;
				temp = temp.left;
			}
			else if(temp.value < value) {
				prev = temp;
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

		if(temp.left == null && temp.right == null) {
			if(prev.value > value) {
				prev.left = null;
			}
			else {
				prev.right = null;
			}
			numNodes--;
		}
		else if(temp.left == null) {
			if(prev.value > value) {
				prev.left = temp.right;
			}
			else {
				prev.right = temp.right;
			}
			numNodes--;
		}
		else if(temp.right == null) {
			if(prev.value > value) {
				prev.left = temp.left;
			}
			else {
				prev.right = temp.left;
			}
			numNodes--;
		}
		// Has two children
		else {
			// Replace with the min element in the right most subtreee of node to be removed
			Node minRight = temp.right;
			Node prevMin = temp;
			while(minRight.left != null) {
				prevMin = minRight;
				minRight = minRight.left;
			}
			// Replacing "deleted"
			temp.value = minRight.value;

			// Remove original replaced

			// Not sure if both needed
			if(prevMin.right == minRight) {
				prevMin.right = (minRight.right == null)? null: minRight.right;
			}
			else if(prevMin.left == minRight) {
				prevMin.left = (minRight.right == null)? null: minRight.left;
			}
			numNodes--;
		}
	}

	public boolean contains(int value) {
		Node temp = head;
		while(temp != null) {
			if(temp.value > value) {
				temp = temp.left;
			}
			else if(temp.value < value) {
				temp = temp.right;
			}
			else {
				return true;
			}
		}
		return false;
	}

	int getNumNodes() {
		return this.numNodes;
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