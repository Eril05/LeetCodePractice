/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right)
            return head;

        ListNode root=new ListNode(-1);
        ListNode tail=root;
        root.next=head;
        

        int counter=0;
        while(counter<left-1 && tail.next!=null){

                tail=tail.next;
                counter++;
        }
        
        ListNode start=tail.next;
        tail.next=reverseLL(left,right,start);
        
        return root.next;
        
    }

    public ListNode reverseLL(int start,int right,ListNode head){


        ListNode prev=null;
        ListNode curr=head;
        while(start<=right){

            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            start++;
        }
        head.next=curr;
        return prev;
    }
}
