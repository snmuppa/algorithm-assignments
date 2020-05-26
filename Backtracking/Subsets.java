/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        for(int i = 0; i <= nums.length; i++) {
            subsets(nums, 0, i, new ArrayList<Integer>(), result);
        }
        
        return result;
    }
    
    private void subsets(int[] nums, 
                                 int start, 
                                 int setNum,
                                 List<Integer> curr, 
                                 List<List<Integer>> result) {
        if(setNum == curr.size()) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(nums, i + 1, setNum, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
