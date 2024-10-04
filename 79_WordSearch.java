/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

*/
class Solution {
    public boolean exist(char[][] board, String word) {

        int visited[][]=new int[board.length][board[0].length];
        char ss[]=word.toCharArray();
         for(int i=0;i<board.length;i++){

                for(int j=0;j<board[0].length;j++){

                    if(board[i][j]==ss[0]){


                        if(helper(visited,board,i,j,ss,0))
                            return true;
                    }
                }
            }
            return false;
        
    }

    public boolean helper(int[][]visited, char[][]board, int row,int col, char []word, int index){

        int rowlen=board.length;
        int collen=board[0].length;

         if(row<0 || row>=rowlen || 
            col<0 || col>=collen || visited[row][col]==1 || board[row][col]!=word[index])
        return false;

        if(index==word.length-1)
            return true;

       // boolean check=false;
        // int[]dy={1,0,-1,0};
        // int []dx={0,1,0,-1};


            visited[row][col]=1;
        // for(int i=0;i<dy.length;i++){
            
        //     int newrow=row+dx[i];
        //     int newcol=col+dy[i]; 
          

                if(helper(visited,board,row,col+1,word,index+1)||
                    helper(visited,board,row+1,col,word,index+1)||
                    helper(visited,board,row,col-1,word,index+1)||
                    helper(visited,board,row-1,col,word,index+1))
                    return true;
                
        
     //   }
            visited[row][col]=0;
        
        return false;
        
           
    }
}
