/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> input = new LinkedList<>();
        for(int num : nums) {
            input.add(num);
        }
        
        permute(input, 0, nums.length, result);
        
        return result;
    }
    
    private void permute(List<Integer> input, 
                               int startIndex, 
                               int inputLength, 
                               List<List<Integer>> result){
        if(startIndex == inputLength) {
            result.add(new LinkedList<Integer>(input));
            return;
        }
        
        for(int i = startIndex; i < inputLength; i++) {
            Collections.swap(input, startIndex, i);
            
            permute(input, startIndex + 1, inputLength, result);
            
            Collections.swap(input, startIndex, i);
        }
    }
}
