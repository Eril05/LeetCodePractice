/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/
class Solution {
    public boolean isPalindrome(String s) {

       s=s.toLowerCase().trim().replaceAll("[^a-z0-9]","") ;
        if(s.length()==0)
            return true;
     //   System.out.println(s);
        int start=0;
        int end=s.length()-1;

        while(start<=end){

            // while(!((s.charAt(start)>=97 && s.charAt(start)<=122) || (s.charAt(start)>=48 && s.charAt(start)<=57)) && (start<end) ){
            //     start++;
            //   //  System.out.println(s.charAt(start));
            // }
            // while(!((s.charAt(end)>=97 && s.charAt(end)<=122) || (s.charAt(end)>=48 && s.charAt(end)<=57)) && (end>start) ){
            //     end--;
            //   //  System.out.println(s.charAt(end));
            // }
          //  System.out.println(start+" "+end);
            if(s.charAt(start)!=s.charAt(end)){
               return false;
            }
                start++;
                end--;
        }



        return true;
        
    }
}
