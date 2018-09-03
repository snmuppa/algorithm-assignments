package algorthims.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MaxOccuringSubstringTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MaxOccuringSubstringTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MaxOccuringSubstringTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        String inputString = "asbsajksasajsklajjsaldalsdasl";
        int minLength = 2;
        int maxLength = 5;
        int maxUniqueCharacters = 3;

        int maxOccuringCount = getMaxOccuringSubStringCount(inputString, minLength, maxLength, maxUniqueCharacters);
        Assert.assertEquals(4, maxOccuringCount);
    }

    /**
     * <p>
     * Returns the length of the max occurring substring which has length between {@code minLength} and {@code maxLength}
     * with a maximum of unique characters of size {@code maxUniqueCharacters}
     * </p>
     *
     * <h3>Other constraints:</h3>
     *
     * <p>
     * 2 <= inputString <= 100000 <br/>
     * 2 <= minLength <= maxLength <= 26, maxLength < inputString <br/>
     * 2 <= maxUniqueCharacters <= 26 <br/>
     * </p>
     *
     * @param inputString input string
     * @param minLength minimum length of the substring
     * @param maxLength maximum length of the substring
     * @param maxUniqueCharacters maximum number of unique characters that a substring counted towards could have
     *
     * @return the number of times the maximum occurring substring with the occurs
     */
    public int getMaxOccuringSubStringCount(String inputString, int minLength, int maxLength, int maxUniqueCharacters) {
        Set<Character> uniqueCharacterSet = new HashSet<Character>();
        Map<String, Integer> subStringsMap = new HashMap<String, Integer>();
        int result = 1; // a subtring occurs atleast once

        for (int beginIndex = 0; beginIndex < inputString.length() - minLength; beginIndex++) {
            for (int endIndex = (beginIndex + minLength); endIndex < (inputString.length() + 1); endIndex++) {

                String subString = inputString.substring(beginIndex, endIndex);
                if (endIndex == (beginIndex + minLength)) {
                    //clear the unique character set
                    uniqueCharacterSet.clear();

                    //initialize the character set
                    initializeCharacterSet(subString, uniqueCharacterSet);
                } else { // add the last character to the set on each iteration forward
                    uniqueCharacterSet.add(subString.charAt(subString.length() - 1));
                }

                if (uniqueCharacterSet.size() > maxUniqueCharacters) {
                    break;
                }

                if (subStringsMap.containsKey(subString)) {
                    int occurrenceCount = subStringsMap.get(subString) + 1;
                    result = Math.max(result, occurrenceCount); // keep track of the max occurrence count
                    subStringsMap.put(subString, occurrenceCount);
                } else {
                    subStringsMap.put(subString, 1);
                }
            }
        }

        return result;
    }

    private void initializeCharacterSet(String subString, Set<Character> uniqueCharacterSet) {
        for (char character : subString.toCharArray()) {
            uniqueCharacterSet.add(character);
        }
    }
}
