/*

Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row=0;
        int col=0;
        int dx=0;
        int dy=1;
        int rowLength=matrix.length;
        int colLength=matrix[0].length;

        List<Integer>spiralList=new ArrayList<>();

        for(int i=0;i<(rowLength*colLength);i++){

            spiralList.add(matrix[row][col]);
            matrix[row][col]=-101;

            if( 0>row+dx || row+dx>=rowLength || 0>col+dy || col+dy>=colLength || matrix[row+dx][col+dy]==-101 ){

                int temp=dx;
                dx=dy;
                dy=-temp;
            }
            row+=dx;
            col+=dy;
        }

        return spiralList;
        
    }
}
