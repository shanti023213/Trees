package com.trees.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class MultipliationOfSumOfEachLevel {

	public static void main(String[] args) {
		
		Node tree = new Node(1);
        tree.left = new Node(1);
        tree.right = new Node(2);
        
        tree.left.left = new Node(3);
        tree.left.right = new Node(4);
        
        tree.left.left.left = new Node(1);
        tree.left.left.right = new Node(1);
        
     
        tree.left.right.left = new Node(2);
        tree.left.right.right = new Node(2);
        
        tree.right.left = new Node(2);
        tree.right.right = new Node(2);
        
        tree.right.left.left =new Node(1);
        tree.right.left.right =new Node(2);
        
        tree.right.right.right = new Node(3);
        
        int result = multiplicationOfSums(tree);
        
        System.out.println(result);

	}
	
	public static int multiplicationOfSums(Node n){
		
		Queue<Node> queue = new LinkedList<Node>();
		if(n==null){
			return 0;
		}
		int product = n.data;
		queue.add(n);
		while(!queue.isEmpty()){
			int size = queue.size();
			int count = size;
			int sum =0;
			while(count>0){
				Node node = queue.poll();
				sum+=node.data;
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
				count--;
				
			}
			
			product*=sum;
		}
		
		return product;
		
	}

}
