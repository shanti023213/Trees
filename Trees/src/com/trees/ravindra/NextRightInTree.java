package com.trees.ravindra;

import java.util.LinkedList;
import java.util.Queue;

//Next element in the same level

public class NextRightInTree {
	
	public static void main(String[] args){
		Node n = new Node(10);
		n.left = new Node(20);
		n.right = new Node(30);
		n.left.right = new Node(40);
		n.right.right = new Node(35);
		n.left.right.left = new Node(45);
		n.left.right.right = new Node(50);
		
		int result = nextRightInTree(n , 50);
		System.out.println(result);
	}
	
	public static int nextRightInTree(Node n ,int key){
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(n);
		while(!queue.isEmpty()){
			int size = queue.size();
			int currentSize = size;
			
			while(currentSize>0){
				Node node = queue.poll();
				if(node.data == key && currentSize !=1){
					return queue.peek().data;
				}
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
				currentSize--;
			}
		}
		return -1;
	}
}
