package com.trees.ravindra;

public class HeightOfTree {

	static Node tree;

	public static void main(String[] args) {
		
		tree = new Node(0);
        tree.left = new Node(1);
        tree.right = new Node(2);
        
        tree.left.left = new Node(3);
        tree.left.right = new Node(4);
        
        tree.left.left.left = new Node(7);
        tree.left.left.right = new Node(8);
        
     
        tree.left.right.left = new Node(9);
        tree.left.right.right = new Node(10);
        
        tree.right.left = new Node(5);
        tree.right.right = new Node(6);
        
        tree.right.left.left =new Node(11);
        tree.right.left.right =new Node(12);
        
        tree.right.right.right = new Node(13);
        
        System.out.println(heightOfTree(tree));
	}
	
	public static int heightOfTree(Node node){
		
		if(node== null){
			return 0;
		}
		
		if(node.left== null && node.right==null){
			return 0;
		}
		
		int left = heightOfTree(node.left);
		int right = heightOfTree(node.right);
			
		return 1+Math.max(left, right);
		
		//return 1+Math.max(heightOfTree(node.left),heightOfTree(node.right));
	}




}
