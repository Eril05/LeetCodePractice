/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/

//1st Solution

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode lessValue=new ListNode(-1);
        ListNode higherValue=new ListNode(-1);

        ListNode dummyNode=lessValue;
        ListNode dummyNode2=higherValue;

        while(head!=null){

            if(head.val<x){
                lessValue.next=head;
                head=head.next;
                lessValue=lessValue.next;
                lessValue.next=null;
            }
            else{
                higherValue.next=head;
                head=head.next;
                higherValue=higherValue.next;
                higherValue.next=null;
            }
        }

        lessValue.next=dummyNode2.next;


        return dummyNode.next;
        
    }
}

//Solution 2

class Solution {
    public ListNode partition(ListNode head, int x) {


        ListNode dummyNode=new ListNode(-1000);
        

        dummyNode.next=head;
        ListNode tail=head;
        head=dummyNode;
        ListNode prev=dummyNode;
        while(tail!=null){

            while(tail!=null && tail.val<x){
                
                if(dummyNode.next!=tail){
                prev.next=tail.next;
                tail.next=dummyNode.next;
                dummyNode.next=tail;

                }
                else
                    prev=prev.next;

                tail=prev.next;
                dummyNode=dummyNode.next;
            }
            if(tail==null)
                break;
            
                tail=tail.next;
                prev=prev.next;


        }

        return head.next;

    }
}
