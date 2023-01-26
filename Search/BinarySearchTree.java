
/**
 * BinearySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 * 
 * @author Hyojin Park
 * @version Date 11/18/2022
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    TreeNode<E> root; // the root of the tree
    
    /**
     * constructor create a empty binary search tree by setting root to be null
     */
    public BinarySearchTree(){
        root = null;
    }
    
    /**
     * search the given data in this binary search tree
     * If the data is found, return a reference to the tree node
     * othewise, return null
     * @param data The target to search
     * @return a TreeNode reference to the node that contains the data
     *         if no node contains data, return null
     */
    public TreeNode<E> search(E data){
        if(data != null){
            TreeNode<E> cur= root;
            while(cur != null){
                if(cur.getData().compareTo(data) == 0)
                    return cur;
                else if(cur.getData().compareTo(data) > 0)
                    cur = cur.getLeft();
                else
                    cur = cur.getRight();
            }
        }
        return null;
    }
    
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
        if(newNode != null){
            if(root == null){ // set newNode as root because there is empty tree
                newNode.setParent(null);
                root = newNode;
            }
            else{
                TreeNode<E> cur = root;
                while(cur != null){
                    if(cur.getData().compareTo(newNode.getData()) >= 0){
                        if(cur.getLeft() == null){
                            cur.setLeft(newNode);
                            newNode.setParent(cur);
                            return;
                        }
                        else{
                            cur = cur.getLeft();
                        }
                    }
                    else{
                        if(cur.getRight() == null){
                            cur.setRight(newNode);
                            newNode.setParent(cur);
                            return;
                        }
                        else{
                            cur= cur.getRight();
                        }
                    }
                }
            }
        }
        
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
        if(data != null){
            TreeNode<E> newNode = new TreeNode<E>(data);
            insert(newNode);
        }
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data){
        if(root != null && data != null){
        TreeNode<E> cur = search(data);
            if(cur != null){
                if(cur.isLeaf()){ // node is leaf node
                    if(cur.getParent() == null) // cur is root
                        root = null;
                    else if(cur.isLeftChild()) 
                        cur.getParent().setLeft(null); 
                    else 
                    cur.getParent().setRight(null); 
                }
                
                else if(cur.getRight() == null){ //Remove node with only left child
                    if(cur.getParent() == null){ 
                        root = root.getLeft(); 
                        root.setParent(null); 
                    }
                    else if(cur.isLeftChild()){ 
                        cur.getParent().setLeft(cur.getLeft()); 
                        cur.getLeft().setParent(cur.getParent()); 
                    }
                    else{ 
                        cur.getParent().setRight(cur.getLeft()); 
                        cur.getLeft().setParent(cur.getParent()); 
                    }
                }
                else if(cur.getLeft() == null){ //Remove node with only right child
                    if(cur.getParent() == null){ 
                        root = root.getRight(); 
                        root.setParent(null); 
                    }
                    else if(cur.isLeftChild()){ 
                        cur.getParent().setLeft(cur.getRight()); 
                        cur.getRight().setParent(cur.getParent());
                    }
                    else{ 
                    cur.getParent().setRight(cur.getRight()); 
                    cur.getRight().setParent(cur.getParent());
                    }
                }
                else{ //Remove node with two chilren
                    TreeNode<E> suc = cur.getRight(); //Find successor
                    if(suc.getLeft() == null){
                        if(cur.getParent() == null){
                            root.setData(suc.getData()); 
                            root.setRight(suc.getRight()); 
                            if(suc.getRight() != null) 
                                suc.getRight().setParent(root);
                        }
                        else{
                            cur.setData(suc.getData());
                            cur.setRight(suc.getRight()); // update right of curr to Right child of p
                                if(suc.getRight() != null) // p has right child, update its parent to cur
                                    suc.getRight().setParent(cur);
                        }
                    }
                    else{
                        while(suc.getLeft() != null)
                            suc = suc.getLeft();
                        if(cur.getParent() == null)
                            root.setData(suc.getData());
                        else
                            cur.setData(suc.getData());
                        suc.getParent().setLeft(suc.getRight());
                        if(suc.getRight() != null)
                            suc.getRight().setParent(suc.getParent());
                    }
                }
                    return true; //Node Found and removed
                }
        }
            return false; // Node not found
    }

    
    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString(){
        return "(" + nodeTravesal(root) + ")";
    }
    
    private String nodeTravesal(TreeNode<E> tree)
    {
        if(tree == null)
            return "-";
        return tree.getData().toString()
               + "(" + nodeTravesal(tree.getLeft())
               +", " + nodeTravesal(tree.getRight()) + ")";
    }

    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false othewise
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height(){
        return height(root);
    }
    
    private int height(TreeNode<E> tree){
        if(tree == null)
            return -1;
        int leftHeight = height(tree.getLeft());
        int rightHeight = height(tree.getRight());
        
        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }
    
    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size(){
        return size(root);     
    }
    
    public int size(TreeNode<E> tree){
        if(tree == null)
            return 0;
        else
            return 1+ size(tree.getLeft()) + size(tree.getRight());
    }
}