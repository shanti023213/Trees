package com.trees.ravindra;

public class MinAndMaxInBST {

	static Node tree;

	public static void main(String[] args) {
		
		tree = new Node(50);
        tree.left = new Node(30);
        tree.right = new Node(70);
        
        tree.left.left = new Node(20);
        tree.left.right = new Node(40);
  
        tree.left.right.left = new Node(35);
        tree.left.right.right = new Node(45);
        
        tree.right.left = new Node(60);
        tree.right.right = new Node(80);
      
        System.out.println("MinNumber: "+ minValue(tree));
        System.out.println("MaxNumber: "+ maxValue(tree));
   
	}
	
	public static int minValue(Node node){
		
		if(node== null){
			return 0;
		}

		while(node.left!=null){
			node = node.left;
		}
		return node.data;
	}
	
public static int maxValue(Node node){
		
		if(node== null){
			return 0;
		}

		while(node.right!=null){
			node = node.right;
		}
		return node.data;
	}
	
}
