/*
https://leetcode.com/problems/search-suggestions-system/description/
*/

class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        LinkedList<String> suggestion = new LinkedList<>();
        
        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.child[index] == null) {
                    curr.child[index] = new TrieNode();
                }
                curr = curr.child[index];
                if (curr.suggestion.size() < 3) {
                    curr.suggestion.offer(word);
                }
            }
        }
        
    }
    
    TrieNode root = null;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        Arrays.sort(products);
        for (String product : products) {
            root.insert(product);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (root != null)
                root = root.child[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion);
        }
        
        return ans;
    }
}