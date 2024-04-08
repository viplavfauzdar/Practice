package com.java8;

public class BinaryTree {


    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }


    //breadth first search, depth first search, divide & conquer (quick/merge sort)


    //[7,3,5,1,8,6] - Breadth first (level order)
    static TreeNode insertNodeLevelOrder(TreeNode root, int arr[], int i){
        if(i<arr.length) {
            root = new TreeNode(arr[i]);
            root.left = insertNodeLevelOrder(root.left, arr, 2 * i + 1);
            root.right = insertNodeLevelOrder(root.right, arr, 2 * i + 2);
        }
        return root;
    }

    // Recursive function to insert a key into BST
    static TreeNode insertBST(TreeNode root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        if (key < root.val) {
            root.left = insertBST(root.left, key);
        }

        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insertBST(root.right, key);
        }

        return root;
    }

    static TreeNode insertBSTIterative(TreeNode root, int key){
        // start with root node
        TreeNode curr = root;

        // pointer to store parent node of current node
        TreeNode parent = null;

        // if tree is empty, create a new node and set root
        if (root == null) {
            return new TreeNode(key);
        }

        // traverse the tree and find parent node of key
        while (curr != null){
            // update parent node as current node
            parent = curr;
            if(key < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }

        // construct a new node and assign to appropriate parent pointer
        if(key < parent.val)
            parent.left = new TreeNode(key);
        else
            parent.right = new TreeNode(key);

        return root;
    }


    static TreeNode insertIterative(TreeNode root, int key, int i){
        // start with root node
        TreeNode curr = root;

        // pointer to store parent node of current node
        TreeNode parent = null;

        // if tree is empty, create a new node and set root
        if (root == null) {
            return new TreeNode(key);
        }

        // traverse the tree and find parent node of key
        while (curr != null){
            // update parent node as current node
            parent = curr;
            if(i % 2 !=0)
                curr = curr.left;
            else
                curr = curr.right;
        }

        // construct a new node and assign to appropriate parent pointer
        if(i % 2 !=0)
            parent.left = new TreeNode(key);
        else
            parent.right = new TreeNode(key);

        return root;
    }

    //depth first - In Order - left, root, right
    //Time Complexity - O(n), Space - O(n)
    static void traverseInOrder(TreeNode node){
        if(node!=null){
            traverseInOrder(node.left);
            logS(node.val + " ");
            traverseInOrder(node.right);
        }
    }

    //depth first - Pre Order - root, left, right
    //Time Complexity - O(n), Space - O(n)
    static void traversePreOrder(TreeNode node){
        if(node!=null){
            logS(node.val + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //depth first - Post Order - left, right, root
    //Time Complexity - O(n), Space - O(n)
    static void traversePostOrder(TreeNode node){
        if(node!=null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            logS(node.val + " ");
        }
    }

    //Breadth First - Level Order Traversal
    //Time Complexity - O(n^2), Space - O(n)
    static void traverseLevelOrder(TreeNode root){
        if(root!=null){
            int h=height(root);
            for(int i=1;i<=h;i++)
                printNodeLevelOrder(root, i);
        }
    }

    static void printNodeLevelOrder(TreeNode node, int l){
        if(node!=null){
            if(l==1){
                logS(node.val+" ");
            }else{ //l > 1
                printNodeLevelOrder(node.left, l-1);
                printNodeLevelOrder(node.right, l-1);
            }
        }
    }

    //Search depth first - pre order
    static boolean search(TreeNode root, int n){
        if(root==null) return false;
        if(root.val==n) return true;
        boolean ret1 = search(root.left, n);
        if(ret1) return true;
        return search(root.right, n);
    }

    int height1(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }


    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    //height = # edges + 1
    static int height(TreeNode root){
        if(root==null) {
            return 0;
        }else{
            /* compute  height of each subtree */
            int hL = height(root.left);
            int hR = height(root.right);

            /* use the larger one */
            if(hL>hR)
                return hL+1;
            else
                return hR+1;
        }
    }

    static boolean isHeightBalanced(TreeNode root){
        if(root==null) {
            return true;
        }else{
            /* compute  height of each subtree */
            int hL = height(root.left);
            int hR = height(root.right);

            /* use the larger one */
            if(Math.abs(hL-hR)<=1 && isHeightBalanced(root.left) && isHeightBalanced(root.right))
                return true;

            return false;
        }
    }


    //give the # of nodes, math for height for a height balanced (or self-balancing) tree (minimum height in that case)
    static long heightMath(int n){
        return Math.round(Math.log10(n+1)/Math.log10(2));
    }

    //check BST - Time: O(n), Space: O(1) if Function Call Stack size is not considered, otherwise O(n)
    static boolean isBST(TreeNode root, TreeNode left, TreeNode right){
        if(root==null) return true;
        if(left!=null && root.val<=left.val) return false;
        if(right!=null && root.val>=right.val) return false;
        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }

    //In Order traversal
    static TreeNode prev;
    static boolean isBST2(TreeNode node){
        if(node==null) return true;
        if(!isBST2(node.left)) return false;
        if(prev!=null && node.val <=prev.val) return false;
        prev = node;
        return isBST2(node.right);
    }

    /**             7
     *             / \
     *             3  5
     *            / \ /
     *           1  8 6
     */
    public static void main(String...args){
        int[] arr = {7,3,5,1,8,6};
        TreeNode root = new TreeNode();
        root = insertNodeLevelOrder(root, arr, 0);
        logS("Depth First - In Order\n");
        traverseInOrder(root);
        logS("\nDepth First - Pre Order\n");
        traversePreOrder(root);
        logS("\nDepth First - Post Order\n");
        traversePostOrder(root);
        logS("\nHeight\n");
        logS(""+height(root));
        logS("\nBreadth First - Level Order\n");
        traverseLevelOrder(root);
        logS("\nMinimum Height or Height of Balanced Tree:\n");
        logS(""+heightMath(6));
        logS("\nSearch\n");
        logS(search(root, 8)+"\n");
        logS(search(root,9)+"\n");
        logS("Is Height Balanced: " + isHeightBalanced(root));
        System.out.println("\nIS BST: " + isBST(root, null, null));
        System.out.println("IS BST2: " + isBST2(root));
        TreeNode node1 = null;
        for(int i=0;i<arr.length;i++){
            node1 = insertIterative(node1, arr[i], i);
        }
        logS("Create Iterative: ");
        logN(node1);

        int[] arr1 = {5,3,1,6,7,8}; //array has to be BST. More than one way.
        TreeNode node = null;
        for(int i=0;i<arr1.length;i++)
            node = insertBST(node,arr1[i]);
        logS("\nCreate BST Recursive: ");
        logN(node);

        node = null;
        for(int i=0;i<arr1.length;i++)
            node = insertBSTIterative(node,arr1[i]);
        logS("\nCreate BST Iterative: ");
        logN(node);

        /**        BST
         *          4
         *         / \
         *       2    5
         *      / \
         *     1   3
         */
        int[] arr2 = {4,2,5,1,3};
        TreeNode root1 = new TreeNode();
        root1 = insertNodeLevelOrder(root1, arr2, 0);
        logS("\nDepth First - In Order\n");
        traverseInOrder(root1);
        System.out.println("\nIS BST: " + isBST(root1, null, null));
        System.out.println("IS BST2: " + isBST2(root1));
        logS("Is Height Balanced: " + isHeightBalanced(root1));

        /**        Not Height Balanced
         *          4
         *         / \
         *       2    5
         *      /
         *     1
         *    /
         *   6
         */
        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(1);
        root2.left.left.left = new TreeNode(6);
        logS("\n");logN(root2);
        logS("\nIs Height Balanced: " + isHeightBalanced(root2));

    }

    static void logS(String str){
        System.out.print(str);
    }

    static void log(int x){
        System.out.print(x);
    }

    static void logN(TreeNode node){System.out.print(node);}

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
