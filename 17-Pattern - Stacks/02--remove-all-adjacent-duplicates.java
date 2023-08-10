/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty()) {
                if (ch == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
