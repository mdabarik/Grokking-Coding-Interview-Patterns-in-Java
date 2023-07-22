// Without Comments
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        for (int i = 1; i <= n; i++) {
            int prev = slow;
            slow = nextStep(slow, nums[slow], n);
            if (isNotCycle(nums, prev, slow)) {
                slow = i;
                fast = i;
                continue;
            }
            boolean nextIteration = false;
            for (int j = 1; j <= 2; j++) {
                prev = fast;
                fast = nextStep(fast, nums[fast], n);
                if (isNotCycle(nums, prev, fast)) {
                    slow = i;
                    fast = i;
                    nextIteration = true;
                    break;
                }
            }
            if (nextIteration == true) continue;
            if (slow == fast) return true;
        }
        return false;
    }

    int nextStep(int pointer, int val, int n) {
        int result = (pointer + val) % n;
        if (result < 0) result += n;
        return result;
    }

    boolean isNotCycle(int[] nums, int prev, int pointer) {
        if (nums[prev] >= 0 && nums[pointer] < 0) return true;
        if (Math.abs(nums[pointer] % nums.length) == 0) return true;
        else return false;
    }
}

// TC: O(n), SC: O(1)


// With Comments
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        return call(nums);
    }
    
    boolean call(int[] nums) {
        // Set slow and fast pointer at first element.
        int slow = 0, fast = 0;

        int size = nums.length;

        for (int i = 1; i <= size; i++) {
        // Save slow pointer's value before moving.
        int prev = slow;
        // Move slow pointer to one step.
        slow = nextStep(slow, nums[slow], size);
        // Check if cycle is impossible, then set both pointers to next value
        // and move to the next iteration.
        if (isNotCycle(nums, prev, slow)) {
            fast = i;
            slow = i;
            continue;
        }
        // This flag indicates whether we need to move to the next iteration.
        boolean nextIter = false;
        // Number of moves of fast pointer.
        int moves = 2;
        for (int j = 0; j < moves; j++) {
            // Save fast pointer's value before moving.
            prev = fast;
            // Move fast pointer check cycle after every move.
            fast = nextStep(fast, nums[fast], size);
            // If cycle is not possible, set slow and fast to next element
            // set 'next_iter' to true and break this loop.
            if (isNotCycle(nums, prev, fast)) {
            fast = i;
            slow = i;
            nextIter = true;
            break;
            }
        }
        // Move to the next iteration
        if (nextIter) {
            continue;
        }
        // If both pointers are at same position after moving both, a cycle is detected.
        if (slow == fast) {
            return true;
        }
        }
        return false;
    }

    // A function to calculate the next step.
    int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
        result += size;
        }
        return result;
    }

    // A function to detect a cycle doesn't exist
    boolean isNotCycle(int[] nums, int prev, int pointer) {
        // If signs of both pointers are different or moving a pointer takes back to the same value,
        // then the cycle is not possible, we return True, otherwise return False.
        if ((nums[prev] >= 0 && nums[pointer] < 0) || (Math.abs(nums[pointer] % nums.length) == 0)) {
        return true;
        } else {
        return false;
        }
    }
}