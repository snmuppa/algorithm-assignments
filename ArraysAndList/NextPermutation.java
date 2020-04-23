/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length ==1)
            return;
        
        if(nums.length == 2) {
            swap(0, 1, nums);
            return;
        }
        
        int i = nums.length - 2;
        // parse from the end until you find a dip 
        while(i >= 0 && nums[i] >= nums[i+1]) { 
            i--;
        }
        
        // if i is < 0 i.e -1, that means array is fully in descending order, so just revervse the whole array, skip the processing this condition.
        
        if(i >= 0) { 
            int j = i + 1;
            
            // parse from the next element of the first dip to the element which is closely higher than the dip element
            while(j < nums.length  && nums[i] < nums[j]) {
                j++;
            }
            
            swap(i, j - 1, nums);
        }
        
        // reverse from element right after the first dip or the full array in case of a fully descending array
        reverse(i+1, nums);
    }
    
    private void reverse(int startPointer, int[] nums) {
        int j = nums.length - 1;
        int i = startPointer;
        while(j > i) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    
    private void swap(int headPointer, int tailPointer, int[] nums) {
        int temp = nums[headPointer];
        nums[headPointer] = nums[tailPointer];
        nums[tailPointer] = temp;
    }
}
