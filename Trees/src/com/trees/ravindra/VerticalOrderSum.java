package com.trees.ravindra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderSum {

	public static void main(String[] args) {

		Node tree = new Node(0);

		tree.left = new Node(1);
		tree.right = new Node(2);

		tree.left.left = new Node(3);
		tree.left.right = new Node(4);

		tree.left.left.left = new Node(7);
		tree.left.left.left.right = new Node(8);

		tree.left.right.left = new Node(14);
		tree.left.right.right = new Node(24);

		tree.left.right.left.left = new Node(34);
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		verticalOrderTraversal(tree,map,0);
		
		int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
		for(int key:map.keySet()){
			if(min>key){
				min = key;
			}
			if(max<key){
				max=key;
			}
		}
		
		for(int i=min;i<=max;i++){
			System.out.println(map.get(i));
			ArrayList<Integer> list = map.get(i); int sum= 0;
			
			for(int j=0;j<list.size();j++){
				sum+=list.get(j);
			}
			System.out.println("Sum at vertex:"+ i +"is" + sum);
		}
		
		
		
	}
	
	
	static void verticalOrderTraversal(Node node, Map<Integer,ArrayList<Integer>> map, int distance){
		
		if(node==null){
			return;
		}
		if(map.containsKey(distance)){
			ArrayList<Integer> list = map.get(distance);
			list.add(node.data);
			map.put(distance, list);
		}else{
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(node.data);
			map.put(distance, list);
		}
		
		verticalOrderTraversal(node.left , map,distance-1);
		verticalOrderTraversal(node.right,map,distance+1);
	}

}
