//TC: O(n)
//SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        if (temperatures == null || temperatures.length == 0)
            return answer;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // Check if the current temperature is warmer than the one at the stack's top
            // index
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop(); // Pop the index from the stack
                answer[prevDay] = i - prevDay; // Calculate how many days it took to get warmer
            }
            // Push the current day's index onto the stack
            stack.push(i);
        }

        // Any remaining elements in the stack don't have a warmer day in the future, so
        // they stay 0
        return answer;
    }
}
