//
//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//
//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {

    public boolean pathExists(ListNode head,TreeNode root){

        if(root==null && head==null)
            return true;
        if(root==null)
            return false;
        if(head==null)
            return true;
        if(head.val==root.val){
            return pathExists(head.next,root.right)||pathExists(head.next,root.left);
        }
        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        boolean ans=false;
        if(root==null)
            return false;
        if(head==null)
            return true;
        if(head.val==root.val){

            ans=pathExists(head,root);
        }
        if(ans)
            return true;
        ans=ans||isSubPath(head,root.left);
        ans=ans||isSubPath(head,root.right);

        return ans;

    }
}
