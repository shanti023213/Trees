package com.trees.ravindra;


class ConvertToDLL 
{
 Node root;
 /* This is the core function to convert Tree to list. This function
    follows steps 1 and 2 of the above algorithm */

 Node bintree2listUtil(Node node, Node previous) 
 {
     // Base case
     if (node == null)
         return node;
     
     if(node.left==null && node.right==null){
    	 return node;
     }

     Node left = bintree2listUtil(node.left,previous);
     // Convert the left subtree and link to root
     if (left != null) 
     {
         left.right = node;

         // Make predecssor as previous of root
         node.left = left;
         
         if(previous!=null){
        	 left.left =previous;
        	 previous.right =left;
         }
     }

     Node right = bintree2listUtil(node.right,node);
     // Convert the right subtree and link to root
     if (right != null) 
     {
        if(right.left==null){
        	right.left= node;
        } 

        return right;
     }

     return node;
 }

 // The main function that first calls bintree2listUtil(), then follows
 // step 3 of the above algorithm
   
 Node bintree2list(Node node) 
 {
     // Base case
     if (node == null)
         return node;

     // Convert to DLL using bintree2listUtil()
     node = bintree2listUtil(node,null);

     // bintree2listUtil() returns root node of the converted
     // DLL.  We need pointer to the leftmost node which is
     // head of the constructed DLL, so move to the leftmost node
     while (node.left != null)
         node = node.left;

     return node;
 }

 /* Function to print nodes in a given doubly linked list */
 void printList(Node node) 
 {
     while (node != null) 
     {
         System.out.print(node.data + " ");
         node = node.right;
     }
 }

 /* Driver program to test above functions*/
 public static void main(String[] args) 
 {
	 ConvertToDLL tree = new ConvertToDLL();

	 Node root = new Node(10);
     root.left = new Node(12);
     root.right = new Node(15);
     root.left.left = new Node(25);
     root.left.right = new Node(30);
     root.left.right.left = new Node(1);
     root.left.right.right = new Node(2);
     root.right.left = new Node(36);

     // Convert to DLL
     Node head = tree.bintree2list(root);

     // Print the converted list
     tree.printList(head);
 }
}