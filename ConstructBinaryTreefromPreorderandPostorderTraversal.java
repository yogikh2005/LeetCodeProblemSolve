import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    private Map<Integer, Integer> postIndexMap;
    private int preIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        preIndex = 0;
        
        // Store postorder values and their indices in a HashMap
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int left, int right) {
        if (left > right || preIndex >= preorder.length) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        if (left == right) return root; // Leaf node
        
        int leftSubtreeRootIndex = postIndexMap.get(preorder[preIndex]);
        
        root.left = construct(preorder, postorder, left, leftSubtreeRootIndex);
        root.right = construct(preorder, postorder, leftSubtreeRootIndex + 1, right - 1);
        
        return root;
    }
}
/*
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

 

Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]
 

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
*/
