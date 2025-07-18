// //Approach-1 (Brute Force - Do as said)
// //T.C : O(mlogm +m*n) , where Let n = number of rooms, m =  number of meetings
// //S.C : O(n)
// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         // sort by starting time of meetings
//         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

//         // Each room is used 0 times in the beginning
//         int[] roomsUsedCount = new int[n];
//         // Each room will be last available at
//         long[] lastAvailableAt = new long[n];

//         for (int[] meet : meetings) {
//             int start = meet[0];
//             int end = meet[1];
//             boolean found = false;

//             long earlyEndRoomTime = Long.MAX_VALUE;
//             int earlyEndRoom = 0;

//             // Find the first available meeting room
//             for (int room = 0; room < n; room++) {
//                 if (lastAvailableAt[room] <= start) {
//                     found = true;
//                     lastAvailableAt[room] = end;
//                     roomsUsedCount[room]++;
//                     break;
//                 }

//                 if (lastAvailableAt[room] < earlyEndRoomTime) {
//                     earlyEndRoom = room;
//                     earlyEndRoomTime = lastAvailableAt[room];
//                 }
//             }

//             if (!found) {
//                 lastAvailableAt[earlyEndRoom] += (end - start);
//                 roomsUsedCount[earlyEndRoom]++;
//             }
//         }

//         int resultRoom = -1;
//         int maxUse = 0;
//         for (int room = 0; room < n; room++) {
//             if (roomsUsedCount[room] > maxUse) {
//                 maxUse = roomsUsedCount[room];
//                 resultRoom = room;
//             }
//         }

//         return resultRoom;
//     }
// }


//Approach-2 (Use priority Queue to find the first available meeting room)
//T.C : O(mlogm + m*log(n)) , where Let n = number of rooms, m =  number of meetings
//S.C : O(n)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort by starting time of meetings
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Each room is used 0 times in the beginning
        int[] roomsUsedCount = new int[n];

        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var unusedRooms = new PriorityQueue<Integer>();
        
        for (int room = 0; room < n; room++) {
            unusedRooms.add(room); // All rooms are unused in the beginning
        }

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];

            // First see, by this time, which rooms can be empty now
            // And move them to unusedRooms
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.add(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.add(new long[]{end, room});
                roomsUsedCount[room]++;
            } else { // We don't have any room available now. Pick the earliest end room
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.poll()[0];
                usedRooms.add(new long[]{endTime + (end - start), room});
                roomsUsedCount[room]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsUsedCount[room] > maxUse) {
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}