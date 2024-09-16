/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permuteList=new ArrayList<>();

        createPermute(permuteList,0,nums);

        return permuteList;
        
    }

    public void createPermute(List<List<Integer>> permuteList,int index,int[] nums){

        if(index==nums.length-1){
            List<Integer>tempList=new ArrayList<>();
            for(int n: nums){
                tempList.add(n);
            }
            
            permuteList.add(tempList);
        }

        for(int i=index;i<nums.length;i++){

           
            swapValues(nums,index,i);

            createPermute(permuteList,index+1,nums);

            swapValues(nums,index,i);


        }
    }

        public void swapValues(int []nums,int index,int i){

                 int temp=nums[index];
                 nums[index]=nums[i];
                 nums[i]=temp;
        }
        
    
}
