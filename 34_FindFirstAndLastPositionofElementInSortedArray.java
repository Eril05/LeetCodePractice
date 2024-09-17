/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int finalArr[]=new int[2];
        finalArr[0]=bsearch(nums,target,true);
        finalArr[1]=bsearch(nums,target,false);

        return finalArr;
    }

    public int bsearch(int[] nums,int target,boolean check){

        int low=0;
        int high=nums.length-1;
        int ans=-1;
        int mid=0;

        while(low<=high){
            mid=((high-low)/2)+low;
            
            if(nums[mid]==target){

                if(check){
                    ans=mid;
                    high=mid-1;
                }
                else{
                    ans=mid;
                    low=mid+1;
                }
            }
            else if(nums[mid]<target){

                low=mid+1;
            }
            else{

                high=mid-1;
            }
        }
        return ans;
    }
}
