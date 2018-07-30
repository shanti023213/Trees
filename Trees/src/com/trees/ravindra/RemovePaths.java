package com.trees.ravindra;

public class RemovePaths {

	public static void main(String[] args) {
		

		Node tree = new Node(0);

		tree.left = new Node(1);
		tree.right = new Node(2);

		tree.left.left = new Node(3);
		tree.left.right = new Node(4);

		tree.left.left.left = new Node(7);
		tree.left.left.left.right = new Node(8);

		tree.left.right.left = new Node(14);
		tree.left.right.right = new Node(24);

		tree.left.right.left.left = new Node(34);
		Node n = removePathsInTree(tree,4);
		System.out.println("Here i am ");
	}
	
	public static Node removePathsInTree(Node n, int distance){
		
		if(n==null){
			return null;
		}
		if(distance==0){
			return n;
		}
		 n.left = removePathsInTree(n.left,distance-1);
		 n.right = removePathsInTree(n.right,distance-1);
		
		if(n.left!=null || n.right!=null){
			return n;
		}
		return null;
	
	}

}
