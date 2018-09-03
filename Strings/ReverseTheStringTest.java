package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReverseTheStringTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseTheStringTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ReverseTheStringTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        String s = "the  sky is blue";
        System.out.println(reverseWords(s));
    }

    private String reverseWords(String inputString) {
        inputString = curateTheInput(inputString);
        String words[] = inputString.split(" ");

        StringBuilder s = new StringBuilder();
        for(int index = words.length - 1; index>=0; index--) {
            s.append(words[index]);
            if(index!=0) {
                s.append(" ");
            }
        }

        return s.toString();
    }

    private String curateTheInput(String inputString) {
        inputString = inputString.trim();
        StringBuilder curatedList = new StringBuilder();
        char previousChar = inputString.charAt(0);
        curatedList.append(previousChar);
        for(int index=1; index < inputString.length(); index++) {
            if(!(inputString.charAt(index) == ' ' && inputString.charAt(index) == previousChar)) {
                curatedList.append(inputString.charAt(index));
            }
            previousChar = inputString.charAt(index);
        }

        return curatedList.toString();
    }
}
