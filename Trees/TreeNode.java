// ============================
// Class TreeNode stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.
// CIS 203 Computer Science II
// Last modified 29 April 2019 L. Grabowski
// ============================
public  class TreeNode<E> {
    
    public E data;              // data stored in this node
    public TreeNode<E> left;   // left subtree
    public TreeNode<E> right;  //  right subtree
    
    // Post: constructs a leaf node with given data
    public TreeNode(E data) {
        this(data, null, null);
    }
    
    // Post: constructs a node with the given data and links
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    // Returns: String representation of the tree as an inorder traversal
    public String toString () {
        return toString (this);
    }
    
    // Parameter: A TreeNode
    // Returns: String representation of the tree as an inorder traversal
    private String toString(TreeNode tn) {
        if (tn == null)
            return "";
        return toString(tn.left) + " " + tn.data + " " + toString (tn.right);
    }
}

