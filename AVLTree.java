/**
 *
 * AVLTree
 *
 * An implementation of a׳� AVL Tree with
 * distinct integer keys and info.
 *
 */
import java.util.*;
public class AVLTree {

  /**
   * public boolean empty()
   *
   * Returns true if and only if the tree is empty.
   *
   */
  private AVLNode root = null; 
  
  
  public AVLTree(IAVLNode root){
	  this.root = (AVLNode)root;
  }
	
  public boolean empty() {
	  
	  if (this.root == null)
		  return true;
    return false;
  }

 /**
   * public String search(int k)
   *
   * Returns the info of an item with key k if it exists in the tree.
   * otherwise, returns null.
   */
  public String search(int k)
  {		
	  return (searchTree(this.root, k));	  
  }
  
  private String searchTree(AVLNode node, int k)
  {
	  if (node == null)
		  return null;
	  if (node.key == k)
		  return node.info;
	  String leftSide = searchTree((AVLNode)node.left, k);
	  String rightSide = searchTree((AVLNode)node.right, k);
	  if (leftSide != null)
		  return leftSide;
	  return rightSide;
  }

  /**
   * public int insert(int k, String i)
   *
   * Inserts an item with key k and info i to the AVL tree.
   * The tree must remain valid, i.e. keep its invariants.
   * Returns the number of re-balancing operations, or 0 if no re-balancing operations were necessary.
   * A promotion/rotation counts as one re-balance operation, double-rotation is counted as 2.
   * Returns -1 if an item with key k already exists in the tree.
   */
   public int insert(int k, String i) {
	   
	  return 420;	// to be replaced by student code
   }
   
   public void rotateLeftToRight() {
	   
   }
   
   ///from the internat!!
   public AVLNode rotateRight(AVLNode y) {
	   AVLNode x = (AVLNode)y.left;
	   AVLNode z = (AVLNode)x.right;
	    x.right = y;
	    y.left = z;
	    setHeight(y);
	    setHeight(x);
	    return x;
	}
   
   public AVLNode rotateLeft(AVLNode y) {
	   AVLNode x = y.right;
	   AVLNode z = x.left;
	    x.left = y;
	    y.right = z;
	    setHeight(y);
	    setHeight(x);
	    return x;
	}

	
/////

   
   

  /**
   * public int delete(int k)
   *
   * Deletes an item with key k from the binary tree, if it is there.
   * The tree must remain valid, i.e. keep its invariants.
   * Returns the number of re-balancing operations, or 0 if no re-balancing operations were necessary.
   * A promotion/rotation counts as one re-balance operation, double-rotation is counted as 2.
   * Returns -1 if an item with key k was not found in the tree.
   */
   public int delete(int k)
   {
	   return 421;	// to be replaced by student code
   }

   /**
    * public String min()
    *
    * Returns the info of the item with the smallest key in the tree,
    * or null if the tree is empty.
    */
   public String min()
   {
	   if (this.empty())
		   return null;
	   AVLNode node = this.root;
	   while (node.left!=null)
		   node=(AVLNode)node.left;	 
	   return node.info;
   }

   /**
    * public String max()
    *
    * Returns the info of the item with the largest key in the tree,
    * or null if the tree is empty.
    */
   public String max()
   {
	   if (this.empty())
		   return null;
	   AVLNode node = this.root;
	   while (node.right!=null)
		   node=(AVLNode)node.right;	 
	   return node.info;
   }

  /**
   * public int[] keysToArray()
   *
   * Returns a sorted array which contains all keys in the tree,
   * or an empty array if the tree is empty.
   */
  public int[] keysToArray()
  {
	  if (this.empty())
		  return new int[] {};
	  int size= this.size();
	  AVLNode node = this.root;
      int[] array = new int[size];
      int index = 0;
 	 Stack <AVLNode> stk = new Stack<>();  
 	 AVLNode rootpoint = node;
 	 stk.push(node);
 	 while(rootpoint != null || !stk.isEmpty()) {
 		 while(rootpoint != null && rootpoint.left != null) {
 			 rootpoint= (AVLNode)rootpoint.left;
 			 stk.push(rootpoint);
 		 }
 		 rootpoint=stk.pop();
 		 array[index] = rootpoint.key;
 		 index++;
 		 rootpoint=(AVLNode)rootpoint.right;
 		 if (rootpoint!=null) {
 			 stk.push(rootpoint);
 		 }
 	 }
 	 return array;
  }

  
  /**
   * public String[] infoToArray()
   *
   * Returns an array which contains all info in the tree,
   * sorted by their respective keys,
   * or an empty array if the tree is empty.
   */
  public String[] infoToArray()
  {
	  if (this.empty())
		  return new String[] {};
	  int size= this.size();
	  AVLNode node = this.root;
      String[] array = new String[size];
      int index = 0;
 	 Stack <AVLNode> stk = new Stack<>();  
 	 AVLNode rootpoint = node;
 	 stk.push(node);
 	 while(rootpoint != null || !stk.isEmpty()) {
 		 while(rootpoint != null && rootpoint.left != null) {
 			 rootpoint= (AVLNode)rootpoint.left;
 			 stk.push(rootpoint);
 		 }
 		 rootpoint=stk.pop();
 		 array[index] = rootpoint.info;
 		 index++;
 		 rootpoint=(AVLNode)rootpoint.right;
 		 if (rootpoint!=null) {
 			 stk.push(rootpoint);
 		 }
 	 }
 	 return array;
  }

   /**
    * public int size()
    *
    * Returns the number of nodes in the tree.
    */
   public int size()
   {
	   
	   return (size_rec(this.root));
   }
   
   
   public int size_rec(AVLNode node)
   {
	   if (node==null)
		   return 0;
	   return 1+ size_rec((AVLNode)node.right) + size_rec((AVLNode)node.left);
   }
   
   /**
    * public int getRoot()
    *
    * Returns the root AVL node, or null if the tree is empty
    */
   public IAVLNode getRoot()
   {
	   return this.root;
   }
   
   /**
    * public AVLTree[] split(int x)
    *
    * splits the tree into 2 trees according to the key x. 
    * Returns an array [t1, t2] with two AVL trees. keys(t1) < x < keys(t2).
    * 
	* precondition: search(x) != null (i.e. you can also assume that the tree is not empty)
    * postcondition: none
    */   
   public AVLTree[] split(int x)
   {
	   return null; 
   }
   
   /**
    * public int join(IAVLNode x, AVLTree t)
    *
    * joins t and x with the tree. 	
    * Returns the complexity of the operation (|tree.rank - t.rank| + 1).
	*
	* precondition: keys(t) < x < keys() or keys(t) > x > keys(). t/tree might be empty (rank = -1).
    * postcondition: none
    */   
   public int join(IAVLNode x, AVLTree t)
   {
	   return -1;
   }

	/** 
	 * public interface IAVLNode
	 * ! Do not delete or modify this - otherwise all tests will fail !
	 */
	public interface IAVLNode{	
		public int getKey(); // Returns node's key (for virtual node return -1).
		public String getValue(); // Returns node's value [info], for virtual node returns null.
		public void setLeft(IAVLNode node); // Sets left child.
		public IAVLNode getLeft(); // Returns left child, if there is no left child returns null.
		public void setRight(IAVLNode node); // Sets right child.
		public IAVLNode getRight(); // Returns right child, if there is no right child return null.
		public void setParent(IAVLNode node); // Sets parent.
		public IAVLNode getParent(); // Returns the parent, if there is no parent return null.
		public boolean isRealNode(); // Returns True if this is a non-virtual AVL node.
    	public void setHeight(int height); // Sets the height of the node.
    	public int getHeight(); // Returns the height of the node (-1 for virtual nodes).
	}
	
	/**
	 * 
	 */

   /** 
    * public class AVLNode
    *
    * If you wish to implement classes other than AVLTree
    * (for example AVLNode), do it in this file, not in another file. 
    * 
    * This class can and MUST be modified (It must implement IAVLNode).
    */
  public class AVLNode implements IAVLNode{
	  
	    private int key;
	    private String info;
	    private int rank;
	    private IAVLNode parent;
	    private IAVLNode left;
	    private IAVLNode right;
	    
	    public AVLNode(int key, String info ) {
	    	this.key=key;
	    	this.info= info;
	    	this.rank= -1;
	    	this.parent =null;
	    	this.left= null;
	    	this.right= null;
	    	
	    }
	  
		public int getKey()
		{
			return this.key;
		}
		public String getValue()
		{
			return this.info;
		}
		public void setLeft(IAVLNode node)
		{
			this.left=node; 
		}
		public IAVLNode getLeft()
		{
			return this.left;
		}
		public void setRight(IAVLNode node)
		{
			this.right=node; 
		}
		public IAVLNode getRight()
		{
			return this.right;
		}
		public void setParent(IAVLNode node)
		{
			this.parent=node; 
		}
		public IAVLNode getParent()
		{
			return this.parent;
		}
		public boolean isRealNode()
		{
			return (this.rank == -1);
		}
	    public void setHeight(int height)
	    {
	        this.rank=height;
	    }
	    public int getHeight()
	    {
	        return this.rank; 
	    }
  }

}
  
