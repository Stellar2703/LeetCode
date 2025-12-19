class Solution {
    public int largestRectangleArea(int[] heights) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int [] pse = new int[n];
        int [] nse = new int[n];
        for (int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? 0 : st.peek()+1;
            st.push(i);
        }
        st.clear();
        for (int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // for (int i=0;i<=n-1;i++){
        //     System.out.print(nse[i]+" ");
        // }
        // System.out.println();
        // for (int i=0;i<=n-1;i++){
        //     System.out.print(pse[i]+" ");  
        // }
        int max_area = 0;
        for (int i=0;i<=n-1;i++){
            int area = (heights[i]*(nse[i]-pse[i]));
            max_area = Math.max(area,max_area);
        }
        return max_area;
    }
}