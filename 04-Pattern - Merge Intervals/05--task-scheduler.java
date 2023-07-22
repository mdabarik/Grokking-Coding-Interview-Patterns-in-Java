/*
https://practice.geeksforgeeks.org/problems/task-scheduler/1
https://leetcode.com/problems/task-scheduler/
 */

/* We’re given a character array, tasks, where each character represents a unique task. These tasks need to be performed by a single CPU, with each task taking one unit of time. The tasks can be performed in any order. At any given time, a CPU can either perform some task or stay idle.

For the given tasks, we are also provided with a positive integer value, n, which represents the cooling period between any two identical tasks. This means that the CPU must wait for at least n units of time before it performs the same task again. For example, if we have the tasks [A,B,A,C] and n = 2, then after performing the first A task, the CPU will wait for at least 2 units of time to perform the second A task. During these 2 units of time, the CPU can either perform some other task or stay idle.

Given the two input values, tasks and n, find the least number of units of time the CPU will take to perform the given tasks. 

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Example 2:
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

Example 3:
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*/

