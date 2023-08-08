/*
Given a string, str, rearrange it so that any two adjacent characters are not the same. 
If such a reorganization of the characters is possible, output any possible valid arrangement. 
Otherwise, return an empty string.
*/

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freqMap = new int[26];
        for (int i = 0; i < n; i++) {
            freqMap[s.charAt(i) - 'a']++;
        }
        int maxFreq = 0, letter = 0;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > maxFreq) {
                maxFreq = freqMap[i];
                letter = i;
            }
        }
        if (maxFreq > ((n + 1) / 2)) return "";

        char[] result = new char[s.length()];
        int index = 0;
        while (freqMap[letter] > 0) {
            result[index] = (char)(letter + 'a');
            index += 2;
            freqMap[letter]--;
        }
        for (int i = 0; i < freqMap.length; i++) {
            while (freqMap[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                freqMap[i]--;
            }
        }
        return String.valueOf(result);
    }
}

// TC: O(n), SC: O(N)