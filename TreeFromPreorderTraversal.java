import java.util.*;

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();
        
        while (i < n) {
            int depth = 0;
            // Count the number of dashes to determine the depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            
            // Extract the node value
            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            TreeNode node = new TreeNode(value);
            
            // Maintain the correct depth by popping elements
            while (stack.size() > depth) {
                stack.pop();
            }
            
            // Attach the new node to its parent
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            
            // Push the current node onto the stack
            stack.push(node);
        }
        
        // The root is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.peek();
    }
}
