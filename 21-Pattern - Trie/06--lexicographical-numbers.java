/*
https://leetcode.com/problems/lexicographical-numbers/description/
*/


class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        // Start the depth-first search from 1 to 9 (single digit numbers)
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, result);
        }
        
        return result;
    }

        // Depth-first search function to generate the lexical order
    private void dfs(int currentNumber, int n, List<Integer> result) {
        // If the current number exceeds the limit 'n', stop the search
        if (currentNumber > n) {
            return;
        } else {
            // Add the current number to the result list
            result.add(currentNumber);
            
            // Explore the next set of numbers by appending 0 to 9 to the current number
            for (int i = 0; i < 10; ++i) {
                // Calculate the potential next number
                int nextNumber = 10 * currentNumber + i;
                
                // If the potential next number is within the limit 'n', continue the search
                if (nextNumber <= n) {
                    dfs(nextNumber, n, result);
                } else {
                    // If the potential next number exceeds the limit 'n', stop exploring
                    return;
                }
            }
        }
    }


}


/*
The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
Then we visit every node in pre-order. 
       1        2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....
*/