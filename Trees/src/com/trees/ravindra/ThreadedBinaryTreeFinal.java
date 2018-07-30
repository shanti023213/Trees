package com.trees.ravindra;

class Node4{
	
	Node4 left,right;
	int data;
	
	boolean isThreaded;
	
	public Node4(int data){
		this.data = data;
	}
}

public class ThreadedBinaryTreeFinal {

	public static void main(String[] args) {
		
		Node4 root = new Node4(1);
	    root.left = new Node4(2);
	    root.right = new Node4(3);
	    root.left.left = new Node4(4);
	    root.left.right = new Node4(5);
	    root.right.left = new Node4(6);
	    root.right.right = new Node4(7);
	    
	    root.left.left.right = new Node4(8);
	    root.left.left.right.left = new Node4(9);
	    root.left.left.right.right = new Node4(10);
	    root.left.left.right.right.left = new Node4(11);
	    
		    buildThreadedTree(root);
		    
		    printInOrder(root);
	}
	
	public static Node4 buildThreadedTree(Node4 node){
		
		if(node == null){
			return null;
		}
		 
		if(node.left ==null && node.right ==null){
			return node;
		}
		
		Node4 left = buildThreadedTree(node.left);
		if(left!=null){
			left.right=node;
			left.isThreaded =true;
		}
		
		
		if(node.right==null){
			return node;
		}
		
		
		Node4 right = buildThreadedTree(node.right);
		
		
		return right;
		
	}
	
	public static void printInOrder(Node4 node){
		
		if(node==null){
			return ;
		}
		
		Node4 cur = findLeftMost(node);
		
		while(cur!=null){
			
			System.out.println(cur.data);
			if(cur.isThreaded){
				
				cur = cur.right;
			}else {
				cur = findLeftMost(cur.right);
			}
		}
	}
	
	public static Node4 findLeftMost(Node4 node){
		
			if(node== null){
				return null;
			}
			while(node.left!=null){
				node =node.left;
			}
			return node;
	}
}
