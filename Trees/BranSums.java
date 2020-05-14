import java.util.*;

class BranSums {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> result = new LinkedList<>();
		branchSums(root, result, 0);
    return result;
  }
	
	private static void branchSums(BinaryTree node, List<Integer> result, int valueCount) {
		if (node == null) return;
		
		valueCount+=node.value;
		if(node.right == null && node.left == null) {
		  result.add(valueCount);
		}
		
		branchSums(node.left, result, valueCount);
	  branchSums(node.right, result, valueCount);
	}
}
