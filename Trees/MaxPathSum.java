import java.util.Arrays;

class MaxPathSum {
	private static int maxCount = 0;
  public static int maxPathSum(BinaryTree node) {
		maxCount = Integer.MIN_VALUE;
    maxPathSums(node);
		return maxCount;
  }
	
  /**
  This solution is singl threaded.
  */
	private static int maxPathSums(BinaryTree node) {
		if(node == null) return 0;
		
		var leftSum = maxPathSums(node.left);
		var rightSum = maxPathSums(node.right);
		
		var leftAndNodeSum = node.value + leftSum;
		var rightAndNodeSum = node.value + rightSum;
		var threeSum = node.value + leftSum + rightSum;
		
		int[] sums = new int[] { leftSum,  rightSum, leftAndNodeSum, rightAndNodeSum, threeSum};
		
		maxCount = Math.max(maxCount, getMax(sums));
		
		return Math.max(leftAndNodeSum, rightAndNodeSum);
	}
	
	private static int getMax(int[] sums) {
		Arrays.sort(sums);
		
		return sums[sums.length - 1];
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
