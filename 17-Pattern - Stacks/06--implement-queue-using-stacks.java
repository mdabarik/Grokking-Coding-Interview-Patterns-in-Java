/*
https://leetcode.com/problems/exclusive-time-of-functions/description/
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        
        return result;
    }
    
    public static class Log {
        public int id;
        public boolean isStart;
        public int time;
        
        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}

// TC: O(n), SC: O(n)







// educative solution
class TimeOfFunction {
	
	public static List<Integer> exclusiveTime(int n, List<String> events) {
		Deque<Event> stack = new ArrayDeque<>();
		List<Integer> result = new ArrayList<Integer> (Collections.nCopies(n, 0));
		for (String content: events) {
			Event event = new Event(content);
			if (event.getIsStart()) {
				stack.push(event);
			} else {
				Event top = stack.pop();
				result.set(top.getId(), result.get(top.getId()) + (event.getTime() - top.getTime() + 1));
				if (!stack.isEmpty()) {
					result.set(stack.peek().getId(), result.get(stack.peek().getId()) - (event.getTime() - top.getTime() + 1));
				}
			}
		}
		return result;
	}

	// Driver code
	public static void main(String args[]) {
		List<List<String>> events = Arrays.asList(
			Arrays.asList("0:start:0", "1:start:2", "1:end:3", "2:start:4", "2:end:7", "0:end:8"),
			Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"),
			Arrays.asList("0:start:0", "1:start:5", "1:end:6", "0:end:7"),
			Arrays.asList("0:start:0", "1:start:5", "2:start:8", "3:start:12", "4:start:15", "5:start:19", "5:end:22", "4:end:24", "3:end:27", "2:end:32", "1:end:35", "0:end:36"),
			Arrays.asList("0:start:0", "1:start:3", "1:end:6", "0:end:10")
		);
		List<Integer> n = Arrays.asList(3, 2, 2, 6, 2);
		int x = 1;
		for (int i = 0; i<n.size(); i++) {
			System.out.println(x + ".\tn = " + n.get(i));
			System.out.println("\tevents = " + events.get(i));
			System.out.println("\tOutput: " + exclusiveTime(n.get(i), events.get(i)));
			System.out.println(new String(new char[100]).replace('\0', '-'));
			x += 1;
		}
	}
}