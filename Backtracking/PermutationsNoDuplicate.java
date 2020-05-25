/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class PermutationsNoDuplicate.java {    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<String> existingSet = new HashSet<>();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> input = new LinkedList<>();
        for(int num : nums) {
            input.add(num);
        }
        
        permuteUnique(input, 0, nums.length, result, existingSet);
        
        return result;
    }
    
    private void permuteUnique(List<Integer> input, 
                               int startIndex, 
                               int inputLength, 
                               List<List<Integer>> result,
                               Set<String> existingSet){
        if(startIndex == inputLength) {
            var inputString = input.toString();
            if(!existingSet.contains(inputString)) {
                existingSet.add(inputString);
                result.add(new LinkedList<Integer>(input));
            }
            
            return;
        }
        
        for(int i = startIndex; i < inputLength; i++) {
            Collections.swap(input, startIndex, i);
            
            permuteUnique(input, startIndex + 1, inputLength, result, existingSet);
            
            Collections.swap(input, startIndex, i);
        }
    }
}
