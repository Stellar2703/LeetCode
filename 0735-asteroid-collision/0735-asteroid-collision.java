class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean dest = false;

            while (!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0) {
                int c = st.peek();

                if (-asteroids[i] == c) {
                    st.pop();
                    dest = true;   // ✅ FIX
                    break;
                } 
                else if (-asteroids[i] > c) {
                    st.pop();
                } 
                else {
                    dest = true;
                    break;
                }
            }

            if (!dest) {
                st.push(asteroids[i]);
            }
        }

        int[] arr = new int[st.size()];
        for (int i = arr.length - 1; i >= 0; i--) {   // ✅ FIX
            arr[i] = st.pop();
        }

        return arr;
    }
}