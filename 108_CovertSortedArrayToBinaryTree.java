/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
 binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root=createBTree(nums,0,nums.length-1);
        
        return root;
    }

    public TreeNode createBTree(int[]nums,int start,int end){

        if(start<0 || end>=nums.length || start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start]);

        int mid=(end-start+1)/2+start;

        TreeNode root=new TreeNode(nums[mid]);
        root.left=createBTree(nums,start,mid-1);
        root.right=createBTree(nums,mid+1,end);

        return root;
    }
}
