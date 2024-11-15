/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>>finalList=new ArrayList<>();
        helper(n,k,finalList,new ArrayList<>(),1);
        
        return finalList;
    }

    public void helper(int n,int k,List<List<Integer>>finalList,ArrayList<Integer>tempList,int index){

        if(tempList.size()==k){
            finalList.add(new ArrayList<>(tempList));
            return;
        }


        for(int i=index;i<=n;i++){

            tempList.add(i);
            helper(n,k,finalList,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
