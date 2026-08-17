class Solution {
    int[] pre;
    Integer[][] dp;

    public int f(int l, int r) {
        int ans = 0;
        if(dp[l][r]!=null) return dp[l][r];
        for (int mid = l; mid < r - 1; mid++) {
            int left = pre[mid] - (l > 0 ? pre[l - 1] : 0);
            int right = pre[r - 1] - pre[mid];
            if (left > right) {
                ans = Math.max(ans, right + f(mid + 1,r));
            } else if (left < right) {
                ans = Math.max(ans, left + f(l,mid+1));
            } else {
                ans = Math.max(ans,
                        Math.max(
                                left + f(l, mid + 1),
                                right + f(mid + 1, r)));
            }
        }
        return dp[l][r] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n+1][n+1];
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            int prev = i > 0 ? pre[i - 1] : 0;
            pre[i] = stoneValue[i] + prev;
        }

        return f(0, n);
    }
}