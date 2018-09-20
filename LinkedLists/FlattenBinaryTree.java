// Given a binary tree, flatten it to a linked list in-place.
//
// For example, given the following tree:
//
//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
// The flattened tree should look like:
// 
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTree.java {
    public void flatten(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        if(root == null || (root.left == null && root.right == null)) {
            return;
        } 
        
        TreeNode currentNode = root;
        nodeStack.push(currentNode.right);
        nodeStack.push(currentNode.left);
        while(!nodeStack.isEmpty()) {
            TreeNode nextNode = nodeStack.pop();
            if(nextNode == null) {
                continue;
            }
        
            currentNode.left = null;
            currentNode.right = nextNode;
            
            if(nextNode.right != null) {
                nodeStack.push(nextNode.right);
            }
            
            if(nextNode.left != null) {
                nodeStack.push(nextNode.left);
            } 
            currentNode = nextNode;
        }
        
        currentNode.left = null;
        currentNode.right = null;
    }
}
