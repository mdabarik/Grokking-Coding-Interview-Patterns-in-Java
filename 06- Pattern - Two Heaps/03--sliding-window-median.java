
/* --------------------------- Naive Solution ------------------------------ */
class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return result;
    }

    private void add(int num) {
        if (num > getMedian()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        rebalance();
    }

    private void remove(int num) {
        if (num > getMedian()) {
            minHeap.remove(num);
        } else {
            maxHeap.remove(num);
        }
        rebalance();
    }

    private double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        } 
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }

    private void rebalance() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
}
// Naive will note pass all the test cases

/* ----------------------- Efficient Solution ------------------------- */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
       double[] result = new double[nums.length - k + 1];
       int start = 0;
          
       TreeSet<Integer> lo = new TreeSet<>((a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b));
       TreeSet<Integer> hi = new TreeSet<>((a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b));
        
       for (int i = 0; i < nums.length; i++) {
            lo.add(i);
            hi.add(lo.pollLast());
            if(hi.size()>lo.size()) lo.add(hi.pollFirst());
            if (lo.size() + hi.size() == k) {
                result[start]=lo.size()==hi.size()? nums[lo.last()]/2.0+ nums[hi.first()]/2.0: nums[lo.last()]/1.0;
                if (!lo.remove(start)) hi.remove(start);
                start++;
            }
        }
        return result;
    }
}
// TC: O(n * log k), SC: O(n)