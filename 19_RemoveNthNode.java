/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int counter=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            counter++;
        }
        if(counter==1)
            return null;
        if(counter==n)
            return head.next;

        int start=0;
        curr=head;
        counter=counter-n;
        while(start<counter-1){
            
            curr=curr.next;
            start++;
        }

        curr.next=curr.next.next;

        return head;
        
    }
}
