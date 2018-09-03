package algorthims.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MinSubStringMaxCharactersTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MinSubStringMaxCharactersTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MinSubStringMaxCharactersTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertEquals(5, findMinSubstringUniqueCharacters("abccda"));
        System.out.println(findMinSubstringUniqueCharacters("abccda"));

        assertEquals(4, findMinSubstringUniqueCharacters("abcccccccccccccccccccccdba"));
        System.out.println(findMinSubstringUniqueCharacters("abcccccccccccccccccccccdba"));

        assertEquals(5, findMinSubstringUniqueCharacters("AABBBCBB"));
        System.out.println(findMinSubstringUniqueCharacters("AABBBCBB"));

        assertEquals(3, findMinSubstringUniqueCharacters("AABBBCBBAC"));
        System.out.println(findMinSubstringUniqueCharacters("AABBBCBBAC"));

        assertEquals(6, findMinSubstringUniqueCharacters("ABcDEf"));
        System.out.println(findMinSubstringUniqueCharacters("ABcDEf"));

        assertEquals(1, findMinSubstringUniqueCharacters("AAAAAAA"));
        System.out.println(findMinSubstringUniqueCharacters("AAAAAAA"));

        assertEquals(2, findMinSubstringUniqueCharacters("BAAAAAAA"));
        System.out.println(findMinSubstringUniqueCharacters("BAAAAAAA"));

        assertEquals(2, findMinSubstringUniqueCharacters("AAAAAAAB"));
        System.out.println(findMinSubstringUniqueCharacters("AAAAAAAB"));
    }

    private int findMinSubstringUniqueCharacters(String input) {
        int minSubStringCount = input.length(); // At max the length of the unique characters substring would the length of the substring itself

        Set<Character> uniqueSet = new HashSet<>();
        int uniqueCharacters = 0;

        for (Character ch : input.toCharArray()) {
            uniqueSet.add(ch);
        }

        // get the count of the distinct characters
        uniqueCharacters = uniqueSet.size();

        uniqueSet = null;

        Map<Character, Integer> characterCountMap = new HashMap<>();
        Queue<Character> characterSequenceQueue = new LinkedList<>();

        // sliding approach to traverse the string
        for (Character ch : input.toCharArray()) {
            characterSequenceQueue.add(ch);
            if (characterCountMap.containsKey(ch)) {
                characterCountMap.put(ch, characterCountMap.get(ch) + 1);
            } else {
                characterCountMap.put(ch, 1);
            }

            if (characterCountMap.size() == uniqueCharacters) {
                minSubStringCount = Math.min(minSubStringCount, characterSequenceQueue.size());

                while (!characterSequenceQueue.isEmpty()) { // logic to removing the unwanted characters from the substring beginning
                    Character currentCharacter = characterSequenceQueue.peek();
                    int characterCount = characterCountMap.get(currentCharacter);

                    if (characterCount == 1) { // if it's only one character at the beginning then break out and traverse
                        break;
                    } else if (characterCount > 1) { // else flush character out the queue and decrement the character count
                        characterSequenceQueue.poll();
                        characterCountMap.put(currentCharacter, characterCountMap.get(currentCharacter) - 1);

                        minSubStringCount = Math.min(minSubStringCount, characterSequenceQueue.size());
                    }
                }
            }
        }

        return minSubStringCount;
    }
}
