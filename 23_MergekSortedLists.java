/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
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

    
    public ListNode mergeKLists(ListNode[] lists) {
        
        // ListNode head=new ListNode(Integer.MIN_VALUE);
        // for(ListNode nodes: lists){

        //     mergeTwoLL(head,nodes);
        // }

        // return head.next;
        if(lists==null || lists.length==0)
            return null;


        return mergeHelper(lists,0,lists.length-1);
        
    }

    public ListNode mergeHelper(ListNode[] lists,int start,int end){

        if(start==end)
            return lists[start];
        

        if((start+1)==end){
            return mergeTwoLL(lists[start],lists[end]);
        }
        
        int mid=start+(end-start)/2;

        ListNode left=mergeHelper(lists,start,mid);
        ListNode right=mergeHelper(lists,mid+1,end);
        return mergeTwoLL(left,right);
    }


    public ListNode mergeTwoLL(ListNode list1,ListNode list2){

        // if(list1==null)
        //     return list2;

        // if(list2==null)
        //     return list1;

        ListNode head=new ListNode(-1);
        ListNode tail=head;

        while(list1!=null && list2!=null){

                if(list1.val>list2.val){
                    tail.next=list2;
                    list2=list2.next;
                }else{
                    tail.next=list1;
                    list1=list1.next;
                }
                tail=tail.next;

        }
        if(list1!=null)
            tail.next=list1;
        if(list2!=null)
            tail.next=list2;

        return head.next;
    }
}
