package algorthims.practice;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PrettyJsonTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PrettyJsonTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PrettyJsonTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        String s = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\",I:\"J\"}}}";

        //s = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        /*
          {
                A:"B",
                C:
                {
                    D:"E",
                    F:
                    {
                        G:"H",
                        I:"J",
                        I:"J"
                    }
                }
            }
         */

        /*
           [
                "foo",
                {
                    "bar":
                    [
                        "baz",
                        null,
                        1.0,
                        2
                    ]
                }
            ]

         */
        System.out.println(prettyJson(s));
    }

    private ArrayList<String> prettyJson(String inputString) {
        ArrayList<String> results = new ArrayList<String>();

        int tabSize = 0;
        String currentString = "";
        for (int index = 0; index < inputString.length();) {
            char charAtIndex = inputString.charAt(index);
            currentString += charAtIndex;
            switch (charAtIndex) {
            case ',':
                results.add(currentString);
                currentString = getTabSpace(tabSize);
                index++;
                break;

            case ':':
                index++;
                if (index < inputString.length() && (inputString.charAt(index) == '{' || inputString.charAt(index) == '[')) {
                    results.add(currentString);;
                    currentString = getTabSpace(tabSize);
                }
                break;

            case '{':
            case '[':
                index++;
                results.add(currentString);
                if (index < inputString.length() && (inputString.charAt(index) != '}' || inputString.charAt(index) != ']')) {
                    tabSize++;
                }
                currentString = getTabSpace(tabSize);
                break;

            case '}':
            case ']':
                index++;
                if (index < inputString.length() && inputString.charAt(index) == ',') {
                    break;
                }
                results.add(currentString);
                if (index < inputString.length() && (inputString.charAt(index) == '}' || inputString.charAt(index) == ']')) {
                    tabSize--;
                }
                currentString = getTabSpace(tabSize);
                break;

            default:
                index++;
                if (index < inputString.length() && (inputString.charAt(index) == '}' || inputString.charAt(index) == ']')) {
                    results.add(currentString);
                    tabSize--;
                    currentString = getTabSpace(tabSize);
                }
                break;
            }
        }

        return results;
    }

    private String getTabSpace(int tabSize) {
        StringBuilder tabs = new StringBuilder();
        while (tabSize > 0) {
            tabs.append("\t");
            tabSize--;
        }
        return tabs.toString();
    }
}
