class Solution {
    public long minimumRemoval(int[] beans) {
       Arrays.sort(beans);
       int n = beans.length;
       long [] prefix = new long[n];
       prefix[0] = beans[0];
       for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+beans[i]*1L;
       }
       System.out.println(Arrays.toString(prefix));
       long min = Long.MAX_VALUE;
       for(int i =0;i<n;i++){
        long left = i>0 ? prefix[i-1]*1L:0*1L;
        long right = (prefix[n-1]-prefix[i]) - ((n-i-1)*1L*beans[i]);
        long total = left +right;
        System.out.println(total);
        min = Math.min(min,total);
       }
       return min;
    }
}