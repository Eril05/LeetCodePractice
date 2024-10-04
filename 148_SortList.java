/*
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105

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
    public ListNode sortList(ListNode head) {

        return merge(head);
        
    }

    public ListNode merge(ListNode head){

        if(head==null || head.next==null)
            return head;

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
        //ListNode temp=slow.next;
      //  slow.next=null;
        ListNode head2=merge(slow.next);
        slow.next=null;
        ListNode head1=merge(head);

        

        return mergeSortedLL(head1,head2);


    }

    public ListNode mergeSortedLL(ListNode list1,ListNode list2){


        ListNode root=new ListNode(-1);
        ListNode tail=root;

        while(list1!=null && list2!=null){

            if(list1.val>list2.val){
                tail.next=list2;
                list2=list2.next;
            }
            else{
                tail.next=list1;
                list1=list1.next;
            }
            tail=tail.next;

        }

        if(list1!=null){
            tail.next=list1;
        }
        else
            tail.next=list2;

        return root.next;
    }
}
