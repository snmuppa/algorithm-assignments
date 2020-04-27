/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
class LengthOfLongestSubstringKDistinct {
    // Start with a trackingMap to hold the characters and their respective count 
    // based on the size of the map we will know the length of the distinct characters
    // as we traverse keep up the map by removing the char record when the count is 0
    // keep running string 
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        String resultString = "";
        Map<Character, Integer> trackingMap = new HashMap<>();
        
        int leftPointer = 0;
        for(int currPointer = 0; currPointer< s.length(); currPointer++) {
            char currChar = s.charAt(currPointer);
            int charCount = trackingMap.containsKey(currChar)
                ? trackingMap.get(currChar) : 0;
            trackingMap.put(currChar, charCount + 1);
            
            if(trackingMap.size() == k) {
                String subString = s.substring(leftPointer, currPointer + 1);
                if(subString.length() > resultString.length()) {
                    resultString = subString;
                }
            } 
            
            // reduce the left window
            while(trackingMap.size() > k) {
                char leftChar = s.charAt(leftPointer);
                int leftCharCount = trackingMap.get(leftChar);
                if(leftCharCount == 1) {
                    trackingMap.remove(leftChar);
                } else {
                    trackingMap.put(leftChar, leftCharCount - 1);
                }

                leftPointer++;
            }
        }
        
        return resultString.length() < k ? s.length() : resultString.length() ;
    }
}
