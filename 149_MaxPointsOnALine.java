/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
*/
class Solution {
    public int maxPoints(int[][] points) {

        
        int ans=1;
        HashMap<Double,Integer>frequency=new HashMap<>();

        for(int i=0;i<points.length-1;i++){

            

            for(int j=i+1;j<points.length;j++){

               
                double numerator= points[i][1]-points[j][1];
                double denominator= points[i][0]-points[j][0];
                double slope=1000001;
                if(denominator!=0){
                    slope=numerator/denominator;
                }
                if(slope==-0.0)
                    slope=0.0;
                frequency.put(slope,frequency.getOrDefault(slope,0)+1);
                ans=Math.max(frequency.get(slope)+1,ans);
            }
            frequency.clear();
        }
            return ans;
    }
}
