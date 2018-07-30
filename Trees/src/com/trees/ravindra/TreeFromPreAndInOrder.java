package com.trees.ravindra;

class CharNode {
	
	char data;
	CharNode left;
	CharNode right;
	
	public CharNode(char data){
		this.data = data;
	}
}


public class TreeFromPreAndInOrder {

	public static int index= 0;
	public static void main(String args[]) 
    {
        
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        
        CharNode root = buildTree(pre,in);
        printInorder(root);
  
    }
	
	
	public static CharNode buildTree(char[] preorder , char[] inorder){
		if(preorder ==null || preorder.length==0||
				inorder ==null || inorder.length==0 || preorder.length!=inorder.length){
			return null;
		} else if(preorder.length <=1){
			return new CharNode(preorder[0]);
		}
		
		CharNode node = constructTree(preorder,inorder,0,preorder.length-1);
		return node;
	}
	
	
	public static CharNode constructTree (char[] preorder, char[] inorder, int start,int end){
	
		if(start>end){
			return null;
		}
		
		char data = preorder[index++];
		
		CharNode n = new CharNode(data);
		
		if(start == end){
			return n;
		}
		
		int indexInInorder = searchInorder(inorder, data);
		n.left = constructTree(preorder,inorder,start,indexInInorder-1);
		n.right = constructTree(preorder,inorder,indexInInorder+1,end);
		
		return n;
	}
	
	public static int searchInorder(char[] inorder, char data){
		
		for(int i=0;i<inorder.length;i++){
			if(inorder[i]==data){
				return i;
			}
		}
		
		
		return 0;
	}
	
	 static void printInorder(CharNode node) 
	    {
	        if (node == null)
	            return;
	  
	        /* first recur on left child */
	        printInorder(node.left);
	  
	        /* then print the data of node */
	        System.out.print(node.data + " ");
	  
	        /* now recur on right child */
	        printInorder(node.right);
	    }
	  
}


