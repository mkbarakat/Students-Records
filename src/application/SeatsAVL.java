package application;

public class SeatsAVL {
	TNode<Student> root;
	
	public int height() {
		return height(root);
	}

	protected int height(TNode<Student> node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public int getHeightDifference(TNode<Student> node){
		int lh = height(node.left);
		int rh = height(node.right);
		return lh - rh;
	}
	private TNode<Student> rotateRight(TNode<Student> nodeN) {
		TNode<Student> nodeC = nodeN.left;
		nodeN.left = nodeC.right;
		nodeC.right = nodeN;

		return nodeC;
	}

	private TNode<Student> rotateLeft(TNode<Student> nodeN) {
		TNode<Student> nodeC = nodeN.right;
		nodeN.right = nodeC.left;
		nodeC.left = nodeN;

		return nodeC;
	}

	public TNode<Student> rotateRightLeft(TNode<Student> nodeN) {
		TNode<Student> nodeC = nodeN.right;
		nodeN.right = rotateRight(nodeC);

		return rotateLeft(nodeN);
	}

	public TNode<Student> rotateLeftRight(TNode<Student> nodeN) {
		TNode<Student> nodeC = nodeN.left;
		nodeN.left = rotateLeft(nodeC);

		return rotateRight(nodeN);
	}

	public TNode<Student> rebalance(TNode<Student> nodeN) {
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

	public TNode<Student> insertt(Student data) {
		if (root == null) {
			root = new TNode<Student>(data);
			return root;
		}else {
			TNode<Student> rootNode = root;
			TNode<Student> temp=addEntryy(data, rootNode);
			root = rebalance(rootNode);
			return temp;
		}
		
		
	}

	public TNode<Student> addEntryy(Student data, TNode<Student> rootNode) {
		assert rootNode != null;
		if (data.compareTo((Student) rootNode.data) < 0) { // right into left subtree
			if (rootNode.hasLeft()) {
				TNode<Student> leftChild = rootNode.left;
				addEntryy(data, leftChild);
				rootNode.left = rebalance(leftChild);
			} else
				//System.out.println("i am  "+ data +" i am in left");
				return rootNode.left = new TNode<Student>(data);
		} else if (data.compareTo((Student) rootNode.data) > 0){ // right into right subtree
			if (rootNode.hasRight()) {
				TNode<Student> rightChild = rootNode.right;
				addEntryy(data, rightChild);
				rootNode.right = rebalance(rightChild);
			} else {
				System.out.println("i am  "+ data +" i am in right");
				return rootNode.right = new TNode<Student>(data);
				}
		}else {
			System.out.println("i am  "+ data +" i am in equal i shouldnt be here");
			rootNode.SLData.insertAtHead(data);
			return null;
		}
		return null;
	}
	
	
}
