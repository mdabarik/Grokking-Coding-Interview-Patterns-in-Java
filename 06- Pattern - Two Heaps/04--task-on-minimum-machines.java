/*
Same as meeting room ii
*/

import java.util.*;

class ScheduleTask {
    public static int tasks(List<List<Integer>> tasksList) {
        tasksList.sort((x,y) -> Integer.compare(x.get(0), y.get(0)));
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        minHeap.add(tasksList.get(0));
        int i = 1;
        while (i < tasksList.size()) {
            List<Integer> tmp = minHeap.peek();
            int endTime = tmp.get(1);
            int startTime = tasksList.get(i).get(0);
            if (endTime <= startTime) {
                minHeap.poll();
            }
            minHeap.add(tasksList.get(i));
            i++;
        }
        return minHeap.size();
    }
}