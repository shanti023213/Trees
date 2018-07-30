package com.trees.ravindra;

public class MaxDiffBetweenANodeAndAncestor {
	
	public static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		
		 	Node root = new Node(8);
	         root.left = new Node(3);
	         root.left.left = new Node(1);
	         root.left.right = new Node(6);
	         root.left.right.left = new Node(4);
	         root.left.right.right = new Node(7);
	  
	         root.right = new Node(10);
	         root.right.right = new Node(14);
	         root.right.right.left = new Node(13);
	         int value = maxDiff(root);
	         
	         System.out.println("Value: "+result);

	}
	
	public static int maxDiff(Node node){
		
		if(node==null){
			return Integer.MAX_VALUE;
		}
		if(node.left==null && node.right==null){
			return node.data;
		}
		
		int leftMin = maxDiff(node.left);
		int rightMin = maxDiff(node.right);
		
		int value = node.data -Math.min(leftMin, rightMin);
		result = Math.max(value, result);
		
		return Math.min(node.data,Math.min(leftMin, rightMin));
	}

}
