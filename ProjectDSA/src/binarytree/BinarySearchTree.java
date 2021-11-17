package binarytree;

public class BinarySearchTree {
	
	public static class Node {
		
		int value;
		Node left, right;
		
		Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	public Node addNode(Node node, int value) {
		//check if the value is less than 
		if(node == null) return new Node(value);
		if(value<node.value) node.left = addNode(node.left, value);
		else if(value>node.value) node.right = addNode(node.right, value);
		else System.out.println("ignored as it is a duplicate");
		return node;
	}
	
	public void preOrder(Node node) {
		if(node!= null) {
			System.out.println(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if(node!= null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	public void inOrder(Node node) {
		if(node!= null) {
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}
	
	
	public void find(int searchVal, Node node) {
		//to find the node that matches with searchval
		//check if the given search is equal to node value
		if(node!=null) {
		if(node.value == searchVal) System.out.println(node.value+" ");
		else if(node.value>searchVal) find(searchVal, node.left);
		else find(searchVal, node.right);	
		} else System.out.println("not found in the tree");
	}
	
	public void remove(int removeVal, Node node) {
		//find the 
		//if the removeVal is at leaf node then just remove that node by making it as null
		//if the removeVal node has either left or right node then attach the parent of removeVal node to available child of removeVal
		Node prevNode = node;
		if(removeVal == node.value) {
			if(node.left == null && node.right == null) node = null;
			else if(node.right == null) {
				
			}
		}
	}
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Node node = new Node(14);
		tree.addNode(node, 17);
		tree.addNode(node, 8);
		tree.addNode(node, 11);
		tree.addNode(node, 2);
		tree.addNode(node, 31);
		tree.addNode(node, 22);
		tree.addNode(node, 15);
		tree.addNode(node, 6);
		tree.inOrder(node);
		//tree.postOrder(node);
		//tree.find(15, node);
		
	}

}
