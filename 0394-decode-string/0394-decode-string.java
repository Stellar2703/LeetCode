import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        int index = 0;

        while (index < len) {
            char c = s.charAt(index++);

            if (c == ']') {

                // Extract substring
                sb.setLength(0);
                while (st.peek() != '[') {
                    sb.append(st.pop());
                }

                String str = sb.reverse().toString(); // correct order

                st.pop(); // remove '['

                // Extract number
                StringBuilder numStr = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    numStr.append(st.pop());
                }

                int n = Integer.parseInt(numStr.reverse().toString());

                // Push repeated string back to stack
                for (int i = 0; i < n; i++) {
                    for (char ch : str.toCharArray()) {
                        st.push(ch);
                    }
                }

            } else {
                st.push(c);
            }
        }

        // Build final answer
        sb.setLength(0);
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}