/**
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/
class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        
        Map<Integer, Boolean> intersectionMarkedMap = new HashMap<>();
        
        for(int num : nums1) {
            intersectionMarkedMap.put(num, false);
        }
        
        List<Integer> resultCollection = new ArrayList<>();
        
        for(int num : nums2) {
            if(intersectionMarkedMap.containsKey(num) && !intersectionMarkedMap.get(num)) {
                resultCollection.add(num);
                intersectionMarkedMap.put(num, true);
            }
        }
        
        int[] result = new int[resultCollection.size()];
        
        for(int index = 0; index < resultCollection.size(); index++) {
            result[index] = resultCollection.get(index);
        }
        
        return result;
    }
}
