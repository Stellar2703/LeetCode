class Solution {
    public int largest(int[] heights) {
    int n = heights.length;

    int[] pse = new int[n];
    int[] nse = new int[n];

    Stack<Integer> st = new Stack<>();

    // Previous Smaller Element
    for(int i = 0; i < n; i++) {
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
            st.pop();
        }

        pse[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }

    st.clear();

    // Next Smaller Element
    for(int i = n - 1; i >= 0; i--) {
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
            st.pop();
        }

        nse[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }

    int maxArea = 0;

    for(int i = 0; i < n; i++) {
        int width = nse[i] - pse[i] - 1;
        maxArea = Math.max(maxArea, heights[i] * width);
    }

    return maxArea;
}
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]arr = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[i][j]=1;
                }
                if(i>0 && matrix[i][j]=='1'){
                    arr[i][j]+=arr[i-1][j];
                }
            }
        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,largest(arr[i]));
        }
        return ans;
    }
}