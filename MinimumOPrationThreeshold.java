import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Min heap to always access the smallest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all elements to the min heap
        for (int num : nums) {
            minHeap.add(num);
        }
        
        int operations = 0;
        
        // Process until all elements in the heap are >= k
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            int x = minHeap.poll(); // Smallest element
            int y = minHeap.poll(); // Second smallest element
            
            // Perform the operation and insert the new value back into the heap
            int newElement = (x * 2) + y;
            minHeap.add(newElement);
            
            operations++;
        }
        
        return operations;
    }
}
