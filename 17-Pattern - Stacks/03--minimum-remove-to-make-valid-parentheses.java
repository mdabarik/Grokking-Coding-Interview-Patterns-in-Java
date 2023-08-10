

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')' && stack.isEmpty()) {
                stack.push(i);
            } else if (ch == ')') {
                if (s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        String ans = "";
        Set<Integer> set = new HashSet();
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(i)) {
                ans += ch;
            }
        }
        return ans;
    }
}

