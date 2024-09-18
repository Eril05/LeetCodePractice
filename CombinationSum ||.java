/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>finalList=new ArrayList<>();
        Arrays.sort(candidates);
     //   System.out.println(candidates);
        createCombination(candidates,target,finalList,0,new ArrayList<Integer>());

        return finalList;
    }

    public void createCombination(int[] candidates,int target,List<List<Integer>>finalList,int index,List<Integer>tempList){

         if(target==0){
            //if(!finalList.contains(tempList))
            finalList.add(new ArrayList<>(tempList));
            return;
        }

        if(target<0){
            return;
        }
       


        
        for(int i=index;i<candidates.length;i++){

            if(i>index && candidates[i]==candidates[i-1] ){
                continue;
            }
            if(candidates[i]>target)break;
        tempList.add(candidates[i]);
        createCombination(candidates,target-candidates[i],finalList,i+1,tempList);

        tempList.remove(tempList.size()-1);
       // createCombination(candidates,target,finalList,i+1,tempList);
        }

    }
}
