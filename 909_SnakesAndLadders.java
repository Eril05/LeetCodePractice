/*
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

 

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 are not the starting points of any snake or ladder.
*/
class Solution {
    public int snakesAndLadders(int[][] board) {

        Queue<Integer>queue=new LinkedList<>();
        int n=board.length;   

        boolean visited[]=new boolean[(n*n)+1];

        queue.add(1);

        return findMinMove(queue,board,visited,n);
        
    }

    public int findMinMove(Queue<Integer>queue,int[][]board,boolean[]visited,int n){
        
        int minSteps=0;
        visited[1]=true;

        while(!queue.isEmpty()){

            int qSize=queue.size();
            for(int j=0;j<qSize;j++){

                int num=queue.poll();
                if(num==n*n) return minSteps;

                for(int i=num+1;i<=num+6;i++){

                    if(i>(n*n))
                        break;

                if(visited[i])continue;

                int []cell=findCordinates(i,n);
                int row=cell[0];
                int col=cell[1];

                

                    visited[i]=true;

                if(board[row][col]==-1){
                    queue.add(i);
                }
                else
                    queue.add(board[row][col]);                
                    
                }
            }
            minSteps++;
        }

       return -1; 
    }

    public int[] findCordinates(int num,int n){

        int row=0;
        int col=0;
        int result[]=new int[2];
        row=n-((num+(n-1))/n);
        col=(num-1)%n;

        if(n%2!=0)
            row++;
        if(row%2==0)
            col=n-col-1;

        if(n%2!=0)
            row--;
        result[0]=row;
        result[1]=col;

    return result;
        }

       
    
}
