class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            // Check if token is an operator
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int a = st.pop();
                int b = st.pop();

                int c = 0;

                if (token.equals("+")) {
                    c = b + a;
                } 
                else if (token.equals("-")) {
                    c = b - a;
                } 
                else if (token.equals("*")) {
                    c = b * a;
                } 
                else if (token.equals("/")) {
                    c = b / a;
                }

                st.push(c);

            } else {
                // Number
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}