/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

class Solution {
    class pair {
        int i, j, sum;
        public pair (int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.add(new pair(i, 0, nums1[i] + nums2[0]));
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            pair tmp = minHeap.poll();
            int i = tmp.i, j = tmp.j, sum = tmp.sum;
            ans.add(Arrays.asList(nums1[i], nums2[j]));
            int nextIndex = j + 1;
            if (nums2.length > nextIndex) {
                minHeap.add(new pair(i, nextIndex, nums1[i] + nums2[nextIndex]));
            }
            if (ans.size() == k) return ans;
        }
        return ans;
    }
}

// TC: O(n * log k), SC: O(k)