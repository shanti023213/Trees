package com.trees.ravindra;

public class AncestorBST {

	static Node tree;

	public static void main(String[] args) {
		
		tree = new Node(50);
        tree.left = new Node(30);
        tree.right = new Node(70);
        
        tree.left.left = new Node(20);
        tree.left.right = new Node(40);
  
        tree.left.right.left = new Node(35);
        tree.left.right.right = new Node(45);
        
        tree.right.left = new Node(60);
        tree.right.right = new Node(80);
        
        if(LCA1(tree, 200,300)!=null){
        	System.out.println("LCA: "+ LCA1(tree, 200,300).data);
        }else{
        	System.out.println("Could not find the elements in the given tree");
        }
        
        System.out.println("LCA: "+ LCA2(tree, 60,70));
	   
      
        
   }
	
	// Method where the elements may not be available in the tree
	public static Node LCA1(Node node, int p, int q){
		
		if(node==null || node.data== p || node.data ==q){
			return node;
		}
	
		if((node.data<p  && node.data>q) || node.data >p && node.data<q){
			return node;
		}
		
		if(node.data<p && node.data <q){
			return LCA1(node.right,p,q);
		}
		
		if(node.data>p && node.data >q){
			return LCA1(node.left,p,q);
		}
		
		else
			return null;
		
	}
	
	//Elements must be availble in the tree and given node is not null
	public static int LCA2(Node node,int p ,int q){
		
		if(node==null){
			return -1;
		}
		if(node.data <p && node.data<q){
			return LCA2(node.right,p,q);
		}
		
		if(node.data >p && node.data>q){
			return LCA2(node.left,p,q);
		}
		
		return node.data;
		 
	}
	
	
}
