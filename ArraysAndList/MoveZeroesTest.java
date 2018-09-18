public class MoveZeroesTest {
    // Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    // Example:
    // Input: [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    // Note:
    // You must do this in-place without making a copy of the array.
    // Minimize the total number of operations.
    public void moveZeroes(int[] nums) {
        if(nums!=null && nums.length != 0) {
            int nextNonZeroPointer = 0;
            for(int currentPointer = 0; currentPointer < nums.length && nextNonZeroPointer < nums.length; currentPointer++) {
                if(nums[currentPointer] == 0 && currentPointer != nums.length) {
                    while(nums[nextNonZeroPointer] == 0 && nextNonZeroPointer < nums.length - 1) {
                        nextNonZeroPointer++;
                    }
                    nums[currentPointer] = nums[nextNonZeroPointer];
                    nums[nextNonZeroPointer] = 0;
                } else {
                    nextNonZeroPointer++;
                }
            }
        }
    }
}
