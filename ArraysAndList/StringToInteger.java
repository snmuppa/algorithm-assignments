/**
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

*/
class StringToInteger {
    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        
        str = str.trim();
        
        if(str.length() == 0 || (str.charAt(0) != '-' && str.charAt(0) != '+' && (getNumAtlocation(0, str) < 0 || getNumAtlocation(0, str) > 9))) {
            return 0;
        }
              
        Long returnValue = 0L;   
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
         
        boolean startCount = false;
        int digitCounter = 0;
        
        for(int i = 0; i < str.length(); i++) {
            int number = getNumAtlocation(i, str);
            if (number >= 0 && number <= 9) {
                if(startCount || number > 0) {
                    startCount = true;
                    digitCounter ++;
                }
                stack.push(number);
            } else if(i == 0) {
                if(str.charAt(i) == '-') {
                    sign = -1;
                } else if (str.charAt(i) == '+') {
                    sign = 1;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        if(digitCounter > 10 && sign == -1) {
            return Integer.MIN_VALUE;
        } else if (digitCounter > 10 && sign == 1) {
            return Integer.MAX_VALUE;
        }
           
           Long tens = 1L;
           while(!stack.isEmpty()) {
               returnValue += stack.pop() * tens;
               
               if(sign * returnValue < Integer.MIN_VALUE) {
                   return Integer.MIN_VALUE;
               } else if (sign * returnValue > Integer.MAX_VALUE) {
                   return Integer.MAX_VALUE;
               }
               
               tens *= 10;
           }
        
           return (int)(returnValue * sign);
    }
           
    private int getNumAtlocation(int location, String str) {
        return str.charAt(location) - '0';
    }
}
