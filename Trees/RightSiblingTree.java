class RightSiblingTree {
  public static BinaryTree rightSiblingTree(BinaryTree root) {		
		convertToRightSiblingTree(root, null, false);
    return root;
  }
	
	private static void convertToRightSiblingTree(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
		if(node == null) return;
		
		var left = node.left;
		var right = node.right;
		
	  convertToRightSiblingTree(left, node, true);
		if(isLeftChild) {
			node.right = parent.right;
		} else {
			if(parent == null) {
				node.right = null;
			} else {
				if(parent.right != null) {
					node.right = parent.right.left;
				} else {
					node.right = null;
				}
			}
		}
		
		convertToRightSiblingTree(right, node, false);
	} 

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
