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
        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value=value;
            makeMostRecentlyUsed(key);
        }else{
            dll.addFirst(key);
            cache.put(key,new Pair(value));
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