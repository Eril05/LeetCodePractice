
/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
*/

class Solution {
    public int singleNumber(int[] nums) {
        
        int ans=0;
        
        for(int i=0;i<32;i++){

            int count=0;
            int value=1<<i;
            for(int j=0;j<nums.length;j++){

                
                if((nums[j] & value)!=0)
                    count++;

            }
            if(count%3!=0)
                ans|=value;
            //value<<=1;
        }
        
        return ans;
    }
}

//creative Solution
class Solution {
    public int singleNumber(int[] nums) {
        
        int ones=0,twos=0;

        for(int i=0;i<nums.length;i++){
            ones=((ones^nums[i])&(~twos));
            twos=((twos^nums[i])&(~ones));
        }

        return ones;
    }
}
