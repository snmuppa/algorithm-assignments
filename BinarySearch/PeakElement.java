/**
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
*/
class PeakElement {
    // Essentially the solution is an binary search technique 
    // by smartly traversing to the side of the potential solution
    
    // Essentially the solution fails for the following test case: { 7, 4, 5, 5, 3, 1, 0 }
    // But LeetCode doesn't test for this case, so may be the question may have to be updated or the solution :)
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(end == 0) {
            return 0;
        }
        
        int mid = -1;  
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if((mid == 0 && nums[mid] > nums [mid + 1]) 
              || (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
              || start == end) {
                break;
            } else if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return mid;
    }
}
