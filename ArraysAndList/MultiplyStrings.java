/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
class MultiplyStrings.java {
    public String multiply(String num1, String num2) {
        // the resulting size of the digits will be atmost n + m where 
        // n and m are the respective digts in the multiplier and multiplicand
        int[] resultingCollection = new int[num1.length() + num2.length()]; 
        
        for(int i = num2.length() - 1; i >= 0; i--) {
            for(int j = num1.length() - 1; j >= 0; j--) {
                int multiply = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int result = resultingCollection[i + j + 1] + multiply;
                resultingCollection[i + j + 1] = result % 10; // current digit
                resultingCollection[i + j] += result / 10; // carry
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isParsingLeadingZero = true;
        for(int i = 0; i < resultingCollection.length; i++) {
            if(isParsingLeadingZero && resultingCollection[i] == 0) {
                continue;
            } 
            isParsingLeadingZero = false;
            sb.append(resultingCollection[i]);
        }
        
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
