/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/


class Solution {
    public int lengthOfLIS(int[] nums) {

        int numlen=nums.length;
        int maxLen=1;
        int dp[]=new int[numlen];
        Arrays.fill(dp,1);
        for(int i=nums.length-2;i>=0;i--){
            maxLen=Math.max(maxLen,getLIS(nums,dp,i,numlen));
        }
         return maxLen;
    }
    public int getLIS(int []nums,int []dp,int start,int end){

        int tempMax=1;
        for(int i=start+1;i<end;i++){

            if(nums[start]<nums[i]){
                tempMax=Math.max(tempMax,dp[start]+dp[i]);
            }
        }
        dp[start]=tempMax;
        return dp[start];
    }
}
