/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
class MoveZeroes {
  public void moveZeroes(int[] nums) {
      for (int nonZeroPointer = 0, currentPointer = 0; 
           currentPointer < nums.length; currentPointer++) {
          if (nums[currentPointer] != 0) {
              if(nonZeroPointer != currentPointer) {
                  swap(nonZeroPointer, currentPointer, nums);
              }
              nonZeroPointer++;
          }
      }
  }

  private void swap(int nonZeroPointer, int currentPointer, int[] nums) {
      int temp = nums[nonZeroPointer];
      nums[nonZeroPointer] = nums[currentPointer];
      nums[currentPointer] = temp;
  }
}
