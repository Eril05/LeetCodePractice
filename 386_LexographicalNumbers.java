/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104
*/
class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer>finalList=new ArrayList<>();
        for(int i=1;i<=9;i++)
            generateList(finalList,n,i);

        return finalList;
        
    }

    public void generateList(List<Integer>finalList,int n,int curr){


        if(curr>n){
            return;
        }
        finalList.add(curr);

        for(int i=0;i<=9;i++){

            int temp=curr*10+i;

            if(temp<n){
                generateList(finalList,n,temp);
            }
            else if(temp==n){
                finalList.add(temp);
                return;
            }
            else{
                return;
            }
        }
    }
}
