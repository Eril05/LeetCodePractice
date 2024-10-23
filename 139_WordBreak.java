
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

//Solution 1  Top down Approach
class Solution {
    //O(n * m * k) TC, where n is length of input string, m is number of words in dict and k is average size of substrings and O(n) SC
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp to store the word breaks possibilities at each character
        //True if word break possible at that index
        boolean[] dp = new boolean[s.length() + 1];

        //Base case
        dp[0] = true; //For empty string

        //For each character in string
        for(int i = 1; i <= s.length(); i++) {
            //For each word in dictionary
            for(String word: wordDict) {
                //Start will be current index subtracted by current word length
                int start = i - word.length();
                //If starting index is greater than 0 and a word break was possible at start indx and the substring from start to i is equal to the current word, then we set the value of dp at this index to true and break
                if(start >= 0 && dp[start] && s.substring(start, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //Finally, return value of s.length()'s index, indicating we were able to do a word break at that index
        return dp[s.length()];
    }
}
//Solution 2 Bottom Up Approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int slen=s.length();
        boolean []dp=new boolean[slen+1];
        dp[slen]=true;
        for(int i=slen-1;i>=0;i--){

            for(String word: wordDict){

                int lenWord=word.length();
                
                if((slen-i)>=lenWord && word.equals(s.substring(i,i+lenWord))){
                    dp[i]=dp[i+lenWord];
                    if(dp[i])
                        break;
                }
            }
        }

        return dp[0];
        
    }
}
