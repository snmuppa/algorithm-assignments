public class LongestWordInDictionary {
    public String findLongestWord(String s, List<String> d) {
        if(s==null || s.length() == 0 || d == null || d.size() == 0) {
            return "";
        }
        
        int index = 0;
        for(String dictionaryString : d) {
            if(dictionaryString == null || dictionaryString.length() == 0 || dictionaryString.length() > s.length()) {
                d.remove(index);
            }
            index++;
        }
        
        String result = ""; 
        
        for(String dictionaryString : d) {
            boolean isMatch = isMatch(s, dictionaryString);
            if(isMatch) { // if we get a matching word in dictionary by deleting letters in the inputString
                if(dictionaryString.length() > result.length() || (dictionaryString.length() == result.length() && result.compareTo(dictionaryString) > 0)) { 
                    // if the current dictionaryString is greater in length than result string
                    // or they are of same length, pick which comes first in the lexical order by comparing
                    result = dictionaryString;
                }
            }
        }
        
        return result;  
    }
    
    // Find if deleting the elements would create a string that matches the dictionary word
    private boolean isMatch(String inputString, String dictionaryString) {
        boolean isMatch = false;
        String resultingString = "";
        
        char inputArray[] = inputString.toCharArray();
    
        // start at the zeroth index of both the inputString and the dictionaryString;
        // traverse over each character in the dictionary string by traversing the inputString letter by letter 
        // if there is a match advance both inputString and dictionaryString 
        // if it is not a match, traverse the inputString until there is a match
        // this is equivalent to deleting the character 
        // each time there is match, add character to a resultingString
        // once we exhaust parsing the dictionaryString or the inputString, we verify if the resultingString is equivalent to
        // dictionaryString, if they are same we return true, else false which is no match.
        
        int z = 0;
        int j = 0;
        for(int i=0; i < dictionaryString.length(); i++) {
            j = i + z;
            
            while(j < inputString.length())
            {
                if(dictionaryString.charAt(i) == inputString.charAt(j)){
                    resultingString += dictionaryString.charAt(i);
                    break;
                } else {
                    z++;
                    j++;
                } 
            }
        }
        
        if(resultingString.equals(dictionaryString)) {
            isMatch = true;
        }
        
        return isMatch;
    }
}
