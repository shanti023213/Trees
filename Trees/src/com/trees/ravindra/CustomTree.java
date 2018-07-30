package com.trees.ravindra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode{
	
	char data;
	ArrayList<TreeNode> children;
	
	public TreeNode(char data){
		this.data =data;
		children = new ArrayList<TreeNode>();
	}
	
	public void addChildren(TreeNode n){
		children.add(n);
	}
}
public class CustomTree {
	

    public static void main(String[] args) {
        String [] links1 = {"a b", "b c", "b d", "a e"};
        System.out.println("------------ Forest 1 ----------------");
        printForest(links1);       
         
        String [] links2 = {"a b", "a g", "b c", "c d", "d e", "c f",
                            "z y", "y x", "x w"};
        System.out.println("------------ Forest 2 ----------------");
        printForest(links2);      
    }
	
    public static void printForest(String[] links){
    	Map<Character,TreeNode> nodesMap = new HashMap<Character, TreeNode>();
    	Set<Character> forestSet = new HashSet<Character>();
    	
    	for(String link: links){
    		String[] linkElements = link.split(" ");
    		char node1 = linkElements[0].charAt(0);
    		char node2 = linkElements[1].charAt(0);
    		if(!nodesMap.containsKey(node1)){
    			nodesMap.put(node1, new TreeNode(node1));
    			forestSet.add(node1);
    		}
    		if(!nodesMap.containsKey(node2)){
    			nodesMap.put(node2, new TreeNode(node2));
    		}
    		
    		if(forestSet.contains(node2)){
    			forestSet.remove(node2);
    		}
    		
    		nodesMap.get(node1).addChildren(nodesMap.get(node2));
    	}
    	
    	printNodes(nodesMap,forestSet);
    }
    
    public static void printNodes(Map<Character,TreeNode> nodesMap, Set<Character> forestSet){
    	
    	for(Character key: forestSet){
    		TreeNode root = nodesMap.get(key);
    		System.out.println("-->"+root.data);
    		printTree(root,"");
    	}
    	
    }
    
    public static void printTree(TreeNode root, String indent){
    	
    	
    	for(TreeNode node : root.children){
    			System.out.println("   "+indent+"|-->" + node.data);
    			printTree(node,"  "+indent+"  ");
    		
    	}
    }
}