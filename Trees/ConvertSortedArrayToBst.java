class ConvertSortedArrayToBst {
    public TreeNode sortedArrayToBST(int[] nums) {
        var rootNode = sortedArrayToBST(nums, 0, nums.length - 1);
        
        return rootNode;
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int leftIndex, int rightIndex) {
        if(leftIndex > rightIndex) {
            return null;
        }
        
        var currIndex = (leftIndex + rightIndex) / 2;
        var currNode =  new TreeNode(nums[currIndex]); 
        currNode.left = sortedArrayToBST(nums, leftIndex, currIndex - 1);
        currNode.right = sortedArrayToBST(nums, currIndex + 1, rightIndex);
        
        return currNode;
    }
}
