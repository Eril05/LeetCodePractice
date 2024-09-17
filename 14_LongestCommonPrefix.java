/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {

        int minLength=Integer.MAX_VALUE;
        String smallestString="";
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
                smallestString=strs[i];
            }
        }
        if(minLength==0)
             return "";

        for(int i=0;i<minLength;i++){

            for(int j=0;j<strs.length;j++){

                if(strs[j].charAt(i)!=smallestString.charAt(i))
                    return smallestString.substring(0,i);
                
            }

        }

        return smallestString;
        
    }
}
