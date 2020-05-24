/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    Map<Character, String> digitCharMap = new HashMap<>() {{
       put('2', "abc");
       put('3', "def");
       put('4', "ghi");
       put('5', "jkl");
       put('6', "mno");
       put('7', "pqrs");
       put('8', "tuv");
       put('9', "wxyz");
    }};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits!= null && digits.length() > 0){
            letterCombinations("", digits, result);
        }
        return result;
    }
    
    private void letterCombinations(String combination, String nextDigits, List<String> result) {
        if(nextDigits.length() == 0) {
            result.add(combination);
            return;
        }
        
        var nextDigit = nextDigits.charAt(0);
        var chars = digitCharMap.get(nextDigit);
        
        for(int i=0; i < chars.length(); i++) {
            var nextChar = chars.charAt(i);
            letterCombinations(combination + nextChar, nextDigits.substring(1), result);
        }
    }
}
