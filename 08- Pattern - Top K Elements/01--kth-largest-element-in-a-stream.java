import java.util.*;

class KthLargest {
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// constructor to initialize topKHeap and add values in it
	public KthLargest(int k, int[] nums) {
		for (int num : nums) {
			if (minHeap.size() == k) {
				if (minHeap.peek() < num) {
					minHeap.poll();
					minHeap.add(num);
				}
			} else {
				minHeap.add(num);
			}
		}
	}
	// adds element in the topKHeap
	public int add(int val) {
		if (!minHeap.isEmpty()) {
			if (minHeap.peek() < val) {
				minHeap.poll();
				minHeap.add(val);
			}
		}
		return returnKthLargest();
	}
	// returns kth largest element from topKHeap
	public int returnKthLargest() {
		if (!minHeap.isEmpty()) 
			return minHeap.peek();
		return -1;
	}
	
}