/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

     ArrayList<Integer>[]graph=new ArrayList[numCourses];
    int count=0;
    for(int j=0;j<numCourses;j++)
        graph[j]=new ArrayList<>();    


    for(int i=0;i<prerequisites.length;i++){

        graph[prerequisites[i][1]].add(prerequisites[i][0]);
    }



    int[] indegree=new int[numCourses];

     for(int i=0;i<numCourses;i++){

        for(int j=0;j<graph[i].size();j++){

            indegree[graph[i].get(j)]+=1;
            count++;
            
        }

     }  


     Queue<Integer>queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){

            if(indegree[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){

            int element=queue.poll();
            ArrayList<Integer>temp=graph[element];

            for(int num : temp){
                indegree[num]-=1;
                count--;
                if(indegree[num]==0)
                    queue.offer(num);
            }

        }

        if(count>0)
            return false;
        
        return true;
    }
}
