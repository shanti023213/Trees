package com.trees.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromLinkedList {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.right = new Node(2);
		n.right.right = new Node(3);
		n.right.right.right = new Node(4);
		n.right.right.right.right = new Node(5);
		n.right.right.right.right.right = new Node(6);
		//n.right.right.right.right.right.right = new Node(7);
		
		if(n!=null){
		Node root =constructTree(n);
		System.out.println("********");
		}
	}
	
	public static Node constructTree(Node n){
		
		Queue<Node> queue = new LinkedList<Node>();
		Node root = new Node(n.data);
		queue.add(root);
		Node current = n.right;
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			if(current!=null){
				node.left = new Node(current.data);
				queue.add(node.left);
				current = current.right;
			}
			if(current!=null){
				node.right = new Node(current.data);
				queue.add(node.right);
				current = current.right;
			}
		}
	
		return root;
	}

}
