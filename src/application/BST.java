package application;

public class BST<T extends Comparable<T>> {
	TNode<T> root;

	public void traverseInOrder() {
		traverseInOrder(root);
		System.out.println();
	}

	private void traverseInOrder(TNode<T> node) {
		if (node != null) {
			if (node.left != null)
				traverseInOrder(node.left);
			System.out.print(node + " ");
			if (node.right != null)
				traverseInOrder(node.right);
		}
	}

	public TNode<T> find(T data) {
		return find(data, root);
	}

	public TNode<T> find(T data, TNode<T> myNode) {// need revision
		if (myNode != null) {
			if (myNode.data.compareTo(data) == 0) {
				System.out.println("im find " + myNode.data);
				return myNode;
			} else if (myNode.data.compareTo(data) > 0 && myNode.hasLeft()) {
				System.out.print("im in " + myNode.data + " i go left -->");
				return find(data, myNode.left);
			} else if (myNode.data.compareTo(data) < 0 && myNode.hasRight()) {
				System.out.print("im in " + myNode.data + " i go right -->");
				return find(data, myNode.right);
			}
		}
		System.out.print("im in " + myNode.data+" --> null");
		return null;

	}

	public void insert(T data) {
		if (root == null) {
			root = new TNode<T>(data);
		} else {
			insert(data, root);
		}
	}

	public void insert(T data, TNode<T> node) {
		if (node != null) {
			if (node.data.compareTo(data) > 0) {// if new data is smaller than node insert at left
				if (node.hasLeft()) {
					insert(data, node.left);
				} else {
					node.left = new TNode<T>(data);
				}
			} else { // if new data > or = insert at right
				if (node.hasRight()) {
					insert(data, node.right);
				} else {
					node.right = new TNode<T>(data);
				}
			}
		}
	}

	public TNode<T> delete(T data) {
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
		// if the data found we have many cases
		// case 1 node is leaf
		if (current.right == null && current.left == null) {// if current don't have left and right
			if (current == root) {
				root = null;
			} else {
				if (isLeftChilde) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
		// case 2 when the current has one child
		// case2.1 when current has just left child
		else if (current.hasLeft() && !current.hasRight()) {
			if (current == root) {
				root = current.left;
			} else {
				if (isLeftChilde) {
					parent.left = current.left;
				} else {
					parent.right = current.left;
				}
			}
		}
		// case 2.2 when current has only right child
		else if (current.hasRight() && !current.hasLeft()) {
			if (current == root) {
				root = current.right;
			} else {
				if (isLeftChilde) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		}
		// case 3 when current has left and right
		else {
			TNode<T> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChilde) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return null;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	public T deletePucket(T data) {
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
		}/////////////////////////////////
		if(current.SLData!=null) {
			System.out.println("in delete pucket SLData != null");
			
			SLLNode<T> temp=current.SLData.delete(data);
			if (temp == null)
				return null;
			if(current.SLData.head!=null) {
			if (temp!=null)
				return temp.data;
			}
		}
		///////////////////////////////
		// if the data found we have many cases
		// case 1 node is leaf
		if (current.right == null && current.left == null) {// if current don't have left and right
			if (current == root) {
				root = null;
			} else {
				if (isLeftChilde) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
		// case 2 when the current has one child
		// case2.1 when current has just left child
		else if (current.hasLeft() && !current.hasRight()) {
			if (current == root) {
				root = current.left;
			} else {
				if (isLeftChilde) {
					parent.left = current.left;
				} else {
					parent.right = current.left;
				}
			}
		}
		// case 2.2 when current has only right child
		else if (current.hasRight() && !current.hasLeft()) {
			if (current == root) {
				root = current.right;
			} else {
				if (isLeftChilde) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		}
		// case 3 when current has left and right
		else {
			TNode<T> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChilde) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return null;

	}
///////////////////////////////////////////////////////////////////////////////////////
	private TNode<T> getSuccessor(TNode<T> node) {
		TNode<T> parentOfSuccessor = node;
		TNode<T> successor = node;
		TNode<T> current = node.right;
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.left;
		}
		if (successor != node.right) { // fix successor connections
			parentOfSuccessor.left = successor.right;
			successor.right = node.right;
		}
		return successor;
	}
	
	public int height() {
		return height(root);
	}

	protected int height(TNode<T> node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public int getHeightDifference(TNode<T> node){
		int lh = height(node.left);
		int rh = height(node.right);
		return lh - rh;
	}
	////////////////////
	public String traverseLevel() {
		String s="";
		int h = height(root);
		int i;
		for (i = 0; i < h; i++) {
			s+=printLevel(root, i, 0);
			s+="\n";
			System.out.println(printLevel(root, i, 0));
			System.out.println();
		}
		return s;
	}
	private String printLevel(TNode<T> root, int i, int j) {

		if (root != null) {
			if (i == j)
				return " ("+root.getData() + ") ";
			if (j > i)
				return "( N )";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "( N )";

	}
	
	
	
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(10);
		tree.insert(15);
		tree.insert(18);
		tree.insert(16);
		tree.insert(100);
		tree.insert(90);
		tree.insert(14);
		tree.traverseInOrder();
		System.out.println("######################################"+tree.find(10).data);
		System.out.println(tree.find(18));
		//tree.delete(15);
		System.out.println(tree.find(14));
		System.out.println(tree.find(18));
		System.out.println(tree.height());
		System.out.println("the hight difference is  : "+tree.getHeightDifference(tree.root));
		tree.traverseLevel();
	}

}
