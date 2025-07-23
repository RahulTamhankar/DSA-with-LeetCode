//Approach (Using Sorting and heap and hreedily picking the ones ending earliest)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//min heap
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int day = events[0][0];
        int i = 0;
        int count = 0; // Result number of events attended

        while(!pq.isEmpty() || i < n) {// even if index is Out of Bound I need to see if there are elements in pq, hence 2 checks

              
            // Add all events that start on `day` to the min-heap
            while(i < n && events[i][0] == day) { //if starting day of events[i] == starting day, then keep pushing them in pq
                pq.add(events[i][1]);//just put event[i] ka 1st elements, as the 2nd one not needed
                i++;
            }

            if(!pq.isEmpty()) {
                pq.poll(); // Attend an event on this day, use top ka events frpm pq
                count++; // Counting the result, 1 event attended on this day. Makre sure before doing all this check if pq is not empty
            }

            day++;

            // Skip events whose end day is less than the current day
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return count;
    }
}