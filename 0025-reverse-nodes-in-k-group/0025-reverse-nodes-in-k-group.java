/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode getkthNode(ListNode temp,int k){
        k=k-1;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;

        while(temp!=null){
            ListNode kthNode=getkthNode(temp,k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }

            ListNode nextNode=kthNode.next; //store kth next before breaking
            kthNode.next=null; //broken

            ListNode reversedHead=reverseLinkedList(temp);

            if(temp==head){
                head=reversedHead;
            }else{
                prevLast.next=reversedHead;
            }

            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }
}