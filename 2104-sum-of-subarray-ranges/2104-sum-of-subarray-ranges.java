class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        int[] pge = new int[n];
        int[] nge = new int[n];

        Arrays.fill(nse,n);
        Arrays.fill(pse,-1);
        Arrays.fill(nge,n);
        Arrays.fill(pge,-1);

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty()){
                if(nums[st.peek()]<nums[i]){
                    pse[i] = st.peek();
                    break;
                }
                else st.pop();
            }
            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()){
                if(nums[st.peek()]<=nums[i]){
                    nse[i] = st.peek();
                    break;
                }
                else{
                    st.pop();
                }
            }
            st.push(i);
        }

        st.clear();

        for(int i=0;i<n;i++){
            while(!st.isEmpty()){
                if(nums[st.peek()]>nums[i]){
                    pge[i] = st.peek();
                    break;
                }
                else st.pop();
            }
            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()){
                if(nums[st.peek()]>=nums[i]){
                    nge[i] = st.peek();
                    break;
                }
                else{
                    st.pop();
                }
            }
            st.push(i);
        }


        long sum =0;

        for(int i=0;i<n;i++){
            long smallest = (long) ((i-pse[i]) * (nse[i]-i)) * nums[i];
            long largest = (long)((i-pge[i]) * (nge[i]-i)) * nums[i];
            sum+= (largest-smallest);
        }

        return sum;
    }
}