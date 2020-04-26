/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        boolean result = true;
        
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        
        while(leftPointer < rightPointer) {
            if(!isValidAlphaNumeric(s, leftPointer)) {
                leftPointer++;
            } else if(!isValidAlphaNumeric(s, rightPointer)) {
                rightPointer--;
            } else if (Character.toLowerCase(s.charAt(leftPointer)) 
                       == Character.toLowerCase(s.charAt(rightPointer))) {
                leftPointer++;
                rightPointer--;
            } else {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    private boolean isValidAlphaNumeric(String s, int pointer) {
        char character = s.charAt(pointer);
        int numericSequence = character - '0';
        int lowerCaseCharSequence = character - 'a';
        int upperCaseCharSequence = character - 'A';
        
        boolean isValidNumeric = false;
        if((numericSequence >= 0 && numericSequence <= 9)
          || (lowerCaseCharSequence >= 0 && lowerCaseCharSequence <= 25)
          || (upperCaseCharSequence >= 0 && upperCaseCharSequence <= 25)) {
            isValidNumeric = true;
        }
        
        return isValidNumeric;
    } 
}
