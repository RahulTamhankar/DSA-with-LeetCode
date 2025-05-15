class LRUCache {
    private Deque<Integer> dll;
    private Map<Integer,Pair> cache;
    private int capacity;

    private class Pair{
        int value;
        Pair(int value){
            this.value=value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.dll = new LinkedList<>();
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        makeMostRecentlyUsed(key);
        return cache.get(key).value; //pair used-->cache.get(key).value = value;

    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value=value; //pair used 
            makeMostRecentlyUsed(key);
        }else{
            dll.addFirst(key);
            cache.put(key,new Pair(value)); //When a new key-value pair is added to the cache, a new Pair object is created to wrap the value.This is necessary because cache is a Map<Integer, Pair>, not a Map<Integer, Integer>.


            capacity--;
        }

        if(capacity<0){
            int lruKey=dll.removeLast();
            cache.remove(lruKey);
            capacity++;
        }
    }

    private void makeMostRecentlyUsed(int key){
        dll.remove(key);
        dll.addFirst(key);
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

// java
// Copy
// Edit
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