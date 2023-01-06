//! We pass -1 to move to right child of the Binary tree...
//* The PreOrder of Build Tree is 1, 2, 4, -1(a), -1(b), 5, -1(c), -1(d), 3, -1(e), 6, -1(f), -1(g)
/*                                  1
 *                                 / \
 *                                /   \
 *                               2      3           ** -1 Node is not added in the tree and made null...
 *                              / \    / \ 
 *                             /   \  -1  \
 *                            4     5 (e)  6        ** When both Nodes are occupied we backtrack...
 *                           /\     /\     /\
 *                          /  \   /  \   /  \
 *                         -1  -1  -1  -1 -1  -1
 *                         (a) (b) (c) (d)(f)  (g)
 *  */
import java.util.*;
public class Binary     // Superclass to encapsulate both Node and BinaryTree class...
{
    public class Node     // Node class to define Properties of Nodes...
    {
        public int data;
        public Node left;
        public Node right;
        public Node(int value)    // Parametrized Constructor...
        {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
    public class BinaryTree       // Binary Tree class to define Functions and Properties...
    {
        static int i = -1;
        public Node InsertNode(int nodes[])
        {
            i++;     // Static variable so value remains unique for entire class...
            if(nodes[i] == -1)     // -1 value to backtrack to parent node...
                return null;
            Binary tree = new Binary();   // Creating object of Superclass Class...
            Node newNode = tree.new Node(nodes[i]);     // Using new Operator for subset class...
            newNode.left = InsertNode(nodes);    // We first fill Left Child...
            newNode.right = InsertNode(nodes);   // We then fill right Child...
            return newNode;
        }
        public void ShowTree(Node root)
        {
            if(root == null)   // If Tree is empty nothing to show
                return;            // Control moves out of the function
            Node temp = root;
            ShowTree(root.left);     // Recursive Call
            System.out.println("Node: ");
            if(root.left != null)    // If left subtree is not empty
                System.out.println("\t"+temp.data+" ---> "+temp.left.data+"\t Left ( Occupied )");
            else      // If left subtree is empty
                System.out.println("\t"+temp.data+"\t\t Left ( Empty )");
            if(root.right != null)   // If right subtree is not empty
                System.out.println("\t"+temp.data+" ---> "+temp.right.data+"\t Right ( Occupied ) ");
            else     // If right subtree is empty
                System.out.println("\t"+temp.data+"\t\t Right ( Empty )");
            ShowTree(root.right);     // Recursive Call
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Binary binary = new Binary();     // Creating object of Superclass...
        BinaryTree binarytree = binary.new BinaryTree();    // Using new operator and Superclass to define object of subclass...
        Node root = binarytree.InsertNode(node);    // Calling function and passing the Nodes array...
        binarytree.ShowTree(root);     // Printing Root Node...
        int node1[] = {1, 2, 4, 7, -1, -1, -1, 5, -1, 8, -1, -1, 3, 6, -1, -1, -1};
        Binary binary1 = new Binary();
        BinaryTree bnry = binary1.new BinaryTree();
        Node root1 = bnry.InsertNode(node1);
        bnry.ShowTree(root1); 
        sc.close();
    }
}

// Time Complexity  - O(log n) time...
// Space Complexity - O(n) space...