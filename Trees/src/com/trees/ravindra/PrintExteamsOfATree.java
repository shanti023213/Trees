package com.trees.ravindra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintExteamsOfATree {

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
        
        printExtreamsInAlternateOrder(tree);
        
	}
	
	public static void printExtreamsInAlternateOrder(Node node){
		
		if(node ==null){
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		boolean flag = true;
		queue.add(node);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			int nodeCount = size;
			
			while(nodeCount-- > 0){
			Node n = queue.poll();
			
			
			if(n.left!=null){
				queue.add(n.left);
			}
			if(n.right!=null){
				queue.add(n.right);
			}
			
			if(flag == true && nodeCount==0){
				System.out.println(n.data);
				
			}
			
			if(flag == false && nodeCount== size-1){
				System.out.println(n.data);
				
			}

		}
			
			flag =!flag;
		}
		
	}

}
