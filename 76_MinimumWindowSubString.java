/*
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 
*/


class Solution {
    public String minWindow(String s, String t) {

        if(t.equals("") || s.length()<t.length())
            return "";

        int start=0;
        int minWindow[]={0,Integer.MAX_VALUE};

        HashMap<Character,Integer>frequency=new HashMap<>();

        HashMap<Character,Integer>tfrequency=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            tfrequency.put(c,tfrequency.getOrDefault(c,0)+1);
        }
        int needed=tfrequency.size();
        int have=0;

        for(int end=0;end<s.length();end++){
            
            char c=s.charAt(end);
            if(tfrequency.containsKey(c)){
                frequency.put(c,frequency.getOrDefault(c,0)+1);
                if((tfrequency.get(c)).equals(frequency.get(c))){
                    have++;
                }
            }
            
            while(needed==have){
                char ch=s.charAt(start);
                int winSize=end-start;
                if((minWindow[1]-minWindow[0])>winSize){
                    minWindow[1]=end;
                    minWindow[0]=start;
                }

                if(frequency.containsKey(ch)){
                    frequency.put(ch,frequency.get(ch)-1);
                
                    if(frequency.get(ch)<tfrequency.get(ch))
                        have--;
                }

                start++;

            }
        }
         
     return   (minWindow[1]==Integer.MAX_VALUE) ? "": s.substring(minWindow[0],minWindow[1]+1);
        
    }
}
