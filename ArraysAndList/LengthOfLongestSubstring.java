/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1 || s == "") {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        
        int result = 1;
        Set<Character> nonRepeatingSet = new HashSet<>();
        nonRepeatingSet.add(s.charAt(0));
        
        int lagPointer = 0;
        
        for(int currPointer = 1; currPointer < s.length(); currPointer++) {
            if(!nonRepeatingSet.contains(s.charAt(currPointer))) {
                nonRepeatingSet.add(s.charAt(currPointer));
                result = Math.max(result, nonRepeatingSet.size());
            }  else {
                while(lagPointer < currPointer) {
                   if(s.charAt(lagPointer) == s.charAt(currPointer)) {
                       lagPointer++;
                       break;
                   }
                   nonRepeatingSet.remove(s.charAt(lagPointer));
                   lagPointer++;
                }
            }
        }
        
        return result;
    }
}
