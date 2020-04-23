class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        
        if(nums.length < 2) {
            return nums.length;
        }
        
        int returnValue = 1;
        int lagPointer = 0;
        for(int leadPointer = lagPointer  + 1; leadPointer < nums.length; leadPointer ++) {
            if(nums[lagPointer] == nums[leadPointer]) {
                continue;
            }
            
            returnValue ++;
            
            if(lagPointer < nums.length && ++lagPointer != leadPointer) {
                nums[lagPointer] = nums[leadPointer]; 
            }
        }
        
        return returnValue;
    }
}
