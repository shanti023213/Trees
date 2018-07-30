package com.trees.ravindra;

public class DeleteANodeFromBST {
	static Node tree;

	public static void main(String[] args) {
		
		insert(50);
		insert(30);
		insert(20);
		insert(40);
		insert(70);
		insert(60);
		insert(80);
		insert(35);
		insert(45);
		System.out.println("******");
		
		
		delete(45);
		System.out.println("******");
		insert(45);
		
		delete(30);
		System.out.println("******");
}

	public static void insert(int data){
		if(tree ==null){
			tree = new Node(data);
		}else{
			insert(tree, data);
		}
}
	
	public static Node insert(Node node, int data){
		
		if(node ==null){
			return new Node(data);
		}else{
		if(data<=node.data){
			node.left = insert(node.left, data);
		}else{
			node.right =insert(node.right, data);
		}
		
		}
		
		return node;
	}
	
	public static void delete(int data){
		
		if(tree !=null){
			
			delete(tree ,data);
		}
	}
	
	public static Node delete(Node node, int data){
		
		if(node.data == data){
			if(node.left ==null && node.right==null){
				return null;
			}
			if(node.left==null){
				return node.right;
			}
			if(node.right==null){
				return node.left;
			}
			
		 node.data = searchInorderSuccessor(node.right);
		 
		 node.right = delete(node.right,node.data);
			
			
		}else if(node.data > data){
			node.left = delete(node.left,data);
		}else if(node.data < data){
			node.right = delete(node.right,data);
		}
		
		return node;
	}
	
	public static int searchInorderSuccessor(Node node){
		while(node.left!=null){
			node =node.left;
		}
		return node.data;
	}
}
