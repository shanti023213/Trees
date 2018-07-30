package com.trees.ravindra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiagonalTraversal {

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
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        diagonalTraversal(tree,map,0);
        
        int min =Integer.MAX_VALUE; int max =Integer.MIN_VALUE;
        
        for(int key:map.keySet()){
        	if(min>key){
        		min =key;
        	}
        	if(max<key){
        		max=key;
        	}
        }
		
        for(int i=min;i<=max;i++){
        	System.out.println(map.get(i));
        }

	}
	
	public static void diagonalTraversal(Node node,  Map<Integer,ArrayList<Integer>> map, int diagonal){
		if(node==null){
			return;
		}
		if(map.containsKey(diagonal)){
			ArrayList<Integer> list = map.get(diagonal);
			list.add(node.data);
			map.put(diagonal, list);
		}else{
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(node.data);
			map.put(diagonal, list);
		}
		diagonalTraversal(node.left,map,diagonal+1);
		diagonalTraversal(node.right,map,diagonal);
		
	}

}
