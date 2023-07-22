

/*
We are given an input array of meeting time intervals, intervals, where each interval has a start time and an end time. Your task is to find the minimum number of meeting rooms required to hold these meetings.

Example 1:
Input: Intervals = [[2, 8], [3, 4], [3, 9], [5, 11], [8, 20], [11, 15]]
Output:
Meeting room 1:
Interval 1: [2, 8]
Interval 5: [8, 20]

Meeting Room 2:
Interval 2: [3, 4]
Interval 4: [5, 11]

Meeting Room 3:
Interval 3: [3, 9]
Interval 6: [11, 15]

Example 2:
Input: Intervals = [[1, 7], [2, 6], [3, 7], [4, 8], [5, 8], [2, 9], [1, 8]]
Output:
Meeting room 1:
Interval 1: [1, 7]

Meeting room 2:
Interval 2: [2, 6]

Meeting room 3:
Interval 3: [3, 7]

Meeting room 4:
Interval 5: [4, 8]

Meeting room 5:
Interval 4: [5, 8]

meeting room 6:
Interval 6: [2, 9]

Meeting room 7:
Interval 5: [1, 8]

A total of 7 meeting rooms are required to hold theses mettings.


Input: Interval = [[1,6], [4,8], [1,5], [6,8], [8,11], [8,9], [5,10]]
Output: 
Meeting room 1:
Interval 1: [1,6]
Interval 4: [6, 8]
Interval 5: [8, 11]

Meeting room 2:
Interval 3: [1, 5]
Interval 7: [5, 10]

Meeting room 3: 
Interval 2: [4, 8]
Interval 6: [8, 9]

A total of 3 meeting rooms are required to hold these 7 meetings.
*/

import java.util.*;

public class MeetingRooms{
    public static int minMeetingRooms(List <Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        Collections.sort(intervals, (o1, o2) -> o1.getStart() - o2.getStart());
        
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->{
 			return a.getEnd() - b.getEnd();
 		});
         

        pq.offer(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++){
 			if (intervals.get(i).getStart() >= pq.peek().getEnd()){
 				pq.poll();
 			}
 			pq.offer(intervals.get(i));
 		}

        return pq.size();
    }
}
