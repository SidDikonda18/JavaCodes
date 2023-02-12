import java.util.*;

public class BinaryTrees{

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int data){
            this.val = data;
            this.left=null;
            this.right=null;
        }
    }

    
    static int index=-1;
    public static Node buildTree(int nodes[]){
        index++;
        if(nodes[index]==-1){
            return null;
        }
        Node newNode=new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    // In-Order Traversal
    public static void inOrder(Node root){
        if(root==null)
            return;            
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

    // Pre-Order Traversal
    public static void preOrder(Node root){
        if(root==null)
            return;            
        System.out.print(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Post-Order Trversal
    public static void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+ " ");
    }

    // Level Order Traversal
    /*public static void levelOrder(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();   // something wrong with this maannn
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                System.out.print(curr.val+" ");
            }
        }
    }*/


    // Height of Tree
    public static int heightOfTree(Node root){
        if(root==null)
            return 0;
        int left=heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right)+1;
    }

    //count nodes of tree
    public static int countNodes(Node root){
        //static int ct=0;
        if(root==null)
            return 0;
        
        int left=countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
        
    }

    //sum of nodes of tree
    public static int sumOfNodes(Node root){
        if(root==null)
            return 0;
        int left=sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left+right+root.val;
    }

    // Diameter of the tree : Diameter means the maximum length of the tree from 1 leaf to another 
    public static int diameterOfTree(Node root){       // O(n^2)
        if(root==null)
            return 0;
        int leftDia = diameterOfTree(root.left);  // calculate the diameter of the left side
        int rightDia = diameterOfTree(root.right);  // calculate diameter of right side
        int leftHeight = heightOfTree(root.left);   // calculate height of left side
        int rightHeight = heightOfTree(root.right); // calsulate heght of right side
        int currDia= rightHeight+leftHeight +1;     // if diameter will goes through current node then we have to add 1 to the both height
        return Math.max(currDia, Math.max(rightDia, leftDia));     // return the highest of all the diameters
    }



    // Diameter of tree : same with faster approach 



    




    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};       // preorder sequence

        BinaryTrees tree=new BinaryTrees();
        Node root= tree.buildTree(nodes);
        // System.out.println(root.val);
        // tree.preOrder(root);
        // System.out.println();
        // bt.inOrder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.heightOfTree(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.diameterOfTree(root));
    }
}