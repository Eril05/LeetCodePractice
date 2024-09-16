/*
Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".
*/

class Solution {
    public int findMinDifference(List<String> timePoints) {

        PriorityQueue<Integer>pque=new PriorityQueue<>();
        int minimumTimeDiff=Integer.MAX_VALUE;

        for(int i=0;i<timePoints.size();i++){

            int minutes=convertToMinutes(timePoints.get(i));

            pque.add(minutes);
        }
        int first=pque.poll();
        int prev=first;

        while(!pque.isEmpty()){

            int curr=pque.poll();
            minimumTimeDiff=Math.min(curr-prev,minimumTimeDiff);
            prev=curr;
        }

        //Dealing with cricular time edge scenario
         minimumTimeDiff=Math.min(1440-prev+first,minimumTimeDiff);

         return minimumTimeDiff;
    }

    public int convertToMinutes(String time){

        String []hourMin=time.split(":");
        int totalMin=Integer.parseInt(hourMin[0])*60+Integer.parseInt(hourMin[1]);
        return totalMin;
    }
}
