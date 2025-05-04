class MyHashMap {

    // ✅ Define the Node class that will be used in the linked list buckets
    private class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] map;

    public MyHashMap() {
        map = new Node[1000]; // initialize array of linked lists
        for (int i = 0; i < 1000; i++) {
            map[i] = new Node(-1, -1); // dummy head node for each list
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value; // update if key already exists
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value); // add new node at end
    }

    public int get(int key) {
        int hash = hash(key);
        Node cur = map[hash].next;

        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1; // not found
    }

    public void remove(int key) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next; // remove node by skipping it
                return;
            }
            cur = cur.next;
        }
    }

    private int hash(int key) {
        return key % 1000;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */