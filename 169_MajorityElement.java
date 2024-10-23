/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

  
  
//Moore's Voting Algo O(N)
class Solution {
    public int majorityElement(int[] nums) {
        
        int element=0;
        int count=0;
        for(int i=0;i<nums.length;i++){

            if(count==0){
                element=nums[i];
                count++;
            }
            else if(nums[i]==element){
                count++;
            }
            else{
                count--;
            }
        }

        return element;
    }
}


//Solution 2 O(N logN)
class Solution {
    public int majorityElement(int[] nums) {


        Arrays.sort(nums);
        int half=(nums.length+1)/2;
        for(int i=0;i<nums.length;i++){

            int num=nums[i];
            if(nums[i+half-1]==num)
                return num;
            else{
                while(nums[i+1]==num)
                    i++;
            }
        }

        return 0;
        
    }
}

//Solution 2 O(NlogN)
class Solution {
    public int majorityElement(int[] nums) {


        Arrays.sort(nums);


        return nums[nums.length/2];
        
    }
}
