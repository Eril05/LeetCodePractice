/*
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/
class Solution {
    public int maxProduct(int[] nums) {

        int maxValue=nums[0];
        int minValue=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            int temp=maxValue;
            maxValue=Math.max(nums[i],Math.max(maxValue*nums[i],minValue*nums[i])); 
            minValue=Math.min(nums[i],Math.min(temp*nums[i],minValue*nums[i]));
            ans=Math.max(ans,maxValue);
        }
        return ans;
        
    }
}

//Solution 2
class Solution {
    public int maxProduct(int[] nums) {

        int left=1;
        int right=1;
        int numlen=nums.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){

            left=left==0?1:left;
            right=right==0?1:right;

            left=left*nums[i];
            right=right*nums[numlen-i-1];

            ans=Math.max(ans,Math.max(left,right));
        }
        return ans;
    }
}