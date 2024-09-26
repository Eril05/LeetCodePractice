/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
*/
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
    public ListNode reverseKGroup(ListNode head, int k) {

        int counter=1;
         ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            counter+=2;
            fast=fast.next.next;
        }
        if(fast.next!=null)
            counter++;

        int noOfLoops=counter/k;

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        int counter2=0;

        ListNode mainHead=dummyHead;
        ListNode mainTail=head;
        ListNode currHead=mainTail;
        ListNode currTail=mainTail;

      while(counter2<noOfLoops){

          //  mainHead.next=null;
            int tempK=0;

            while(tempK<k-1){
                currTail=currTail.next;
                tempK++;
            }
            mainTail=currTail.next;
            currTail.next=null;
            mainHead.next=reverseLinkedList(currHead);
            currHead.next=mainTail;
            mainHead=currHead;
            currHead=currHead.next;
            currTail=currHead;
            counter2++;
      }

        return dummyHead.next;
        
    }

    public ListNode reverseLinkedList(ListNode head){

        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){

            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}
