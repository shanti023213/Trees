package com.trees.ravindra;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConstructTreeFromAncestor {

	public static void main(String[] args) {
	
/*
	    int[][] mat = 	  {{ 0, 0, 0, 0, 0, 0 },
					       { 1, 0, 0, 0, 1, 0 },
					       { 0, 0, 0, 1, 0, 0 },
					       { 0, 0, 0, 0, 0, 0 },
					       { 0, 0, 0, 0, 0, 0 },
					       { 1, 1, 1, 1, 1, 0 } };*/
		
		
		 int[][] mat = 	  {{ 0, 1, 1, 1, 1, 1 },
					       { 0, 0, 0, 0, 0, 1 },
					       { 0, 0, 0, 1, 1, 0 },
					       { 0, 0, 0, 0, 0, 0 },
					       { 0, 0, 0, 0, 0, 0 },
					       { 0, 0, 0, 0, 0, 0 } };
	    
	    Node n = constructTree(mat);

	}
	
	public static Node constructTree(int[][] mat){
	
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<mat.length;i++){
			int sum =0;
			for(int j=0;j<mat[0].length;j++){
				
				if(mat[i][j] ==1){
					sum++;
				}
			}
			map.put(i,sum);
		}
		System.out.println("Populated map with index and sum"+map);
		
		HashMap<Integer, Integer> sortedMap = sortByValues(map);
		System.out.println("Sorted map with index and sum"+sortedMap);
		Node[] nodeArray = new Node[mat.length];
		boolean[] parentSet = new boolean[mat.length];
		Node root =null;
		
		for(Integer key:sortedMap.keySet()){
			
				Node n = new Node(key);
				root= n;
				nodeArray[key] =n;
			
			
				if(sortedMap.get(key) != 0){
					
					for(int i=0;i<mat.length;i++){
						if(mat[key][i] ==1 && !parentSet[i]){
							if(n.left==null){
								n.left = nodeArray[i];
								parentSet[i]=true;
							}else if(n.right==null){
								n.right = nodeArray[i];
								parentSet[i]=true;
							}
						}
					}
				}
		
		}	
	
	return root;
	}
	
	private static HashMap<Integer, Integer> sortByValues(HashMap<Integer, Integer> map) {
		List<Entry<Integer,Integer>> list = new LinkedList(map.entrySet());
		Collections.sort(list,new ValueComparator());
		
		System.out.println("*******");
		
		HashMap<Integer,Integer> newMap = new LinkedHashMap<Integer,Integer>();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
			newMap.put(entry.getKey(), entry.getValue());
		}
		
		return newMap;
	}
}

class ValueComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		return (((Map.Entry<Integer, Integer>)o1).getValue() - ((Map.Entry<Integer, Integer>)o2).getValue());
	}
	
}
