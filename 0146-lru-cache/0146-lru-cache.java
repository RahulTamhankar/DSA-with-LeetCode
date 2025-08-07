// class LRUCache {
//     private Deque<Integer> dll;
//     private Map<Integer,Pair> cache;
//     private int capacity;

//     private class Pair{
//         int value;
//         Pair(int value){
//             this.value=value;
//         }
//     }

//     public LRUCache(int capacity) {
//         this.capacity=capacity;
//         this.dll = new LinkedList<>();
//         this.cache = new HashMap<>();
//     }
    
//     public int get(int key) {
//         if(!cache.containsKey(key))  // if key is not present then return -1
        
//             return -1;
        
//         //if key is present then mark it as recently used,front pe lana padega, so uske lie map me uska address stored hai, map se address nikalo aur usko erase karke front me leke aao
//         makeMostRecentlyUsed(key); //function to keep it in front - > How to make it mostRecently used ? erase it from DLL and then put it in front of DLL
//         return cache.get(key).value; //pair used-->cache.get(key).value = value;

//     }
    
//     public void put(int key, int value) {
//         if(cache.containsKey(key)){  //if key already in map we just need to update its value, and also mark it as recentlyUsed
//             cache.get(key).value=value; //pair used 
//             makeMostRecentlyUsed(key);
//         }else{
//             dll.addFirst(key); //if key not present in map then put that in front of dll and also upadate in map.Putting it in front coz Dll does it in o(1)
//             cache.put(key,new Pair(value)); //When a new key-value pair is added to the cache, a new Pair object is created to wrap the value.This is necessary because cache is a Map<Integer, Pair>, not a Map<Integer, Integer>.


//             capacity--;
//         }

//         if(capacity<0){
//             int keyToBeDeleted=dll.removeLast();
//             cache.remove(keyToBeDeleted);
//             capacity++;
//         }
//     }

//     private void makeMostRecentlyUsed(int key){
//         dll.remove(key);  //THERE IS NO concept of address in java hence just remove will be fine
//         dll.addFirst(key);// Remove from back and put in front
//     }
// }
//-------------------
import java.util.*;

class LRUCache {
    private Deque<Integer> dll;
    private Map<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new LinkedList<>();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeMostRecentlyUsed(key);
        return cache.get(key); // No more .value
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // Directly put the value
            makeMostRecentlyUsed(key);
        } else {
            dll.addFirst(key); // Add to front of DLL
            cache.put(key, value);
            capacity--;
        }

        if (capacity < 0) {
            int keyToBeDeleted = dll.removeLast(); // Remove least recently used
            cache.remove(keyToBeDeleted);
            capacity++;
        }
    }

    private void makeMostRecentlyUsed(int key) {
        dll.remove(key);    // Remove from current position
        dll.addFirst(key);  // Move to front
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

////--------------------------------------

//  Let’s walk through this sequence with capacity = 2:

// LRUCache cache = new LRUCache(2);
// cache.put(1, 10);
// cache.put(2, 20);
// cache.get(1);
// cache.put(3, 30);
// ✅ Step-by-step Execution
// 1. cache.put(1, 10)
// Map:

// scss
// Copy
// Edit
// {
//   1 → Pair(value=10)
// }
// Deque (most recent on the left):

// csharp
// Copy
// Edit
// [1]
// 2. cache.put(2, 20)
// Map:

// scss
// Copy
// Edit
// {
//   1 → Pair(value=10),
//   2 → Pair(value=20)
// }
// Deque:

// csharp
// Copy
// Edit
// [2, 1]
// 3. cache.get(1) → Access key 1, so it becomes most recently used
// Map (unchanged):

// scss
// Copy
// Edit
// {
//   1 → Pair(value=10),
//   2 → Pair(value=20)
// }
// Deque:

// csharp
// Copy
// Edit
// [1, 2]   // 1 moved to front
// 4. cache.put(3, 30) → Evicts least recently used (key 2)
// Since the cache is full, key 2 (at the back) is evicted.

// Map:

// scss
// Copy
// Edit
// {
//   1 → Pair(value=10),
//   3 → Pair(value=30)
// }
// Deque:

// csharp
// Copy
// Edit
// [3, 1]
// \U0001f9fe Final State (after all operations)
// Map:

// scss
// Copy
// Edit
// {
//   1 → Pair(value=10),
//   3 → Pair(value=30)
// }
// Deque:

// csharp
// Copy
// Edit
// [3, 1]
// Meaning:

// Key 3 is most recently used

// Key 1 is the next most recently used

// Key 2 has been evicted due to LRU policy

// \U0001f4ca Diagram Summary
// plaintext
// Copy
// Edit
// Map (Key → Value)
// -----------------
// 1 → Pair(10)
// 3 → Pair(30)

// Deque (Usage Order - MRU to LRU)
// -------------------------------
// [3, 1]

/////////////////////////////////////////////

 

// ChatGPT said:
// Great — you're working with a brute force implementation of an LRU (Least Recently Used) Cache. If you're explaining this to an interviewer, you want to focus on your approach, data structures, time complexities, and trade-offs. Here's a clean and confident way to walk through it:

// ✅ High-Level Explanation:
// I'm implementing an LRU Cache that supports get(key) and put(key, value) operations. The cache has a fixed capacity, and when it’s full, it evicts the least recently used item before inserting a new one.

// \U0001f9f1 Data Structures Used:
// I use a vector<pair<int, int>> to store the key-value pairs.

// The most recently used item is always at the end of the vector.

// When an item is accessed (get) or updated/inserted (put), it's moved to the end of the vector.

// If the cache is full, I remove the first element (which is the least recently used).

// \U0001f50d get(key) Explanation:
// I iterate over the vector to find the key.

// If found:

// I retrieve its value.

// I remove it from its current position and move it to the end of the vector (most recently used).

// If not found:

// I return -1.

// Time Complexity:

// Worst-case O(n), since I have to linearly search for the key.

// ✏️ put(key, value) Explanation:
// I first check if the key already exists:

// If it does, I remove it and push the new {key, value} pair to the end.

// If it doesn’t:

// I check if the cache is full:

// If full, I remove the first item (least recently used).

// Then I insert the new {key, value} pair at the end.

// Time Complexity:

// Again, O(n) in the worst case due to linear search and erase operations.

// ⚖️ Trade-offs:
// This approach is simple and works correctly, but it's not optimal for large data sizes due to the linear search and erase operations. Ideally, an LRU cache should offer O(1) time for both get and put.

// If prompted, you can mention:

// A better implementation would use a hash map for fast access, and a doubly-linked list to maintain the usage order in O(1) time. I’m happy to walk through that version if you’d like.

// Would you like help rewriting this into a more optimal version using unordered_map + list?





// You said:
// give wrt to java


// ChatGPT said:
// Sure! Here's how you can explain your brute-force LRU Cache approach in Java, similar to what you've done in C++.

// ✅ High-Level Explanation (Java Perspective):
// I'm implementing an LRU (Least Recently Used) Cache using a List of key-value pairs. The idea is simple:

// The most recently used items are kept at the end of the list.

// The least recently used item is at the front of the list.
// When a get() or put() is called, I move the item to the end to mark it as recently used.
// If the cache is full, I remove the first item (least recently used).

// \U0001f9f1 Data Structures Used:
// In Java:

// java
// Copy
// Edit
// List<int[]> cache = new ArrayList<>();
// int capacity;
// cache holds key-value pairs as int arrays [key, value].

// capacity stores the maximum size of the cache.

// \U0001f50d get(int key) Logic:
// Loop through the list to find the key.

// If found:

// Get the value.

// Remove the item from its current position.

// Add it to the end of the list (mark as recently used).

// If not found:

// Return -1.

// java
// Copy
// Edit
// public int get(int key) {
//     for (int i = 0; i < cache.size(); i++) {
//         if (cache.get(i)[0] == key) {
//             int value = cache.get(i)[1];
//             int[] pair = cache.remove(i);
//             cache.add(pair);
//             return value;
//         }
//     }
//     return -1;
// }
// ✏️ put(int key, int value) Logic:
// First, check if the key already exists:

// If it does, remove it.

// If the cache is full (cache.size() == capacity), remove the first element.

// Add the new key-value pair to the end of the list.

// java
// Copy
// Edit
// public void put(int key, int value) {
//     for (int i = 0; i < cache.size(); i++) {
//         if (cache.get(i)[0] == key) {
//             cache.remove(i);
//             cache.add(new int[]{key, value});
//             return;
//         }
//     }

//     if (cache.size() == capacity) {
//         cache.remove(0);
//     }
//     cache.add(new int[]{key, value});
// }
// \U0001f4c9 Time Complexity:
// get() and put() are both O(n) in the worst case due to the linear search.

// This is acceptable for small inputs but not efficient for large-scale systems.

// ⚡ Better Java Alternative (If Asked):
// In an interview, I’d also suggest using:

// LinkedHashMap (in Java) which maintains insertion/access order,

// Or using a HashMap + DoublyLinkedList manually for full control and O(1) get() and put().