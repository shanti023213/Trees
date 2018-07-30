package com.trees.ravindra;

import java.util.Stack;

public class SpritalOrder {

	public static void main(String[] args) {
		Node tree = new Node(0);
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
	    spiralOrderTraversal(tree);

	}
	
	public static void spiralOrderTraversal(Node n ){
		
		if(n==null){
			return;
		}
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.push(n);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			
			while(!stack1.isEmpty()){
			Node node = stack1.pop();
			System.out.println("Element: "+node.data);
			if(node!=null && node.left!=null){
				stack2.push(node.left);
			}
			if(node!=null && node.right!=null){
				stack2.push(node.right);
			}
			}
			
			while(!stack2.isEmpty()){
				Node node = stack2.pop();
				System.out.println("Element: "+node.data);
				if(node!=null && node.right!=null){
					stack1.push(node.right);
				}
				if(node!=null && node.left!=null){
					stack1.push(node.left);
				}
			}
		}
	}

}
