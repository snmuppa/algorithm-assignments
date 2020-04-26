/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        String result = "";
        
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            return result;
        else if(s.equals(t)) {
            result = t;
        } else{
            int windowCharCount = t.length();
            Map<Character, Integer> windowMap = getWindowMap(t);
            Map<Character, Integer> trackingWindowMap = new HashMap<>();
            int trackingCounter = 0;

            int lagPointer = 0;

            for(int currPointer = 0; currPointer < s.length(); currPointer++) {
                if(windowMap.containsKey(s.charAt(currPointer))) {
                    if(trackingWindowMap.get(s.charAt(currPointer)) == null 
                       || windowMap.get(s.charAt(currPointer)) >
                        trackingWindowMap.get(s.charAt(currPointer))) {
                        trackingCounter ++;
                    }

                    Integer charCount = trackingWindowMap.containsKey(s.charAt(currPointer)) 
                        ? trackingWindowMap.get(s.charAt(currPointer)) : 0;
                    trackingWindowMap.put(s.charAt(currPointer), ++charCount);
                }

                // logic to shorten the window as far as possible that contains 
                // all the characters in the comparing window
                while(trackingCounter == windowCharCount) {
                    var charLagPointer = s.charAt(lagPointer);
                    if(windowMap.containsKey(charLagPointer)) {
                        var substringMatch = s.substring(lagPointer, currPointer + 1);

                        if(result.equals("") || result.length() > substringMatch.length()) {
                            result = substringMatch;
                        }

                        Integer charCount = trackingWindowMap.get(charLagPointer);
                        
                        if(windowMap.get(charLagPointer) == charCount) {
                            trackingCounter--;   
                        }
                        
                        if(charCount == 1) {
                            trackingWindowMap.remove(charLagPointer);
                        } else {
                            trackingWindowMap.put(charLagPointer, --charCount);
                        }        
                    }
                    lagPointer++;
                }
            }
        }
        
        return result;
    }
    
    
    private Map<Character, Integer> getWindowMap(String t) {
        Map<Character, Integer> windowMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            Integer charCount = windowMap.containsKey(c) ? windowMap.get(c) : 0;
            windowMap.put(c, charCount + 1);
        }
        
        return windowMap;
    }
}
