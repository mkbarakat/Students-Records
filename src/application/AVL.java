package application;

public class AVL<T extends Comparable<T>> extends BST<T> {
	TNode<T> lastAdded;

	private TNode<T> rotateRight(TNode<T> nodeN) {
		TNode<T> nodeC = nodeN.left;
		nodeN.left = nodeC.right;
		nodeC.right = nodeN;

		return nodeC;
	}

	private TNode<T> rotateLeft(TNode<T> nodeN) {
		TNode<T> nodeC = nodeN.right;
		nodeN.right = nodeC.left;
		nodeC.left = nodeN;

		return nodeC;
	}

	public TNode<T> rotateRightLeft(TNode<T> nodeN) {
		TNode<T> nodeC = nodeN.right;
		nodeN.right = rotateRight(nodeC);

		return rotateLeft(nodeN);
	}

	public TNode<T> rotateLeftRight(TNode<T> nodeN) {
		TNode<T> nodeC = nodeN.left;
		nodeN.left = rotateLeft(nodeC);

		return rotateRight(nodeN);
	}

	public TNode<T> rebalance(TNode<T> nodeN) {
		int diff = getHeightDifference(nodeN);
		if (diff > 1) { // addition was in node's left subtree
			if (getHeightDifference(nodeN.left) > 0)
				nodeN = rotateRight(nodeN);
			else
				nodeN = rotateLeftRight(nodeN);
		} else if (diff < -1) { // addition was in node's right subtree
			if (getHeightDifference(nodeN.right) < 0)
				nodeN = rotateLeft(nodeN);
			else
				nodeN = rotateRightLeft(nodeN);
		}
		return nodeN;
	}

	public void insertt(T data) {
		if (root == null) {
			root = new TNode<T>(data);
			lastAdded = root;

		} else {
			TNode<T> rootNode = root;
			addEntryy(data, rootNode);
			root = rebalance(rootNode);
		}

	}

	public void addEntryy(T data, TNode<T> rootNode) {
		assert rootNode != null;
		if (data.compareTo((T) rootNode.data) < 0) { // right into left subtree
			if (rootNode.hasLeft()) {
				TNode<T> leftChild = rootNode.left;
				addEntryy(data, leftChild);
				rootNode.left = rebalance(leftChild);
			} else {
				// System.out.println("i am "+ data +" i am in left");
				rootNode.left = new TNode<T>(data);
				lastAdded = rootNode.left;
			}
		} else if (data.compareTo((T) rootNode.data) > 0) { // right into right subtree
			if (rootNode.hasRight()) {
				TNode<T> rightChild = rootNode.right;
				addEntryy(data, rightChild);
				rootNode.right = rebalance(rightChild);
			} else {
				// System.out.println("i am "+ data +" i am in right");
				rootNode.right = new TNode<T>(data);
				lastAdded = rootNode.right;
			}
		} else {
			// System.out.println("i am "+ data +" i am in equal i shouldnt be here");
			//rootNode.SLData.insertAtHead(data);
		}
	}

	public void insert(T data) {
		if (root == null) {
			root = new TNode<T>(data);

		} else {
			TNode<T> rootNode = root;
			addEntry(data, rootNode);
			root = rebalance(rootNode);

		}

	}

	public void addEntry(T data, TNode<T> rootNode) {
		assert rootNode != null;
		if (data.compareTo((T) rootNode.data) < 0) { // right into left subtree
			if (rootNode.hasLeft()) {
				TNode<T> leftChild = rootNode.left;
				addEntry(data, leftChild);
				rootNode.left = rebalance(leftChild);
			} else
				rootNode.left = new TNode<T>(data);
		} else if (data.compareTo((T) rootNode.data) > 0) { // right into right subtree
			if (rootNode.hasRight()) {
				TNode<T> rightChild = rootNode.right;
				addEntry(data, rightChild);
				rootNode.right = rebalance(rightChild);
			} else
				rootNode.right = new TNode<T>(data);
		} else {
			rootNode.SLData.insertAtHead(data);

		}
	}

	public TNode<T> delete(T data) {
		TNode<T> temp = super.delete(data);
		if (temp != null) {
			TNode<T> rootNode = root;
			root = rebalance(rootNode);
		}
		return temp;
	}



	

	public void traverseInOrder() {
		traverseInOrderWithList(root);
		System.out.println();
	}

	private void traverseInOrderWithList(TNode<T> node) {
		if (node != null) {
			if (node.left != null)
				traverseInOrderWithList(node.left);
			System.out.print("[ " + node.SLData.toString() + " ]");
			if (node.right != null)
				traverseInOrderWithList(node.right);
		}
	}

	public void traverseInOrderWithPointer() {
		traverseInOrderWithPointer(root);
		System.out.println();
	}

	private void traverseInOrderWithPointer(TNode<T> node) {
		if (node != null) {
			if (node.left.data != null)
				traverseInOrderWithPointer(node.left);
			System.out.print("[ " + node.getPointer().toString() + " ]");
			if (node.right != null)
				traverseInOrderWithPointer(node.right);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	public TNode<T> largest() {
		return largest(root);
	}

	public TNode<T> largest(TNode<T> node) {
		if (node != null) {
			if (!node.hasRight())
				return (node);
			return largest(node.right);
		}
		return null;
	}

	public TNode<T> smallest() {
		return smallest(root);
	}

	public TNode<T> smallest(TNode<T> node) {
		if (node != null) {
			if (!node.hasLeft())
				return (node);
			return smallest(node.left);
		}
		return null;
	}
	
	public TNode<T> search(T data){
		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isLeftChilde = false;
		if (root == null) { // if the tree is empty then not found
			return null;
		}
		// search method with parent and flag
		while (current != null && current.data.compareTo(data) != 0) {
			parent = current;
			if (current.data.compareTo(data) > 0) { // if data we search < data on node, go left.
				current = current.left;
				isLeftChilde = true;
			} else { // if data is more go right
				current = current.right;
				isLeftChilde = false;
			}
		}
		if (current == null) { // if not found
			return null;
		}
		return current;
		
	}
	public static void main(String[] args) {
		AVL<Integer> a = new AVL<Integer>();
		//BST<Integer> b = new BST<>();
		for (int i = 10; i <= 170; i += 10)
			a.insert(i);

		System.out.println("height = " + a.height());
		System.out.println(a.getHeightDifference(a.root));
		a.find(130);
		a.delete(130);
		// a.rebalanceALL(a.root);
		a.find(150);
		System.out.println(a.getHeightDifference(a.root.right.right));
		System.out.println(a.search(10));

	}

}
