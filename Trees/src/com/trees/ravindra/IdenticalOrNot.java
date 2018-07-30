package com.trees.ravindra;

public class IdenticalOrNot {

	public static void main(String[] args) {
		
			Node root1 = new Node(1);
	        root1.left = new Node(2);
	        root1.right = new Node(3);
	        root1.left.left = new Node(4);
	        root1.left.right = new Node(5);
	  
	        Node root2 = new Node(1);
	        root2.left = new Node(2);
	        root2.right = new Node(3);
	        root2.left.left = new Node(4);
	        //root2.left.right = new Node(5);

	        boolean isIdentical = isIdentical(root1,root2);
	        System.out.println("IsIdentical:"+isIdentical);
	}
	
	public static boolean isIdentical(Node n1, Node n2){
		
		if(n1==null && n2==null){
			return true;
		}
		if(n1==null || n2==null){
			return false;
		}
		if(n1.data==n2.data){
			return isIdentical(n1.left,n2.left)&&isIdentical(n1.right,n2.right);
		}
		return false;
	}

}
