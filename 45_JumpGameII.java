
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
  */
//TC O(n)

class Solution {
    public int jump(int[] nums) {


        int left=0;
        int right=0;
        int jumps=0;

        while(right<nums.length-1){

            int farthest=0;
            for(int i=left;i<=right;i++){

                farthest=Math.max(farthest,i+nums[i]);
            }
            left=right+1;
            right=farthest;
            jumps++;
        }

        return jumps;
        
    }
}

//DP approach o(n*n)TC
class Solution {
    public int jump(int[] nums) {

        int dpSize=nums.length;
        if(dpSize==1)
            return 0;

        if(dpSize==2)
            return 1;
        int dp[]=new int[dpSize];
        Arrays.fill(dp,10000);
        dp[dpSize-1]=0;
        
        for(int i=dpSize-2;i>=0;i--){

            int value=nums[i];
            int counter=1;
            // if(value>0){
                while(counter<=value && (i+counter)<dpSize){


                    dp[i]=Math.min(dp[i],1+dp[i+counter]);
                    counter++;
                }
            // }
        }

        return dp[0];
    }
}
