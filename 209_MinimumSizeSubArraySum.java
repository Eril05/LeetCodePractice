/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int right=0;
        int sum=nums[0];
        int numslen=nums.length;
        int finalAns=Integer.MAX_VALUE;
        while(right<=numslen){

            if(sum>=target){
                finalAns=Math.min(finalAns,(right-left)+1);
            }
            if(sum<target){
                right++;
                if(right<numslen)
                sum+=nums[right];
                
            }
            else{
                sum-=nums[left];
                left++;

                if(left>right){
                    right++;
                }
            }
        }

        if(finalAns==Integer.MAX_VALUE)
            return 0;
        
        return finalAns;
        
    }
}