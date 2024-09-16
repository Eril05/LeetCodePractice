/*
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {

        public int left=0;
        public int right=0;
    public String longestPalindrome(String s) {

        int sLength=s.length();
        if(sLength==1)
            return s;
        for(int i=0;i<sLength-1;i++){

            CalculateLengthOfPalindrome(s,i,i,sLength);
             CalculateLengthOfPalindrome(s,i,i+1,sLength);
            
        }
        return s.substring(left,right);
        
    }

    public void CalculateLengthOfPalindrome(String s,int start,int end,int sLength){

        while(start>=0 && end<sLength && s.charAt(start)==s.charAt(end)){


                start--;
                end++;
        }
        if((right-left)<(end-start-1)){
            right=end;
            left=start+1;
        }

    }
}
