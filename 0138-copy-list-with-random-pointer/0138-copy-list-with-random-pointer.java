class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Interleave copied nodes
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node newHead = head.next;
        Node copyCurr = newHead;

        while (curr != null) {
            curr.next = curr.next != null ? curr.next.next : null;
            copyCurr.next = copyCurr.next != null ? copyCurr.next.next : null;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }
}
