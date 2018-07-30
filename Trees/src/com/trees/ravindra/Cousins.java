package com.trees.ravindra;

public class Cousins {

	public static void main(String[] args) {

			Node tree = new Node(20);

			tree.left = new Node(30);
			tree.right = new Node(40);
			tree.left.left = new Node(45);
			tree.left.right = new Node(45);
			tree.left.left.left = new Node(50);
			tree.left.left.left.left = new Node(67);
			tree.right.right = new Node(45);
			tree.right.right.left = new Node(80);
			tree.right.right.right = new Node(100);
			tree.left.right= new Node(45);
			tree.left.right.left = new Node(50);
			tree.left.right.right = new Node(57);
			tree.left.right.left.left = new Node(67);
			
			boolean cousins = isCousins(tree, tree.left.left.left.left,tree.left.right.left.left );
		
			System.out.println("cousins: "+cousins);

	}
	
	public static boolean isCousins(Node node, Node n1, Node n2){
		if(node==null || n1==null || n2==null){
			return false;
		}
		
		if(levelOfANode(node,n1,0) == levelOfANode(node,n2,0) && !isSibbling(node,n1,n2)){
			return true;
		}
		return false;
	}
	
	public static boolean isSibbling(Node n, Node n1, Node n2){
		
		if(n==null){
			return false;
		}
		 return ((n.left == n1 || n.left ==n2) &&
				(n.right ==n2 || n.right==n2)) || isSibbling(n.left,n1,n2) || isSibbling(n.right,n1,n2);

	}
	public static int levelOfANode(Node n, Node n1,int level){
		if(n==null || n1==null){
			return -1;
		}
		if(n.data==n1.data){
			return level;
		}
		int leftLevel = levelOfANode(n.left,n1,level+1);
		if(leftLevel!=-1){
			return leftLevel;
		}
		int rightLevel = levelOfANode(n.right,n1,level+1);
		return rightLevel;
	}

}
