/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
public class Trie{

    public Trie[] trieChild;
    public String word;

    public Trie(){
        trieChild=new Trie[26];
        word=null;
    }

    public void add(String word){
        Trie curr=this;
        
        for(int i=0;i<word.length();i++){

            int ind=word.charAt(i)-'a';

            if(curr.trieChild[ind]==null)
                curr.trieChild[ind]=new Trie();
            curr=curr.trieChild[ind];
        }
        curr.word=word;
    }

    
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie root=new Trie();
        for(String w: words)
            root.add(w);

        List<String>ans=new ArrayList<>();

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            helpFindWords(root,board,ans,i,j);
        
        return ans;
    }

    public void helpFindWords(Trie root,char[][]board,List<String> ans
    ,int row, int col){

        
            if( row>=board.length || col>=board[0].length || row<0 || col<0
            || board[row][col]=='#' || root.trieChild[board[row][col]-'a']==null)
                return;
            
            char c=board[row][col];
            
            root=root.trieChild[board[row][col]-'a'];
            board[row][col]='#';
            if(root.word!=null){
                ans.add(root.word);
                root.word=null;
            }

            helpFindWords(root,board,ans,row+1,col);
            helpFindWords(root,board,ans,row-1,col);
            helpFindWords(root,board,ans,row,col+1);
            helpFindWords(root,board,ans,row,col-1);
    
            board[row][col]=c;

    }
}
