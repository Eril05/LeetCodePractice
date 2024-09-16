/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>finalList=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        createParenthesis(str,0,0,n,finalList);

        return finalList;
    }

    public void createParenthesis(StringBuilder parenthesis,int start,int end,int n,List<String>finalList){
        if(end==n)
            finalList.add(parenthesis.toString());

        if(start<n){
            createParenthesis(parenthesis.append("("),start+1,end,n,finalList);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }
        if(end<start){
            createParenthesis(parenthesis.append(")"),start,end+1,n,finalList);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }

        
    }

}
