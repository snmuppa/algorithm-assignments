/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class MergeIntervals {
    class ArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return (a[0] - b[0]);
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new ArrayComparator());
        LinkedList<int[]> resultCollection = new LinkedList<>();
        
        for(int index = 0; index < intervals.length; index++) {
            if(resultCollection.isEmpty() || resultCollection.getLast()[1] < intervals[index][0]) {
                resultCollection.add(intervals[index]);
            } else {
                resultCollection.getLast()[1] = Math.max(resultCollection.getLast()[1], intervals[index][1]);
            }
        }
        
        return resultCollection.toArray(new int[resultCollection.size()][]);
    }
}
