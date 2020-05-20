class HeapSort {
    public int[] sortArray(int[] nums) {
        for(int startIndex = 0; startIndex < nums.length - 1; startIndex++) {
            heapify(nums, startIndex);
        }
        
        return nums;
    }
    
    private void heapify(int[] nums, int startIndex) {
        for(int heapIndex = (((nums.length - 1) / 2) + startIndex); heapIndex >= startIndex; heapIndex--) {
            heapify(nums, startIndex, heapIndex);
        }
    }
    
    private void heapify(int[] nums, int startIndex, int heapIndex) {
        if(heapIndex >= nums.length)
            return;
        
        var leftIndex = ((2 * heapIndex) + 1) - startIndex;
        var rightIndex = ((2 * heapIndex) + 2) - startIndex;
        
        var swapIndex = heapIndex;
        
        var valHeapIndex = nums[heapIndex];
        
        if(leftIndex < nums.length) {
            var valLeftIndex = nums[leftIndex];
            
            if(valLeftIndex < valHeapIndex) {
                swapIndex = leftIndex;
            }
            
            if(rightIndex < nums.length) {
                var valRightIndex = nums[rightIndex];
                
                if(valRightIndex < nums[swapIndex]) {
                    swapIndex = rightIndex;
                }
            }
        }
        
        if(swapIndex == heapIndex)
            return;
        
        swap(nums, heapIndex, swapIndex);
        
        heapify(nums, startIndex, swapIndex);
    }
    
    private void swap(int[] nums, int heapIndex, int swapIndex) {
        var temp = nums[heapIndex];
        nums[heapIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
    }
}
