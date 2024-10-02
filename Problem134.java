//TC: O(n)
//SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize the result array to -1 by default
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array twice to simulate the circular array
        for (int i = 0; i < 2 * n; i++) {
            int currentIdx = i % n;
            
            // While the current element is greater than the element represented by the index at the top of the stack
            while (!stack.isEmpty() && nums[currentIdx] > nums[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = nums[currentIdx];
            }
            
            // Only push indices from the first traversal (i < n)
            if (i < n) {
                stack.push(currentIdx);
            }
        }
        
        return result;
    }
}
