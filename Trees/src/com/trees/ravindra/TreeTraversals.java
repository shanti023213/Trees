package com.trees.ravindra;


public class TreeTraversals {
	
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
        
        preOrder(tree);
        System.out.println("********************************");
        inOrder(tree);
        System.out.println("********************************");
        postOrder(tree);

	}
	
	public static void preOrder(Node node){
		
		if(node!=null){
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
		}
	}
	
	public static void inOrder(Node node){
		
		if(node!=null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	public static void postOrder(Node node){
		
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}
	
	public static void doubleOrderTraversal(Node node){
		
		if(node!=null){
			System.out.println(node.data);
			doubleOrderTraversal(node.left);
			System.out.println(node.data);
			doubleOrderTraversal(node.right);
			}
		
	}
	
	public static void tripleOrderTraversal(Node node){
		
		if(node!=null){
			System.out.println(node.data);
			tripleOrderTraversal(node.left);
			System.out.println(node.data);
			tripleOrderTraversal(node.right);
			System.out.println(node.data);
			}
		
	}

}
