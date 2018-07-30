package com.trees.ravindra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderTraversal {

	
	static Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
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
        Map<Integer,ArrayList<Integer>> map =verticalOrderTraversal(tree,0);
        System.out.println("**");

	}
	
	public static Map<Integer,ArrayList<Integer>> verticalOrderTraversal(Node node ,int index){
		
		if(node!=null){
			
			ArrayList<Integer> list = map.get(index);
			
			if(list == null){
				list = new ArrayList<Integer>(); 
			}
			
				list.add(node.data);
				map.put(index, list);
				
				verticalOrderTraversal(node.left,index-1);
				verticalOrderTraversal(node.right,index+1);
			}
		
		return map;
	}

}
