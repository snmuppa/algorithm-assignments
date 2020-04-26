/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        updateNums1ToEndOfArray(nums1, m);
        
        if(n == 0) {
            return;
        } else if (m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else {  
            int nums1Pointer = nums1.length - m;
            int nums2Pointer = 0;
            int tranversePointer = 0;
            while(nums1.length > nums1Pointer || n > nums2Pointer) {
                if(nums1Pointer == nums1.length 
                   || (nums2Pointer != n && nums1[nums1Pointer] > nums2[nums2Pointer])) {
                    nums1[tranversePointer++] = nums2[nums2Pointer++];
                } else if (nums2Pointer == n || nums1[nums1Pointer] <= nums2[nums2Pointer]) {
                    nums1[tranversePointer++] = nums1[nums1Pointer++];
                } 
            }
        }
    }
    
    private void updateNums1ToEndOfArray(int[] nums1, int m) {
        for(int i = m - 1, j = nums1.length -1; i >= 0; i--, j--) {
            nums1[j] = nums1[i];
        }
    }
}
