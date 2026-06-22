// Striver 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse,-1);
        int[] nse= new int[n];
        Arrays.fill(nse,n);
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty()){
                if(arr[st.peek()]<arr[i]){
                    pse[i] = st.peek();
                    break;
                }
                else{
                st.pop();
                }
            }
            st.push(i);
        }
        st.clear();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty()){
                if(arr[st.peek()]<=arr[i]){
                    nse[i] = st.peek();
                    break;
                }
                else{
                    st.pop();
                }
            }
            st.push(i);
        }

        long mod = 1_000_000_007L;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            sum = (sum + left * right * arr[i]) % mod;
        }

        return (int) sum;
    }
}