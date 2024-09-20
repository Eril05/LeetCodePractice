/*
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

 

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
*/
class Solution {

    public List<Integer> diffWaysToCompute(String expression) {

        Map<String,List<Integer>>dp=new HashMap<>();

        return buildCombination(expression,dp);
        
    }

    public List<Integer> buildCombination(String expression,Map<String,List<Integer>>dp){

        if(dp.containsKey(expression)){
                return dp.get(expression);
        }
        List<Integer>combinationList=new ArrayList<>();

        for(int i=0;i<expression.length();i++){

            char operator=expression.charAt(i);

            if(operator=='+' || operator=='-' || operator=='*' ){

                List<Integer>str1=buildCombination(expression.substring(0,i),dp);
                List<Integer>str2=buildCombination(expression.substring(i+1),dp);         
                for(int num1 : str1){

                    for(int num2 : str2){

                        if(operator=='+')
                            combinationList.add((num1+num2));
                        else if(operator=='-')
                            combinationList.add((num1-num2));
                        else
                            combinationList.add((num1*num2));

                    }
                }
            }
        }        
    if(combinationList.isEmpty())
        combinationList.add(Integer.parseInt(expression));

    dp.put(expression,combinationList);

    return combinationList;
        



    }
}
