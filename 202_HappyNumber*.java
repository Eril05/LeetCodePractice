/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1
*/
//Fastest Solution based on Observation
class Solution {
    public boolean isHappy(int n) {

      while(n/10!=0 || n==7){
        n=square(n);
        
      }
      if(n==1)
            return true;

        return false;
        
    }

      public int square(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }
}

//Solution 2

class Solution {
    public boolean isHappy(int n) {

        boolean ans=false;

        HashSet<Integer>hset=new HashSet<>();
        while(!hset.contains(n)){

            if(n==1){
                ans=true;
                break;
            }
            hset.add(n);

            int num=0;
            while(n>0){
                int value=(n%10);
                num+=(value*value);
                n=n/10;
            }
            n=num;
        }

        return ans;
        
    }
}

//This solution is creative

class Solution {
    public boolean isHappy(int n) {

        int slow=square(n);
        int fast=square(square(n));

        while(slow!=fast && fast!=1){

            slow=square(slow);
            fast=square(square(fast));
        }
        if(slow==1 || fast==1)
            return true;
        return false;
        
    }

      public int square(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }
}
