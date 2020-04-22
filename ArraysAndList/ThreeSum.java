/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnCollection = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return returnCollection;
        }
        
        //sort the array for optimization, run time here is nlog(n) in the worst case
        Arrays.sort(nums);
        
        System.out.println(Arrays.toString(nums));
        
        int secondPointer = 0;
        int thirdPointer = 0;
        
        for(int firstPointer = 0; firstPointer < nums.length - 2; firstPointer ++) {
            secondPointer = firstPointer + 1;
            thirdPointer = nums.length - 1;
            
            if(firstPointer > 0 && nums[firstPointer] == nums[firstPointer - 1]) {
                continue;
            }
            
            while(thirdPointer > secondPointer) {
                if(thirdPointer < nums.length - 1 && nums[thirdPointer] == nums[thirdPointer + 1]) {
                    thirdPointer --;
                    continue;
                }
                
                int sum3 = calculate3Sum(firstPointer, secondPointer, thirdPointer, nums);
                
                if(sum3 > 0) {
                    thirdPointer --;
                } else if (sum3 < 0) {
                    secondPointer ++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[firstPointer]);
                    list.add(nums[secondPointer]);
                    list.add(nums[thirdPointer]);
                    
                    returnCollection.add(list);
                    
                    thirdPointer --;
                    secondPointer ++;
                }
            } 
        }
        
        return returnCollection;
    }
    
    private int calculate3Sum(int firstPointer, int secondPointer, int thirdPointer, int[] nums) {
        return nums[firstPointer] + nums[secondPointer] + nums[thirdPointer];
    }
}
