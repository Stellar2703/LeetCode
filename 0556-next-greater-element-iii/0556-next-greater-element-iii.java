class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int t = n;
        int max = n%10;
        while(t>0){
            if(t%10<max){
                break;
            }
            arr.add(t%10);
            max = t%10;
            t=t/10;
        }
        if(t<=0) return -1;
        int swap = t%10;
        t=t/10;
        Collections.sort(arr);
        for(int i =0;i<arr.size();i++){
            if(arr.get(i)>swap){
                int temp = swap;
                swap = arr.get(i);
                arr.set(i,temp);
                break;
            }
        }
        long ans = t;
        ans = ans*10 + swap;
        for(int i =0;i<arr.size();i++){
            ans*=10;
            ans+=arr.get(i);
        }
         if (ans > Integer.MAX_VALUE)
            return -1;

        return (int) ans;
    }
}