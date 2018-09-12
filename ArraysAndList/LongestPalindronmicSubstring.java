// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
// Example 1:
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
// Example 2:
// Input: "cbbd"
// Output: "bb"

// Naive approach is to find all the possible substrings and reverse check if they are palindromes 
// Worst Case running time in the naive approach is O(n^3)
//
// We can do better by storing away the sub results if they are palindrome or not and reduce the computation by nth order
// Using this dynamic programming approach the running time could be reduced to O(n^2)
//
// Solution
// Sample DP Matrix 
//   c b b d
// c 1 0 0 0
// b   1 1 0
// b     1 0  
// d       1
// First populate the center diagonal with 1 (or true), as evey character is a palindrome
// Next start from [0,1] then [1,2] then [2,3] to [n-1, n] where n is the number of elements, this is for 2 characters
// Next start from [0,2] then [1,3] then [2,4] to [n-2, n] this is for 3 characters, 
// here the only computation required is to verify if [row + 1, column - 1] is true (which could be determined from last run)
// and then check if Input[row] == Input[column] if they are same, verify if the length of (row + 1) > currentMaxPalindromicLength
// if so this is your new palindromic substring, i.e. Input.substring(column, row + column + 1), make sure to update the DP matrix 
// element (at row, column) to true 

public class LongestPalindronmicSubstring {
    public String longestPalindrome(String s) {
        if(s == null) {
            return null;
        }
        
        int inputLength = s.length();
        
        if(inputLength <=0 ) {
            return "";
        }
        
        char inputArray[] = s.toCharArray();
        int maxPalindromicLength = 1;
        String result = s.substring(0,1);
        
        boolean dynamicMatrix[][] = new boolean[inputLength][inputLength];
        
        for(int i = 0; i < inputLength; i++) {
            for(int j = 0; j < inputLength - i; j++) {
                if(i == 0) {
                    dynamicMatrix[j][i+j] = true;
                } else if((i == 1 && inputArray[j] == inputArray[i+j]) || 
                         (i >= 2 && inputArray[j] == inputArray[i+j] && dynamicMatrix[j+1][i+j-1])) {
                    dynamicMatrix[j][i+j] = true;
                    if(maxPalindromicLength < i + 1) {
                        maxPalindromicLength = i + 1;
                        result = s.substring(j, i + j + 1);
                    }
                }
            }
        }
        
        return result;
    }
}
