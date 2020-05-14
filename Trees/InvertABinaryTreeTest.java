class InvertABinaryTreeTest {
  public static void invertBinaryTree(BinaryTree node) {
    if(node == null)
			return;
		
		var right = node.right;
		var left = node.left;
		node.right = left;
		node.left = right;
		
		invertBinaryTree(left);
		invertBinaryTree(right);
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
