/**
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/
class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
            return addBinary(b, a);
        }
        
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        for(int i = a.length() - 1; i >= 0; i--) {
            if(j >= 0) {
                carry += (b.charAt(j) - '0');
            }
            j --;
            
            carry += (a.charAt(i) - '0');
            
            sb.append((char)((carry % 2) + '0'));
            carry = carry / 2;
        }
        
        if(carry > 0) {
            sb.append((char)((carry) + '0'));
        }
        
        return sb.reverse().toString();
    }
}
