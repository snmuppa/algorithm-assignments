public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int lenLongestSubStr = 0;
        Set<Character> charSet = new HashSet<Character>();
        int lagPointer = 0;
        for(int currPointer = 0; currPointer < s.length(); currPointer ++) {
            char charAtCurrPointer = s.charAt(currPointer);
            if(charSet.contains(charAtCurrPointer)) {
                while(lagPointer < currPointer) {
                    char charAtLagPointer = s.charAt(lagPointer);
                    lagPointer ++;
                    charSet.remove(charAtLagPointer);
                    System.out.println(charSet);
                    if(charAtCurrPointer == charAtLagPointer) {
                        break;
                    } 
                }
            }
            charSet.add(charAtCurrPointer);
            lenLongestSubStr = Math.max(charSet.size(), lenLongestSubStr);
        }
        
        return lenLongestSubStr;
    }
}
