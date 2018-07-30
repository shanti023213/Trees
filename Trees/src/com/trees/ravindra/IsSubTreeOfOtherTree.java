package com.trees.ravindra;

public class IsSubTreeOfOtherTree {

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
			
			Node tree1 = new Node(45);
			tree1.left = new Node(50);
			tree1.right = new Node(57);
			tree1.left.left = new Node(67);
		
			
			boolean identical = isIdenticalTrees(tree,tree1);
			System.out.println("Is identical: "+identical);
		
	}
	
	public static boolean isIdenticalTrees(Node n1, Node n2){
		
		if(n1 ==null && n2==null){
			return true;
		}
		if(n1==null || n2==null){
			return false;
		}
		
		if(n1.data==n2.data && isIdentical(n1,n2)){
			return true;
		}
		return isIdenticalTrees(n1.left,n2) || isIdenticalTrees(n1.right,n2);
		
	}
	
	public static boolean isIdentical(Node n1, Node n2){
		
		if(n1 ==null && n2==null){
			return true;
		}
		if(n1==null || n2==null){
			return false;
		}
		
		if(n1.data ==n2.data){
			return isIdentical(n1.left,n2.left)&&isIdentical(n1.right,n2.right);
		}
		
		return false;
	}

}
