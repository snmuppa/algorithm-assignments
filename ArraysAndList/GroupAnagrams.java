/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mapResults = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            
            if(!mapResults.containsKey(sortedString)) {
                mapResults.put(sortedString, new ArrayList<String>());
            }
            mapResults.get(sortedString).add(strs[i]);
        }
        
        for(List<String> value : mapResults.values()) {
            result.add(value);
        }
        
        return result;
    }
}
