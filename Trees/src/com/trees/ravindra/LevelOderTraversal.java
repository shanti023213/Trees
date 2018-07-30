package com.trees.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOderTraversal {

	public static void main(String[] args) {
		
		Node tree = new Node(50);
        tree.left = new Node(30);
        tree.right = new Node(70);
        
        tree.left.left = new Node(20);
        tree.left.right = new Node(40);
  
        tree.left.right.left = new Node(35);
        tree.left.right.right = new Node(45);
        
        tree.right.left = new Node(60);
        tree.right.right = new Node(80);
      
        levelOderTraversal(tree);
   
	
	}
	
	public static void levelOderTraversal(Node node){
		if(node == null){
			System.out.println("Tree is empty");
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()){
			
			Node n = queue.poll();
			System.out.println("****"+ n.data);
			if(n.right!=null){
				queue.add(n.right);
			}
			if(n.left!=null){
				queue.add(n.left);
			}
		}
	}

}
