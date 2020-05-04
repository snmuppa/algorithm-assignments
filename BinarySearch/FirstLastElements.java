/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class FirstLastElements {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        searchRange(nums, target, 0, nums.length - 1, result);
        return result;
    }
    
    private void searchRange(int[] nums, int target, int start, int end, int[] result) {
        int mid = 0;
        
        while(start <= end) {
            mid = getMidPointer(start, end);
            
            if(target == nums[mid]) {
                if(result[0] == -1 || mid < result[0] ) {
                    result[0] = mid;
                }
                
                if(mid > result[1]) {
                    result[1] = mid;
                } 
                
                int midMinus = mid - 1;
                int midPlus = mid + 1;
                
                if(midMinus >= 0 
                   && result[0] > midMinus 
                   && nums[midMinus] == target) {
                    searchRange(nums, target, start, midMinus, result);
                }
                
                if(midPlus <= nums.length - 1 
                   && result[1] < midPlus 
                   && nums[midPlus] == target) {
                    searchRange(nums, target, midPlus, end, result);
                }
                
                // if we have come here means for this traversal, we have found the 
                // min and max indexes
                break;   
            } else if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
    
    private int getMidPointer(int start, int end) {
        return start + (end - start) / 2;
    }
}
