/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        HashMap<Integer,List<Integer>> hmap=new HashMap<>();
        List<List<Integer>>ans=new ArrayList<>();

        if(root==null)
            return ans;
        int level=zigzagImpl(root,0,hmap);
        boolean zigzagCheck=false;

        for(int i=0;i<=level;i++){

            if(zigzagCheck)
                Collections.reverse(hmap.get(i));
            zigzagCheck=!zigzagCheck;
            ans.add(hmap.get(i));
        }

        return ans;

    }

    public int zigzagImpl(TreeNode root,int level,HashMap<Integer,List<Integer>> hmap){


        int maxLevel=level;
        List<Integer>temp=hmap.getOrDefault(level,new ArrayList<>());
        temp.add(root.val);
        hmap.put(level,temp);
        if(root.left!=null)
         maxLevel=Math.max(maxLevel,zigzagImpl(root.left,level+1,hmap));
        if(root.right!=null)
         maxLevel=Math.max(maxLevel,zigzagImpl(root.right,level+1,hmap));

         return maxLevel;
    }
}
