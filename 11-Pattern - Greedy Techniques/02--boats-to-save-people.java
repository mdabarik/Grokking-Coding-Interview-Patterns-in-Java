/*
https://leetcode.com/problems/boats-to-save-people/description/
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boatsRequired = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                boatsRequired++;
                left++;
                right--;
            } else {
                boatsRequired++;
                right--;
            }
        }
        return boatsRequired;
    }
}

// TC: O(log n), SC: O(n)